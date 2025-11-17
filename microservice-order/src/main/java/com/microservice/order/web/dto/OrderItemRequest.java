package com.microservice.order.web.dto;

import lombok.Data;

@Data
public class OrderItemRequest {
	private Long productId;
	private double price;
	private String currrency;
	private int quantity;
	
}
