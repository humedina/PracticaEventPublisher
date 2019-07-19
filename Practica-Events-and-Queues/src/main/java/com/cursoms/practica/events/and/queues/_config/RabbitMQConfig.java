package com.cursoms.practica.events.and.queues._config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	// Define bean FanoutExchange fanoutExchange
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("client.registered.fanout");
	}
	
	// Define bean Queue userCreatedAccountQueue
	@Bean
	public Queue clientRegisteredInformationQueue() {
		return new Queue("client.registered.info.queue", true);
	}
	
	// Define Binding binding1
	@Bean
	public Binding binding1(FanoutExchange fanoutExchange, Queue clientRegisteredInformationQueue) {
		return BindingBuilder.bind(clientRegisteredInformationQueue).to(fanoutExchange);
	}
}
