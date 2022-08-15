package com.todeb.creditsystem.service;

import com.todeb.creditsystem.domain.CreditScore;

public interface CreditScoreService {

    CreditScore addCreditScore(CreditScore creditScore);

    CreditScore calculateCreditScore();

    Integer getCreditScoreByCustomerIdentityNumber(String identityNumber);
}
