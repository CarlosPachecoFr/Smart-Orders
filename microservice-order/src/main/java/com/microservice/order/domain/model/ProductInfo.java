package com.microservice.order.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {
	private Long productId;
	private double price;
	private String currency;
	
	public ProductInfo(double price, String currency) {
		super();
		this.price = price;
		this.currency = currency;
	}
	
	
}
