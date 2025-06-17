package com.banking.transaction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.transaction.model.Customer;
import com.banking.transaction.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer getCustomer(String customerId){
		return customerRepository.findById(customerId).get();
	}
	
	public List<Customer> getCustomers(){
		return customerRepository.findAll();
	}
	
	public Customer save(Customer customer){
		return customerRepository.save(customer);
	}
	
	public Customer update(Customer customer){
		return customerRepository.save(customer);
	}
	
	public boolean delete(String customerId){
		Optional<Customer> customer = customerRepository.findByCustomerId(customerId);
		if(customer.isPresent()) {
		customerRepository.delete(customer.get());
		return true;
		}
		return false;
	}
	
}
