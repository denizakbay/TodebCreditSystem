package com.todeb.creditsystem.repository;

import com.todeb.creditsystem.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByIdentityNumber(String identityNumber);


}

