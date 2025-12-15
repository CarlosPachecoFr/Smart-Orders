package com.microservice.product.domain.port.out;

import java.util.UUID;

public interface StockEventPublisher {
	
	public void stockReserved(UUID id);
	public void stockRejected(UUID id);

}
