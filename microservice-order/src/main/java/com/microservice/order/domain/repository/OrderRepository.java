package com.microservice.order.domain.repository;

import com.microservice.order.domain.model.Order;
import com.microservice.order.infrastructure.persistence.OrderEntity;

public interface OrderRepository {

	Order save(Order order);
}
