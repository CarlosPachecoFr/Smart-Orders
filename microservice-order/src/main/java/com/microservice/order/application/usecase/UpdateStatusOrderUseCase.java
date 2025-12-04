package com.microservice.order.application.usecase;

import java.util.UUID;

public interface UpdateStatusOrderUseCase {

	void updateStatusOrder(UUID id, String status);
}
