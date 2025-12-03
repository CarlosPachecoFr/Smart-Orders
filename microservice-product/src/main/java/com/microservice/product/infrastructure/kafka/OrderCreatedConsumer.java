package com.microservice.product.infrastructure.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.common.events.OrderCreatedEvent;
import com.microservice.product.application.usecase.ReserveStockUseCase;

@Component
public class OrderCreatedConsumer {
	
	@Autowired
	private ReserveStockUseCase reserveStockUseCase;
	
	@KafkaListener(topics = "order-created-topic", groupId = "product-service-group")
	public void reserveStock(OrderCreatedEvent event) {
		reserveStockUseCase.reserve(event);
	}
}
