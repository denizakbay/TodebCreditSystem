package com.todeb.creditsystem.repository;

import com.todeb.creditsystem.domain.CreditScore;
import com.todeb.creditsystem.domain.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CreditScoreRepositoryTest {

    @Autowired
    private CreditScoreRepository underTest;

    @Autowired
    private CustomerRepository customerRepository;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindCreditScoreByIdentityNumber() {
        // given
        String identityNumber = "17389376996";
        CreditScore creditScore = CreditScore.builder()
                .creditScore(324)
                .build();
        Customer customer = Customer.builder()
                .identityNumber(identityNumber)
                .firstName("deniz")
                .lastName("akbay")
                .monthlyIncome(BigDecimal.valueOf(15_000))
                .phone("05378880833")
                .creditScore(creditScore)
                .build();

        customerRepository.save(customer);
        underTest.save(creditScore);

        // when
        CreditScore expected = underTest.findCreditScoreByIdentityNumber(identityNumber);

        // then
        assertThat(expected).isEqualTo(creditScore);


    }
}