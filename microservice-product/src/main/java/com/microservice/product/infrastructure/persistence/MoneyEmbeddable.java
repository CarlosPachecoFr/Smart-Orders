package com.microservice.product.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class MoneyEmbeddable {

	@Column
	private double amount;
	
	@Column
	private String currency;
	
	protected MoneyEmbeddable() {} // constructor vacío requerido por JPA
	
	public MoneyEmbeddable(double amount, String currency) {
	    this.amount = amount;
	    this.currency = currency;
	}
}
