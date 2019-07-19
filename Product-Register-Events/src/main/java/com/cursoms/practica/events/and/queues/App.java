package com.cursoms.practica.events.and.queues;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cursoms.practica.events.and.queues.model.CatProcuct;
import com.cursoms.practica.events.and.queues.repository.CatProductRepository;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	private CatProductRepository productRepRository;

	public App(CatProductRepository productRepRository) {

		this.productRepRository = productRepRository;
	}
	
	@Bean
	public CommandLineRunner startup() {

		return (args) -> {
			CatProcuct product = CatProcuct.builder().id(1L).description("Auto").build();

			System.out.println(product);

			productRepRository.save(product);

			product = CatProcuct.builder().id(2L).description("Tour").build();

			System.out.println(product);

			productRepRository.save(product);
			
			product = CatProcuct.builder().id(3L).description("Comidas").build();

			System.out.println(product);

			productRepRository.save(product);
		};
	}
}
