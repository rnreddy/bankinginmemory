package com.banking.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.ACCEPTED;
import com.banking.transaction.model.Customer;
import com.banking.transaction.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getCustomers(){
		List<Customer> listCustomer=customerService.getCustomers();
		return ResponseEntity.status(OK).body(listCustomer);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Customer> save(@RequestBody Customer customer ){
		return ResponseEntity.status(CREATED).body(customerService.save(customer));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Customer> udpate(@RequestBody Customer customer ){
		return ResponseEntity.status(ACCEPTED).body(customerService.save(customer));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam String customerId){
		if(customerService.delete(customerId)) 
		return ResponseEntity.status(OK).body("Successfully Deleted");
		 else 
		return ResponseEntity.status(OK).body("unable to find customer");
	}
	

}
