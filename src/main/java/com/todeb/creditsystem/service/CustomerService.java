package com.todeb.creditsystem.service;

import com.todeb.creditsystem.domain.Customer;
import com.todeb.creditsystem.model.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto getById(Integer id);

    CustomerDto createCustomer(CustomerDto customer);

    void deleteCustomer(Integer id);

    CustomerDto updateCustomer(Integer id, CustomerDto customerDto);

    Customer getCustomerByIdentityNumber(String identityNumber);

    List<CustomerDto> getAllCustomers();
}
