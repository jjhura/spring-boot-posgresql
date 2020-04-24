package service;

import dto.request.LoyaltyCardRequestDto;
import dto.request.TransactionRequestDto;
import entity.LoyaltyCard;

public interface LoyaltyCardService {
    LoyaltyCard updatePointForCard(TransactionRequestDto transactionRequestDto) throws Exception;
}
