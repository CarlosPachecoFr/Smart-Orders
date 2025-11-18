package com.microservice.product.web.dto;

import lombok.Data;

@Data
public class ProductResponse {
	private Long productId;
	private String name;
	private double price;
	private String currency;
	private int stock;
	
	public ProductResponse() {
		
	}
	
	public ProductResponse(Long productId, double price, String currency, int stock) {
		super();
		this.productId = productId;
		this.price = price;
		this.currency = currency;
		this.stock = stock;
	}
	
}
