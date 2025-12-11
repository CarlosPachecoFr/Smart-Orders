package com.microservice.order.domain.port.out;

import java.util.UUID;

import com.microservice.order.domain.model.Order;

public interface OrderRepository {

	Order findById(UUID id);
	Order save(Order order);
}
