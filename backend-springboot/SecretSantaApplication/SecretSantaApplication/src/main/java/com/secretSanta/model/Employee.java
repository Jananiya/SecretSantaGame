package com.secretSanta.model;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Employee {
		private String name;
	private String email;
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	
	
}

