package com.todeb.creditsystem.service.impl;

import com.todeb.creditsystem.converter.CreditApplicationConverter;
import com.todeb.creditsystem.enums.CreditStatus;
import com.todeb.creditsystem.exception.CreditApplicationAlreadyExistException;
import com.todeb.creditsystem.domain.CreditApplication;
import com.todeb.creditsystem.domain.Customer;
import com.todeb.creditsystem.exception.CreditApplicationNotFoundException;
import com.todeb.creditsystem.repository.CreditApplicationRepository;
import com.todeb.creditsystem.service.CreditScoreService;
import com.todeb.creditsystem.service.CreditApplicationService;
import com.todeb.creditsystem.service.CustomerService;
import com.todeb.creditsystem.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreditApplicationServiceImpl implements CreditApplicationService {

    private final CustomerService customerService;
    private final CreditApplicationRepository creditApplicationRepository;
    private final CreditScoreService creditScoreService;
    private final CreditApplicationConverter creditApplicationConverter;
    private final MessageService messageService;

    @Override
    public List<CreditApplication> getAllCreditApplications() {
        log.debug("REST request to get credit applications ");
        return creditApplicationRepository.findAll();
    }


    @Override
    @Transactional
    public CreditStatus creditApplication(String identityNumber) {
        log.debug("REST request to create credit application By identityNumber : {}", identityNumber);
        boolean existsCredit = creditApplicationRepository.existsCreditApplicationByCustomer_IdentityNumber(identityNumber);
        if (existsCredit) {
            throw new CreditApplicationAlreadyExistException(identityNumber);
        }

        Customer customer = customerService.getCustomerByIdentityNumber(identityNumber);
        BigDecimal limit = calculateCreditLimit(customer);
        CreditApplication creditApplication = creditApplicationConverter.convert(customer, limit);
        messageService.sendMessage(creditApplication);
        return creditApplicationRepository.save(creditApplication).getStatus();

    }

    @Override
    public CreditApplication getCreditApplication(String identityNumber) {
        log.debug("REST request to get By identityNumber : {}", identityNumber);
        return creditApplicationRepository.findCreditApplicationByCustomer_IdentityNumber(identityNumber)
                .orElseThrow(() -> new CreditApplicationNotFoundException(identityNumber));

    }

    private BigDecimal calculateCreditLimit(Customer customer) {

        int creditScore = creditScoreService.getCreditScoreByCustomerIdentityNumber(customer.getIdentityNumber());

        if (creditScore < 500) {
            return BigDecimal.ZERO;
        }

        if (creditScore < 1_000) {
            if (customer.getMonthlyIncome().compareTo(BigDecimal.valueOf(5_000)) < 0) {
                return BigDecimal.valueOf(10_000);
            }
            return BigDecimal.valueOf(20_000);

        }

        return customer.getMonthlyIncome().multiply(BigDecimal.valueOf(4));

    }


}
