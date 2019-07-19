package com.cursoms.practica.events.and.queues.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.cursoms.practica.events.and.queues.events.ProductRegisteredEventBuilder;
import com.cursoms.practica.events.and.queues.model.ClientProduct;
import com.cursoms.practica.events.and.queues.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ApplicationEventPublisher productPublisher;
	
	public void registerProduct(ClientProduct product) {
		log.info("Registering the product: {}", product);
		productRepository.save(product);
		log.info("Publishing the event: '***Product Registered***'");
		productPublisher.publishEvent(ProductRegisteredEventBuilder.build(product));
	}
}
