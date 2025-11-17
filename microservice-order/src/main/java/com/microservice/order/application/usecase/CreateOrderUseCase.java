package com.microservice.order.application.usecase;

import com.microservice.order.domain.model.Order;

public interface CreateOrderUseCase {

	Order createOrder(Order order);
}
