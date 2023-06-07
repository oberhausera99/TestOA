package com.example.teszt;

import java.util.UUID;

public class Address {
	
	private UUID id;
	private String address;
	
	
	public UUID getId() {
		return id;
	}
	public String getAddress() {
		return address;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
