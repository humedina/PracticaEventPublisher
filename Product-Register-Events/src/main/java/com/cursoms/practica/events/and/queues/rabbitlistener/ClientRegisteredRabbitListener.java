package com.cursoms.practica.events.and.queues.rabbitlistener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.cursoms.practica.events.and.queues.events.client.ClientRegisteredEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClientRegisteredRabbitListener {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@SneakyThrows
	@RabbitListener(queues = {"client.registered.info.queue"})
	public void handleClientRegisteredEvent(String message) {
		log.info("Rabbit listener Client Registered Event");
		ClientRegisteredEvent cre = objectMapper.readValue(message, ClientRegisteredEvent.class);
		log.info("Event listened: {}", cre);
		log.info("publishing Client Registered Event (from Product)");
		
		publisher.publishEvent(cre);
		log.info("-------------------------------------------");
	}
}
