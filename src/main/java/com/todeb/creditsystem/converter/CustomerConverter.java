package com.todeb.creditsystem.converter;

import com.todeb.creditsystem.domain.Customer;
import com.todeb.creditsystem.model.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CustomerConverter implements Function<CustomerDto, Customer> {

    @Override
    public Customer apply(CustomerDto customerDto) {

        return Customer.builder()
                .identityNumber(customerDto.getIdentityNumber())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .monthlyIncome(customerDto.getMonthlyIncome())
                .phone(customerDto.getPhone())
                .build();
    }
}
