package com.microservice.order.domain.model;

import lombok.Data;

@Data
public class OrderItem {
	private Long productId;
	private int quantity;
	private Money price;
	
	public OrderItem() {
		super();
	}
	
	public OrderItem(Long productId, int quantity, Money price) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Money getTotal() {
		return new Money(this.price.getAmount()*this.quantity,this.price.getCurrency());
	}

	
	
}
