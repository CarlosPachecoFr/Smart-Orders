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
		this.status = "PENDING";
	}
	
	public Money calculateTotal() {
		this.total = this.orderItems.get(0).getTotal(); //sumamos en el for desde el segundo porque aqui le seteamos ya el primero
		for (int i = 1; i < orderItems.size(); i++) {
	        this.total = this.total.add(orderItems.get(i).getTotal());
	    }
		return this.total;
	}

	
}
