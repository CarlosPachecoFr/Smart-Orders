package com.microservice.product.application.usecase;

import com.common.events.OrderCreatedEvent;

public interface ReserveStockUseCase {

	void reserve(OrderCreatedEvent event);
	
}
