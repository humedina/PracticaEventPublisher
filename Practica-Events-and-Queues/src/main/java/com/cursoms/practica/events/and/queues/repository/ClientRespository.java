package com.cursoms.practica.events.and.queues.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoms.practica.events.and.queues.model.Client;

public interface ClientRespository extends JpaRepository<Client, Long> {

}
