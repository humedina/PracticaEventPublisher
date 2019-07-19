package com.cursoms.practica.events.and.queues.events;

import com.cursoms.practica.events.and.queues.model.Client;

public class ClientRegisteredEventBuilder {

	public static ClientRegisteredEvent build(Client client) {
		return ClientRegisteredEvent.builder()
				.id(client.getId())
				.firstName(client.getFirstName())
				.lastName(client.getLastName())
				.motherLastName(client.getMotherLastName())
				.email(client.getEmail())
				.age(client.getAge())
				.acceptingToJoin(client.isAcceptingToJoin())
				.idProduct(client.getIdProduct())
				.build();
	}
}
