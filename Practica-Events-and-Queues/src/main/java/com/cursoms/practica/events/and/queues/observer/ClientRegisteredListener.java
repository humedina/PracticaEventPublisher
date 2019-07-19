package com.cursoms.practica.events.and.queues.observer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cursoms.practica.events.and.queues.events.ClientRegisteredEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClientRegisteredListener {
	// Inyecte Bean RabbitTemplate rabbitTemplate.
	@Autowired
	private RabbitTemplate rabbitTemplate;
	// Inyecte Bean FanoutExchange fanoutExchange
	@Autowired
	private FanoutExchange fanoutExchange;
	// Inyecte ObjectMapper objectMapper
	@Autowired
	private ObjectMapper objectMapper;

	@SneakyThrows
	// Manejador de evento UserCreatedEvent
	@EventListener
	public void handleClientRegisteredEvent(ClientRegisteredEvent cre) {
		log.info("sending Client Registered Event to: {}", fanoutExchange.getName());

		// Implemente
		rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", objectMapper.writeValueAsString(cre));

		log.info("--------------------------------------------------------------");
	}
}
