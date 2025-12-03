package com.microservice.product.domain.model;

import lombok.Data;

@Data
public class Product {
	private Long productId;
	private String name;
	private int stock;
	private int quantity; //necesario para coger el quantity del request
	Money price;
	
	public Product() {
		super();
	}
	
	public Product(Long productId, String name, int stock, int quantity,Money price) {
		super();
		this.productId = productId;
		this.name = name;
		this.stock = stock;
		this.quantity = quantity;
		this.price = price;
	}
	
	public void reserve(int quantity) {
		if(this.stock < quantity) {
			 throw new IllegalArgumentException("Not enough stock for product " + this.productId);
		}
		else {
			this.stock -= quantity;
		}
	}
}
