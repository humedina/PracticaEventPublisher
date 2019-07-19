package com.cursoms.practica.events.and.queues.events.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRegisteredEvent {

	private long id;
	private String firstName;
	private String lastName;
	private String motherLastName;
	public String email;
	public int age;
	public boolean acceptingToJoin;
	public long idProduct;
}
