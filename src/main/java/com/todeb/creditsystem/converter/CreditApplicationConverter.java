package com.todeb.creditsystem.converter;

import com.todeb.creditsystem.domain.CreditApplication;
import com.todeb.creditsystem.domain.Customer;
import com.todeb.creditsystem.enums.CreditStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CreditApplicationConverter {
    public CreditApplication convert(Customer customer, BigDecimal limit) {

        return CreditApplication.builder()
                .status(limit.equals(BigDecimal.ZERO) ? CreditStatus.REJECTED : CreditStatus.ACCEPTED)
                .creditLimit(limit)
                .customer(customer)
                .build();
    }

}
