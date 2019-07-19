package com.cursoms.practica.events.and.queues.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cursoms.practica.events.and.queues.events.product.ProductRegisteredEvent;
import com.cursoms.practica.events.and.queues.service.NotificationsService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductRegisteredListener {

	@Autowired
	private NotificationsService notificationsService;

	@SneakyThrows
	@EventListener
	public void handleProductRegisteredEvent(ProductRegisteredEvent pre) {
		log.info("handling Product Registered Event: {}", pre);
		notificationsService.sendNotifications();
		log.info("---------------------------------------");
	}
}
