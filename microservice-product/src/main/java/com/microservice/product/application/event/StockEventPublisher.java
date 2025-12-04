package com.microservice.product.application.event;

import java.util.UUID;

public interface StockEventPublisher {
	
	public void stockReserved(UUID id);
	public void stockRejected(UUID id);

}
