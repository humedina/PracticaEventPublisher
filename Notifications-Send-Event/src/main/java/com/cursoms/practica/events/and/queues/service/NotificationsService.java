package com.cursoms.practica.events.and.queues.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NotificationsService {

	public void sendNotifications() {
		log.info("Sending notifications...!");
		log.info("***The notifications has been sent...!***");
	}
}
