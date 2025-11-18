package com.microservice.product.domain.model;

import lombok.Data;

@Data
public class Money {
	private double amount;
	private String currency;
	
	
	public Money(double amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}
	
}
