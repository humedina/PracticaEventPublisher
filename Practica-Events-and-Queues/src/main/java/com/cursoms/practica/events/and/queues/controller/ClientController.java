package com.cursoms.practica.events.and.queues.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoms.practica.events.and.queues.model.Client;
import com.cursoms.practica.events.and.queues.model.Response;
import com.cursoms.practica.events.and.queues.service.ClientService;

@RestController
@CrossOrigin
@RequestMapping("/clients-register")
public class ClientController {

	@Autowired
	ClientService clientService;

	@PostMapping
	public ResponseEntity<Object> registerClient(@RequestBody Client client) {

		clientService.registerClient(client);
		return new ResponseEntity<>(Response.builder().status(0).message("Client registered...!").build(),
				HttpStatus.CREATED);
	}
}
