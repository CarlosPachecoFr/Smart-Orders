package com.microservice.order.domain.port.in;

import java.util.UUID;

public interface UpdateStatusOrderUseCase {

	void updateStatusOrder(UUID id, String status);
}
