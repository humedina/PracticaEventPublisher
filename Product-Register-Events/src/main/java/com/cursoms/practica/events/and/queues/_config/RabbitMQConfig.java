package com.cursoms.practica.events.and.queues._config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("product.registered.fanout");
	}

	@Bean
	public Queue productRegisteredQueue() {
		return new Queue("product.registered.queue");
	}
	
	@Bean
	public Binding binding(FanoutExchange fanoutExchange, Queue productRegisteredQueue) {
		return BindingBuilder.bind(productRegisteredQueue).to(fanoutExchange);
	}
}
