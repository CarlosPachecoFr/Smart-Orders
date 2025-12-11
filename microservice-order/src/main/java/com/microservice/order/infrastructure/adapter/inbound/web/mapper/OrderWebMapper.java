package com.microservice.order.infrastructure.adapter.inbound.web.mapper;

import com.microservice.order.domain.model.Order;
import com.microservice.order.infrastructure.adapter.inbound.web.dto.CreateOrderRequest;
import com.microservice.order.infrastructure.adapter.inbound.web.dto.OrderResponse;

public interface OrderWebMapper {
	
	Order toDomain(CreateOrderRequest orderRequest);
	OrderResponse toDto(Order order);
}
