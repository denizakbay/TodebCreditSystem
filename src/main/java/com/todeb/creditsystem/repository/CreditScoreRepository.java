package com.todeb.creditsystem.repository;

import com.todeb.creditsystem.domain.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScore,Integer> {

    @Query("select c from CreditScore c where c.customer.identityNumber = ?1")
    CreditScore findCreditScoreByIdentityNumber(String identity);
}
