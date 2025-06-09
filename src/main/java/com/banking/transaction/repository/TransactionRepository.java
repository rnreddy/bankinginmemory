package com.banking.transaction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banking.transaction.model.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, String> {
	Optional<Transactions> findByTransactionId(String customerId);
}
