package com.microservice.order.infrastructure.client;

import lombok.Data;

@Data
public class ReserveStockRequest {
	private Long productId;
	private int quantity;
	
	public ReserveStockRequest(Long productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
}
