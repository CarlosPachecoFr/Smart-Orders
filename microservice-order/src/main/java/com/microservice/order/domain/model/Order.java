package com.microservice.order.domain.model;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class Order {
	private UUID id;
	private List<OrderItem> orderItems;
	private String status; //Por ejemplo: CREATED, CONFIRMED
	private Money total;
	
	public Order() {
		super();
	}
	
	public Order(List<OrderItem> orderItems) {
		super();
		this.id = UUID.randomUUID();
		this.orderItems = orderItems;
		this.status = "CREATED";
		this.total = this.calculateTotal(orderItems);
	}
	
	public Money calculateTotal(List<OrderItem> orderItems) {
		Money total = new Money(0,orderItems.get(0).getPrice().getCurrency());
		for(OrderItem i: orderItems) {
			total = total.add(i.getTotal());
		}
		return total;
	}

	
}
