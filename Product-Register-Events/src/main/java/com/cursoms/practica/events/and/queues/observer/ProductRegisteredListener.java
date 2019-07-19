package com.cursoms.practica.events.and.queues.observer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cursoms.practica.events.and.queues.events.ProductRegisteredEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductRegisteredListener {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private FanoutExchange fanoutExchange;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@SneakyThrows
	@EventListener
	public void handleProductRegisteredEvent(ProductRegisteredEvent pre) {
		log.info("sending Product Registered Event to: {}", fanoutExchange.getName());
		
		rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", objectMapper.writeValueAsString(pre));
		
		log.info("--------------------------------------------------------------");
	}
	
	
}
