package com.microservice.product.domain.port.in;

import com.common.events.OrderCreatedEvent;

public interface ReserveStockUseCase {

	void reserve(OrderCreatedEvent event);
	
}
