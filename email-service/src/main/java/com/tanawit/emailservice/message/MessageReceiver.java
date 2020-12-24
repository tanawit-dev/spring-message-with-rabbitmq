package com.tanawit.emailservice.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.tanawit.customerservice.entity.Customer;
import com.tanawit.emailservice.service.EmailService;

@RabbitListener(queues = "#{autoDeletedQueue.name}")
public class MessageReceiver {

	@Autowired
	private EmailService emailService;
	
	private Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);

	@RabbitHandler
	public void receive(Customer customer) {
		LOGGER.warn("recieve message: " + customer);
		emailService.sendMessageToCustomer(customer);
	}

}
