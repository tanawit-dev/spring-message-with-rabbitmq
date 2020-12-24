package com.tanawit.customerservice.message;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.tanawit.customerservice.entity.Customer;

public class MessageSender {

	private String topicName = "customer.topic";
	@Autowired
	private TopicExchange topicExchange;
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendEmail(Customer customer) {
		rabbitTemplate.convertAndSend(topicExchange.getName(), topicName, customer);
	}

}
