package com.tanawit.emailservice.config;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tanawit.emailservice.message.MessageReceiver;

@Configuration
public class MessageConfig {
	
	private String topicName = "customer.topic";
	
	@Bean
	public TopicExchange topic() {
		return new TopicExchange(topicName);
	}
	
	@Bean
	public Queue autoDeletedQueue() {
		return new AnonymousQueue();
	}
	
	@Bean
	public Binding binding(TopicExchange topic, Queue autoDeletedQueue) {
		return BindingBuilder.bind(autoDeletedQueue).to(topic).with(topicName);
	}
	
	@Bean
	public MessageReceiver receiver() {
		return new MessageReceiver();
	}

}
