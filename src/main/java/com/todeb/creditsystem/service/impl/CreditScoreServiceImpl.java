package com.todeb.creditsystem.service.impl;

import com.todeb.creditsystem.exception.CreditScoreNotValid;
import com.todeb.creditsystem.exception.NotFoundException;
import com.todeb.creditsystem.domain.CreditScore;
import com.todeb.creditsystem.repository.CreditScoreRepository;
import com.todeb.creditsystem.service.CreditScoreService;
import com.todeb.creditsystem.utils.RandomUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditScoreServiceImpl implements CreditScoreService {

    private final CreditScoreRepository creditScoreRepository;


    @Override
    public CreditScore addCreditScore(CreditScore creditScore) {
        if(creditScore.getCreditScore()<0){
            throw new CreditScoreNotValid();
        }
        return creditScoreRepository.save(creditScore);
    }

    @Override
    public CreditScore calculateCreditScore( ) {
        CreditScore creditScore = new CreditScore();
        int randomCreditScore = RandomUtils.nextInt(2000);
        creditScore.setCreditScore(randomCreditScore);
       return creditScoreRepository.save(creditScore);
    }

    @Override
    public Integer getCreditScoreByCustomerIdentityNumber(String identityNumber) {
        CreditScore creditScore=creditScoreRepository.findCreditScoreByIdentityNumber(identityNumber);
        if (creditScore==null){
            throw new NotFoundException("Credit Score");
        }
        return creditScore.getCreditScore();
    }

}
