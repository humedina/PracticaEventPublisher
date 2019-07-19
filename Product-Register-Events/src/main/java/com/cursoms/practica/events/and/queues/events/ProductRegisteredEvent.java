package com.cursoms.practica.events.and.queues.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductRegisteredEvent {

	private long id;
	private long idProduct;
	private String description;
	private long clientId;
}
