package com.microservice.order.domain.model;

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
	
	public Money add(Money other) {
		if(!this.currency.equals(other.currency)) {
			throw new IllegalArgumentException("Currency mismatch");
		}
		return new Money(this.amount + other.amount, other.currency);
	}
}
