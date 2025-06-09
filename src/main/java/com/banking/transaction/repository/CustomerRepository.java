package com.banking.transaction.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.transaction.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	Optional<Customer> findByCustomerId(String customerId);
}
