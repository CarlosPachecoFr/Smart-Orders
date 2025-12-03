package com.microservice.order.infrastructure.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.common.events.OrderCreatedEvent;
import com.microservice.order.application.event.OrderCreatedEventPublisher;

@Component
public class KafkaOrderProducer implements OrderCreatedEventPublisher{
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public KafkaOrderProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

	@Override
	public void publish(OrderCreatedEvent event) {
		kafkaTemplate.send("order-created-topic",event);
	}

}
