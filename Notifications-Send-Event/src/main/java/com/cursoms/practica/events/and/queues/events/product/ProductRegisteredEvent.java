package com.cursoms.practica.events.and.queues.events.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRegisteredEvent {

	private long id;
	private long idProduct;
	private String description;
	private long clientId;
}
