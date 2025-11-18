package com.microservice.product.web.dto;

import lombok.Data;

@Data
public class ProductRequest {
	private Long productId;
	private int quantity;
	
	public ProductRequest(Long productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

}
