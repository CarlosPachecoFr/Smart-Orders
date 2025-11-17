package com.microservice.order.web.mapper;

import com.microservice.order.domain.model.Order;
import com.microservice.order.web.dto.CreateOrderRequest;
import com.microservice.order.web.dto.OrderResponse;

public interface OrderWebMapper {
	
	Order toDomain(CreateOrderRequest orderRequest);
	OrderResponse toDto(Order order);
}
