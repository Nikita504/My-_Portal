package com.java.jquery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.jquery.model.Customer;

@Repository
public interface CustRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
