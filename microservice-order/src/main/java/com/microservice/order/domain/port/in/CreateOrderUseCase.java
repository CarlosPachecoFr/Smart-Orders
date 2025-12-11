package com.microservice.order.domain.port.in;

import com.microservice.order.domain.model.Order;

public interface CreateOrderUseCase {

	Order createOrder(Order order);
}
