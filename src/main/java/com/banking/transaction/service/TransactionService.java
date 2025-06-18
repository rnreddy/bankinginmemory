package com.banking.transaction.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.transaction.model.Transactions;
import com.banking.transaction.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	public List<Transactions> getTransactions(){
		return transactionRepository.findAll();
	}
	
	public Transactions getTransaction(String transactionId){
		return transactionRepository.findById(transactionId).get();
	}
	
	
	public Transactions saveTransactions(Transactions transactions){
		transactions.setTransactionId(UUID.randomUUID().toString());
		return transactionRepository.save(transactions);
	}
	
	public Transactions updateTransactions(Transactions transactions){
		return transactionRepository.save(transactions);
	}
	
	public boolean deleteTransactions(String transactionId){
		Optional<Transactions> transactions =transactionRepository.findByTransactionId(transactionId);
		if(transactions.isPresent()) {
		transactionRepository.delete(transactions.get());
		return true;
		}
		return false;
	}

}
