package com.todeb.creditsystem.service;

import com.todeb.creditsystem.domain.CreditApplication;
import com.todeb.creditsystem.enums.CreditStatus;

import java.util.List;

public interface CreditApplicationService {

    List<CreditApplication> getAllCreditApplications();

    CreditStatus creditApplication(String identityNumber);

    CreditApplication getCreditApplication(String identityNumber);
}
