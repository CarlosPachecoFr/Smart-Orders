package com.microservice.order.infrastructure.adapter.inbound.web.dto;

import java.util.List;

import lombok.Data;

@Data
public class CreateOrderRequest {
	private List<OrderItemRequest> orderItems;
	
	
}
