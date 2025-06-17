package com.banking.transaction.controller;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.transaction.model.Transactions;
import com.banking.transaction.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@GetMapping("/all")
	public ResponseEntity<List<Transactions>> getTransactions() {
		List<Transactions> listTransactions = transactionService.getTransactions();
		return ResponseEntity.status(OK).body(listTransactions);
	}

	@GetMapping("/{transactionId}")
	public ResponseEntity<Transactions> getTransaction(@PathVariable String transactionId) {
		Transactions transactions = transactionService.getTransaction(transactionId);
		return ResponseEntity.status(OK).body(transactions);
	}

	@PostMapping("/save")
	public ResponseEntity<Transactions> saveTransactions(@RequestBody Transactions transactions) {
		return ResponseEntity.status(CREATED).body(transactionService.saveTransactions(transactions));
	}

	@PutMapping("/update/{transactionId}")
	public ResponseEntity<Transactions> updateTransactions(@PathVariable String transactionId,
			@RequestBody Transactions transactions) {
		Optional<Transactions> esixtingtransactions = Optional
				.ofNullable(transactionService.getTransaction(transactionId));
		if (esixtingtransactions.isPresent())
			return ResponseEntity.status(ACCEPTED).body(transactionService.updateTransactions(transactions));
		else
			return null;
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteTransactions(@RequestParam String transactionId) {
		if (transactionService.deleteTransactions(transactionId))
			return ResponseEntity.status(OK).body("Record deleted successfully");
		else
			return ResponseEntity.status(OK).body("transactionId Record Not Exists ");
	}

	@DeleteMapping("/delete/{transactionId}")
	public ResponseEntity<String> deleteTransaction(@PathVariable String transactionId) {
		if (transactionService.deleteTransactions(transactionId))
			return ResponseEntity.status(OK).body("Record deleted successfully");
		else
			return ResponseEntity.status(OK).body("transactionId Record Not Exists ");
	}

}
