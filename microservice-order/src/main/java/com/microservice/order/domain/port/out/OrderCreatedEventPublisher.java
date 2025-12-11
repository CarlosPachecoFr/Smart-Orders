package com.microservice.order.domain.port.out;

import com.common.events.OrderCreatedEvent;

public interface OrderCreatedEventPublisher {
	
	public void publish(OrderCreatedEvent event);
}
