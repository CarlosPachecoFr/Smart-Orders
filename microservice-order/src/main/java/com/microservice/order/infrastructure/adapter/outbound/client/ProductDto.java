package com.microservice.order.infrastructure.adapter.outbound.client;

import lombok.Data;

@Data
public class ProductDto {
	private Long productId;
	private String name;
	private double price;
	private String currency;
	private int stock;
	
	public ProductDto(Long productId, String name, double price, String currency, int stock) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.currency = currency;
		this.stock = stock;
	}
}
