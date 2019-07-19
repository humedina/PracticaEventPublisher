package com.cursoms.practica.events.and.queues.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cursoms.practica.events.and.queues.events.client.ClientRegisteredEvent;
import com.cursoms.practica.events.and.queues.model.CatProcuct;
import com.cursoms.practica.events.and.queues.model.ClientProduct;
import com.cursoms.practica.events.and.queues.repository.CatProductRepository;
import com.cursoms.practica.events.and.queues.service.ProductService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClientRegisteredListener {

	@Autowired
	private ProductService productService;

	@Autowired
	CatProductRepository catProductRepository;

	@SneakyThrows
	@EventListener
	public void handleClientREgisteredEvent(ClientRegisteredEvent cre) {
		log.info("handling Client Registered Event: {}", cre);

		if (cre.isAcceptingToJoin()) {
			log.info("Se acepta producto: {}", cre.isAcceptingToJoin());
			Thread.sleep(2000);
			log.info("idProduct a buscar: {}", cre.getIdProduct());
			CatProcuct catProduct = catProductRepository.findById(cre.getIdProduct())
					.orElseThrow(() -> new RuntimeException("Product not found"));

			ClientProduct product = ClientProduct.builder().idProduct(cre.getIdProduct()).clientId(cre.getId())
					.description(catProduct.getDescription()).build();

			productService.registerProduct(product);
		}
		log.info("---------------------------------------");
	}
}
