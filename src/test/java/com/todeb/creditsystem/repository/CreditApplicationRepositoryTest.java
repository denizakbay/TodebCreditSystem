package com.todeb.creditsystem.repository;

import com.todeb.creditsystem.domain.CreditApplication;
import com.todeb.creditsystem.domain.Customer;
import com.todeb.creditsystem.enums.CreditStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CreditApplicationRepositoryTest {

    @Autowired
    private CreditApplicationRepository underTest;

    @Autowired CustomerRepository customerRepository;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindCreditApplicationByIdentityNumber() {
        // given

        String identityNumber = "11111111110";
        Customer customer = Customer.builder()
                .identityNumber(identityNumber)
                .firstName("deniz")
                .lastName("akbay")
                .monthlyIncome(BigDecimal.valueOf(15_000))
                .phone("05378880833")
                .build();
        customerRepository.save(customer);


        CreditApplication creditApplication = CreditApplication.builder()
                .status(CreditStatus.ACCEPTED)
                .creditLimit(BigDecimal.valueOf(10_000))
                .customer(customer)
                .build();
        underTest.save(creditApplication);

        // when

        CreditApplication expected = underTest.findCreditApplicationByCustomer_IdentityNumber(identityNumber).get();

        // then

        assertThat(expected).isEqualTo(creditApplication);

    }


    @Test
    void itShouldCheckWhenSearchWithIdentityNumberExists() {
        // given

        String identityNumber = "11111111110";
        Customer customer = Customer.builder()
                .identityNumber(identityNumber)
                .firstName("deniz")
                .lastName("akbay")
                .monthlyIncome(BigDecimal.valueOf(15_000))
                .phone("05378880833")
                .build();
        customerRepository.save(customer);


        CreditApplication creditApplication = CreditApplication.builder()
                .status(CreditStatus.ACCEPTED)
                .creditLimit(BigDecimal.valueOf(10_000))
                .customer(customer)
                .build();
        underTest.save(creditApplication);

        // when

        boolean expected = underTest.existsCreditApplicationByCustomer_IdentityNumber(identityNumber);

        // then

        assertThat(expected).isTrue();

    }


    @Test
    void itShouldCheckWhenSearchWithIdentityNumberDoesNotExists() {
        // given
        String identityNumber = "11111111110";

        // when

        boolean expected = underTest.existsCreditApplicationByCustomer_IdentityNumber(identityNumber);

        // then

        assertThat(expected).isFalse();

    }
}