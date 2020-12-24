package com.tanawit.customerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanawit.customerservice.entity.Customer;
import com.tanawit.customerservice.message.MessageSender;
import com.tanawit.customerservice.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private CustomerRepository customerRepository;
	private MessageSender sender;

	@Autowired
	public CustomerService(CustomerRepository customerRepository, MessageSender messageSender) {
		this.customerRepository = customerRepository;
		this.sender = messageSender;
	}
	
	public Customer createCustomer(Customer customer) {
		Customer createdCustomer = customerRepository.save(customer);
		sender.sendEmail(createdCustomer);
		return createdCustomer;
	}
	
}
