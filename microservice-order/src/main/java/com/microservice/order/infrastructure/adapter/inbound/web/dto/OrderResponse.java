package com.microservice.order.infrastructure.adapter.inbound.web.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderResponse {
	private List<OrderItemResponse> orderItems;
	private double total;
	private String currency;
	private String status;
	
	public OrderResponse() {
		
	}
	
	public OrderResponse(List<OrderItemResponse> orderItems, double total, String currency, String status) {
		super();
		this.orderItems = orderItems;
		this.total = total;
		this.currency = currency;
		this.status = status;
	}
	
}
