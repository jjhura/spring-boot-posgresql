package service.impl;

import dto.request.LoyaltyCardRequestDto;
import dto.request.TransactionRequestDto;
import entity.ConfigPoint;
import entity.LoyaltyCard;
import entity.LoyaltyCardType;
import entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ConfigPointRepository;
import repository.LoyaltyCardRepository;
import repository.LoyaltyCardTypeRepository;
import repository.TransactionRepository;
import service.LoyaltyCardService;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class LoyaltyCardServiceImpl implements LoyaltyCardService {
    @Autowired
    LoyaltyCardRepository loyaltyCardRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ConfigPointRepository configPointRepository;

    @Autowired
    private LoyaltyCardTypeRepository loyaltyCardTypeRepository;

    DecimalFormat df = new DecimalFormat("####0.00");

    @Override
    public LoyaltyCard updatePointForCard(TransactionRequestDto transactionRequestDto) throws Exception {

        Optional<LoyaltyCard> data = loyaltyCardRepository.findById(transactionRequestDto.getLoyaltyCardId());
        if(!data.isPresent()){
            throw new Exception("not found LoyaltyCard");
        }
        LocalDateTime now = LocalDateTime.now();
        LoyaltyCard loyaltyCard = data.get();
        //        save transaction
        Transaction transaction = new Transaction();
        transaction.setLoyaltyCard(loyaltyCard);
        transaction.setSpentAdjust(transactionRequestDto.getSpentAdjust());
        transaction.setPointAdjust(calculusPoint(transactionRequestDto.getSpentAdjust()));
        transaction.setCreateOn(now);
        transactionRepository.save(transaction);
        // update loyaltyCard based new point
        loyaltyCard.setPoint(Double.parseDouble(df.format(loyaltyCard.getPoint() + transaction.getPointAdjust())));
        loyaltyCard.setModifiedOn(now);
        loyaltyCard.setTotalSpent(loyaltyCard.getTotalSpent() + transaction.getSpentAdjust());
//        check loyaltyCardType
        LoyaltyCardType loyaltyCardType = getTypeCardMapNewPoint(loyaltyCard.getTotalSpent());
        if(loyaltyCardType.getId() != loyaltyCard.getLoyaltyCardType().getId()){
            loyaltyCard.setLoyaltyCardType(loyaltyCardType);
            loyaltyCard.setStartDate(now);
            LocalDateTime endDate = now.plusDays(loyaltyCardType.getDuration());
            loyaltyCard.setEndDate(endDate);
        }
        loyaltyCard.setModifiedOn(now);

        loyaltyCardRepository.save(loyaltyCard);

        return loyaltyCard;
    }

    public Double calculusPoint(Double spentAdjust) throws Exception {
        List<ConfigPoint> configPoints = configPointRepository.findAll();
        if(configPoints.isEmpty()){
            throw new Exception("not found LoyaltyCard");
        }
        ConfigPoint configPoint = configPoints.get(0);
        if(configPoint.getConfig() == null){
            throw new Exception("config be null");
        }
        Double point = spentAdjust / configPoint.getConfig();
        return Double.parseDouble(df.format(point));
    }

    public LoyaltyCardType getTypeCardMapNewPoint(Double spent) throws Exception {
        List<LoyaltyCardType> loyaltyCardTypes = loyaltyCardTypeRepository.findAll();
        if (loyaltyCardTypes.isEmpty()){
            throw new Exception("loyaltyCardTypes be null");
        }
        for(int i = 0 ; i < loyaltyCardTypes.size() ; i++){
            if(i == loyaltyCardTypes.size() - 1){
                return loyaltyCardTypes.get(i);
            }
            if(spent >= loyaltyCardTypes.get(i).getSpentThreshold()
                    && spent < loyaltyCardTypes.get(i+1).getSpentThreshold()){
                return loyaltyCardTypes.get(i);
            }

        }
        return null;
    }

}
