package com.todeb.creditsystem.repository;

import com.todeb.creditsystem.domain.CreditApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditApplicationRepository extends JpaRepository<CreditApplication,Integer> {

    boolean existsCreditApplicationByCustomer_IdentityNumber(String IdentityNumber);
    Optional<CreditApplication> findCreditApplicationByCustomer_IdentityNumber(String IdentityNumber);
}
