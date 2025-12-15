package com.microservice.product.infrastructure.adapter.outbound.kafka;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.microservice.product.domain.port.out.StockEventPublisher;

@Component
public class StockEventProducer implements StockEventPublisher{
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public StockEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

	@Override
	public void stockReserved(UUID id) {
		kafkaTemplate.send("order_stock_reserved", id.toString());
	}

	@Override
	public void stockRejected(UUID id) {
		kafkaTemplate.send("order_stock_rejected", id.toString());
	}
	
	

}
