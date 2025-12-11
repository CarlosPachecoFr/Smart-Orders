package com.microservice.order.infrastructure.adapter.outbound.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "order_items")
public class OrderItemEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Long productId;
	
	@Column
	private int quantity;
	
	@Embedded
	private MoneyEmbeddable price;
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private OrderEntity order;
}
