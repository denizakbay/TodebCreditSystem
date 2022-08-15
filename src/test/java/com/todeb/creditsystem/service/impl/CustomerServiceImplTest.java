package com.todeb.creditsystem.service.impl;

import com.todeb.creditsystem.converter.CustomerDtoConverter;
import com.todeb.creditsystem.model.CustomerDto;
import com.todeb.creditsystem.repository.CustomerRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;
//    @Mock
//    private CreditScoreService creditScoreService;
//    @Mock
//    private CustomerConverter customerConverter;
    @Mock
    private CustomerDtoConverter customerDtoConverter;
    @InjectMocks
    private CustomerServiceImpl underTest;



    @Test
    void canGetAllCustomers() {
        // when
        underTest.getAllCustomers();

        // then
        verify(customerRepository).findAll();
    }

    @Test

    void canGetById() {

        // given
        Integer id = 10;
        CustomerDto customerDto = CustomerDto.builder()
                .identityNumber("11111111110")
                .firstName("deniz")
                .lastName("akbay")
                .monthlyIncome(BigDecimal.valueOf(15_000))
                .phone("05378880833")
                .build();
/*
        // when
        when(customerRepository.findById(id))
                .thenReturn(customerDto);
        CustomerDto expected = underTest.getById(customer.getId());

        // then
        assertThat(expected).isSameAs(customer);
        verify(customerRepository).findById(customer.getId());

 */

    }

    @Test
    @Disabled
    void createCustomer() {
    }

    @Test
    @Disabled
    void deleteCustomer() {
    }

    @Test
    @Disabled
    void updateCustomer() {
    }

    @Test
    @Disabled
    void getCustomerByIdentityNumber() {
    }

}