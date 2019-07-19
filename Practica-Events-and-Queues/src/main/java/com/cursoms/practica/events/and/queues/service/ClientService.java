package com.cursoms.practica.events.and.queues.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.cursoms.practica.events.and.queues.events.ClientRegisteredEventBuilder;
import com.cursoms.practica.events.and.queues.model.Client;
import com.cursoms.practica.events.and.queues.repository.ClientRespository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ClientService {

	@Autowired private ClientRespository clientRepository;
	
	@Autowired ApplicationEventPublisher clientPublisher;
	
	
	public void registerClient(Client client) {
		log.info("Registering the client: {}", client);
		clientRepository.save(client);
		log.info("Publishing the event: '**Client Registered**'");
		clientPublisher.publishEvent(ClientRegisteredEventBuilder.build(client));
		
	}
}
