package com.todeb.creditsystem.service.impl;

import com.todeb.creditsystem.converter.CustomerConverter;
import com.todeb.creditsystem.converter.CustomerDtoConverter;
import com.todeb.creditsystem.exception.CustomerNotFoundException;
import com.todeb.creditsystem.exception.IdentityNumberAlreadyExistException;
import com.todeb.creditsystem.domain.CreditScore;
import com.todeb.creditsystem.domain.Customer;
import com.todeb.creditsystem.model.CustomerDto;
import com.todeb.creditsystem.repository.CustomerRepository;
import com.todeb.creditsystem.service.CreditScoreService;
import com.todeb.creditsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CreditScoreService creditScoreService;
    private final CustomerConverter customerConverter;
    private final CustomerDtoConverter customerDtoConverter;


    @Override
    public List<CustomerDto> getAllCustomers() {
        log.debug("REST request to get all Customers");
        return customerDtoConverter.applyToList(customerRepository.findAll());
    }

    @Override
    public CustomerDto getById(Integer id) {
        log.debug("REST request to get By Id : {}", id);
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id.toString()));
        return customerDtoConverter.apply(customer);
    }

    @Override
    @Transactional
    public CustomerDto createCustomer(CustomerDto customerDto) {
        log.debug("REST request to save Customer : {}", customerDto);
        Optional<Customer> byIdentityNumber = customerRepository.findByIdentityNumber(customerDto.getIdentityNumber());
        if (byIdentityNumber.isPresent()) {
            throw new IdentityNumberAlreadyExistException(customerDto.getIdentityNumber());
        }
        Customer customer = customerConverter.apply(customerDto);
        CreditScore creditScore = creditScoreService.calculateCreditScore();
        customer.setCreditScore(creditScore);
        Customer savedCustomer = customerRepository.save(customer);
        return customerDtoConverter.apply(savedCustomer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Integer customerId) {
        log.debug("REST request to delete Customer : {}", customerId);
        final Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId.toString()));
        customerRepository.delete(customer);
    }

    @Override
    public CustomerDto updateCustomer(Integer customerId, CustomerDto customerDto) {
        log.debug("REST request to update Customer : {}, {}", customerId, customerDto);
        final Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId.toString()));

        Customer savedCustomer = customerRepository.save(customer);
        return customerDtoConverter.apply(savedCustomer);
    }

    @Override
    public Customer getCustomerByIdentityNumber(String identityNumber) {
        log.debug("REST request to get Customer Identity Number : {}", identityNumber);
        return customerRepository.findByIdentityNumber(identityNumber)
                .orElseThrow(() -> new IdentityNumberAlreadyExistException(identityNumber));
    }


}
