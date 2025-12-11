package com.microservice.order.infrastructure.adapter.inbound.kafka;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.microservice.order.domain.port.in.UpdateStatusOrderUseCase;

@Component
public class StockEventConsumer {
	
	@Autowired
	private UpdateStatusOrderUseCase useCase;
	
	@KafkaListener(topics = "order_stock_reserved", groupId = "order-service-group")
	public void confirmOrder(String id) {
		UUID orderId = UUID.fromString(id);
		useCase.updateStatusOrder(orderId, "CONFIRMED");
	}
	
	@KafkaListener(topics = "order_stock_rejected", groupId = "order-service-group")
	public void rejectedOrder(String id) {
		UUID orderId = UUID.fromString(id);
		useCase.updateStatusOrder(orderId, "REJECTED");
	}

}
