package com.tanawit.emailservice.service;

import com.tanawit.customerservice.entity.Customer;

public interface EmailService {
	void sendMessageToCustomer(Customer customer);
}
