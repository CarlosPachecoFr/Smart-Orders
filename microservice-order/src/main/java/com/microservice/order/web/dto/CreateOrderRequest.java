package com.microservice.order.web.dto;

import java.util.List;

import lombok.Data;

@Data
public class CreateOrderRequest {
	private List<OrderItemRequest> orderItems;
	
	
}
