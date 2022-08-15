package com.todeb.creditsystem.repository;

import com.todeb.creditsystem.domain.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindCustomerByIdentityNumber() {
        // given
        String identityNumber = "11111111110";
        Customer customer = Customer.builder()
                .identityNumber(identityNumber)
                .firstName("deniz")
                .lastName("akbay")
                .monthlyIncome(BigDecimal.valueOf(15_000))
                .phone("05378880833")
                .build();
        underTest.save(customer);
        // when
        Customer expected = underTest.findByIdentityNumber(identityNumber).get();

        // then
        assertThat(expected).isEqualTo(customer);

    }


}