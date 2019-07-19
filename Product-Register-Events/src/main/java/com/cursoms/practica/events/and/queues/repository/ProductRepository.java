package com.cursoms.practica.events.and.queues.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoms.practica.events.and.queues.model.ClientProduct;

public interface ProductRepository extends JpaRepository<ClientProduct, Long>{

}
