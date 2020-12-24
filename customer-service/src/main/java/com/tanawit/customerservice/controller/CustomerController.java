package com.tanawit.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanawit.customerservice.entity.Customer;
import com.tanawit.customerservice.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping
	public ResponseEntity<?> postCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}

}
