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
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable String customerId){
		Customer customer=customerService.getCustomer(customerId);
		return ResponseEntity.status(OK).body(customer);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Customer> save(@RequestBody Customer customer ){
		return ResponseEntity.status(CREATED).body(customerService.save(customer));
	}
	
	@PutMapping("/update/{customerId}")
	public ResponseEntity<Customer> udpate(@PathVariable String customerId, @RequestBody Customer customer ){
		Optional<Customer> esitingCustomer=Optional.ofNullable(customerService.getCustomer(customerId));
		if(esitingCustomer.isPresent())
		return ResponseEntity.status(ACCEPTED).body(customerService.update(customer));
		else return null;
	}
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<String> delete(@RequestParam String customerId){
		if(customerService.delete(customerId)) 
		return ResponseEntity.status(OK).body("Successfully Deleted");
		 else 
		return ResponseEntity.status(OK).body("unable to find customer");
	}
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String customerId){
		if(customerService.delete(customerId)) 
		return ResponseEntity.status(OK).body("Successfully Deleted");
		 else 
		return ResponseEntity.status(OK).body("unable to find customer");
	}

}
