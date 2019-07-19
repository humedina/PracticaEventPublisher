package com.cursoms.practica.events.and.queues.events;

import com.cursoms.practica.events.and.queues.model.ClientProduct;

public class ProductRegisteredEventBuilder {

	public static ProductRegisteredEvent build(ClientProduct product) {
		return ProductRegisteredEvent.builder()
				.id(product.getId())
				.idProduct(product.getIdProduct())
				.description(product.getDescription())
				.clientId(product.getClientId())
				.build();
	}
}
