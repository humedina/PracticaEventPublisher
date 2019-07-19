package com.cursoms.practica.events.and.queues.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
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
