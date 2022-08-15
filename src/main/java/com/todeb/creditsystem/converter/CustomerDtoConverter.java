package com.todeb.creditsystem.converter;

import com.todeb.creditsystem.domain.Customer;
import com.todeb.creditsystem.model.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class CustomerDtoConverter implements Function<Customer, CustomerDto> {

    @Override
    public CustomerDto apply(Customer customer) {
        return CustomerDto.builder()
                .identityNumber(customer.getIdentityNumber())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .monthlyIncome(customer.getMonthlyIncome())
                .phone(customer.getPhone())
                .build();
    }


    public List<CustomerDto> applyToList(List<Customer> customers) {
        return customers.stream().map(this).collect(Collectors.toList());
    }
}
