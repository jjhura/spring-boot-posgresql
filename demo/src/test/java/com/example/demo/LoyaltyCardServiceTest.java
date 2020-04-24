package com.example.demo;

import dto.request.TransactionRequestDto;
import entity.ConfigPoint;
import entity.LoyaltyCard;
import entity.LoyaltyCardType;
import entity.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import repository.ConfigPointRepository;
import repository.LoyaltyCardRepository;
import repository.LoyaltyCardTypeRepository;
import repository.TransactionRepository;
import service.impl.LoyaltyCardServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LoyaltyCardServiceTest {
    @InjectMocks
    private LoyaltyCardServiceImpl loyaltyCardService;

    @Mock
    LoyaltyCardRepository loyaltyCardRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private ConfigPointRepository configPointRepository;

    @Mock
    private LoyaltyCardTypeRepository loyaltyCardTypeRepository;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    private LocalDateTime now = LocalDateTime.now();

    public List<LoyaltyCardType> dummyDataLoyaltyCardType(){
        List<LoyaltyCardType> loyaltyCardTypes = new ArrayList<>();
        LoyaltyCardType loyaltyCardType = new LoyaltyCardType();
        loyaltyCardType.setId(1l);
        loyaltyCardType.setCreateOn(now);
        loyaltyCardType.setDiscountPercent(1.0);
        loyaltyCardType.setDuration(365l);
        loyaltyCardType.setModifiedOn(now);
        loyaltyCardType.setName("normal");
        loyaltyCardType.setSpentThreshold(0.0);
        loyaltyCardTypes.add(loyaltyCardType);

        LoyaltyCardType loyaltyCardType1 = new LoyaltyCardType();
        loyaltyCardType1.setId(2l);
        loyaltyCardType1.setCreateOn(now);
        loyaltyCardType1.setDiscountPercent(2.0);
        loyaltyCardType1.setDuration(365l);
        loyaltyCardType1.setModifiedOn(now);
        loyaltyCardType1.setName("sliver");
        loyaltyCardType1.setSpentThreshold(5000000.00);

        loyaltyCardTypes.add(loyaltyCardType1);
        return  loyaltyCardTypes;
    }

    public ConfigPoint dummyDataConfigPoint(){
        ConfigPoint configPoint = new ConfigPoint();
        configPoint.setId(1l);
        configPoint.setConfigOld(1000.00);
        configPoint.setConfig(100.00);
        configPoint.setCreateOn(now);
        return configPoint;
    }

    public LoyaltyCard dummyDataLoyaltyCard(){
        LoyaltyCard loyaltyCard = new LoyaltyCard();
        loyaltyCard.setId(1l);
        loyaltyCard.setEndDate(now);
        loyaltyCard.setStartDate(now);
        loyaltyCard.setModifiedOn(now);
        loyaltyCard.setTotalSpent(2000000.00);
        loyaltyCard.setLoyaltyCardType(dummyDataLoyaltyCardType().get(0));
        loyaltyCard.setPoint(20000.00);
        loyaltyCard.setCode("LT00001");
        loyaltyCard.setPhone("0123456789");
        return loyaltyCard;
    }

    public Transaction dummyDataTransaction(){
        Transaction transaction = new Transaction();
        transaction.setCreateOn(now);
        transaction.setPointAdjust(500000.00);
        transaction.setLoyaltyCard(dummyDataLoyaltyCard());
        transaction.setSpentAdjust(5000000.00);
        transaction.setId(1l);
        return transaction;

    }

    @Test
    public void updatePointForCard() throws Exception {
        Mockito.when(loyaltyCardRepository.findById(Mockito.any())).thenReturn(Optional.of(dummyDataLoyaltyCard()));
        Mockito.when(loyaltyCardTypeRepository.findAll()).thenReturn(dummyDataLoyaltyCardType());
        Mockito.when(configPointRepository.findAll()).thenReturn(Arrays.asList(dummyDataConfigPoint()));
        TransactionRequestDto transactionRequestDto = new TransactionRequestDto();
        transactionRequestDto.setLoyaltyCardId(1l);
        transactionRequestDto.setSpentAdjust(5000000.00);
        LoyaltyCard loyaltyCard = loyaltyCardService.updatePointForCard(transactionRequestDto);
        Assert.assertEquals(loyaltyCard.getTotalSpent(),7000000.00,0.0);
        Assert.assertEquals(2l,loyaltyCard.getLoyaltyCardType().getId(),0);
    }


}
