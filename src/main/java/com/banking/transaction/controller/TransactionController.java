package com.banking.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.banking.transaction.model.Transactions;
import com.banking.transaction.service.TransactionService;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	

	@GetMapping("/all")
	public ResponseEntity<List<Transactions>> getTransactions(){
		List<Transactions> listTransactions=transactionService.getTransactions();
		return ResponseEntity.status(OK).body(listTransactions);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Transactions> saveTransactions(Transactions transactions) {
		return ResponseEntity.status(CREATED).body(transactionService.saveTransactions(transactions));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Transactions> updateTransactions(Transactions transactions){
		return ResponseEntity.status(ACCEPTED).body(transactionService.updateTransactions(transactions));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteTransactions(@RequestParam String transactionId){
		if(transactionService.deleteTransactions(transactionId))
			return ResponseEntity.status(OK).body("Record deleted successfully");
		else
		return ResponseEntity.status(OK).body("transactionId Record Not Exists ");
	}
	
}
