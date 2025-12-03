package com.microservice.order.application.event;

import com.common.events.OrderCreatedEvent;

public interface OrderCreatedEventPublisher {
	
	public void publish(OrderCreatedEvent event);
}
