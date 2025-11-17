package com.microservice.order.web.dto;

import lombok.Data;

@Data
public class OrderItemResponse {
	private Long productId;
	private int quantity;
	private double price;
	private String currency;
	
	public OrderItemResponse() {
		
	}
	
	public OrderItemResponse(Long productId, int quantity, int price, String currency) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.currency = currency;
	}
	
}
