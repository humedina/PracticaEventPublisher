package com.cursoms.practica.events.and.queues.rabbitlistener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.cursoms.practica.events.and.queues.events.product.ProductRegisteredEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductRegisteredRabbitListener {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@SneakyThrows
	@RabbitListener(queues = {"product.registered.queue"})
	public void handleProductRegisteredEvent(String message) {
		log.info("Rabbit listener Product Registered Event");
		ProductRegisteredEvent pre = objectMapper.readValue(message, ProductRegisteredEvent.class);
		log.info("Event listened: {}", pre);
		log.info("publishing Product Registered Event (from Notifications)");
		
		publisher.publishEvent(pre);
		log.info("-------------------------------------------");
	}
}
