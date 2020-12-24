package com.tanawit.customerservice.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tanawit.customerservice.message.MessageSender;

@Configuration
public class MessageConfig {
	
	private String topicName = "customer.topic";

	@Bean
	public TopicExchange topic() {
		return new TopicExchange(topicName);
	}
	
	@Bean
	public MessageSender sender() {
		return new MessageSender();
	}
}
