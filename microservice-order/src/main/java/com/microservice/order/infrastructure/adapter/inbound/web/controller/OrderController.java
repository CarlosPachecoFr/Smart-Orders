package com.microservice.order.infrastructure.adapter.inbound.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.order.domain.port.in.CreateOrderUseCase;
import com.microservice.order.infrastructure.adapter.inbound.web.dto.CreateOrderRequest;
import com.microservice.order.infrastructure.adapter.inbound.web.dto.OrderResponse;
import com.microservice.order.infrastructure.adapter.inbound.web.mapper.OrderWebMapper;

@RestController
@RequestMapping("/sm/order")
public class OrderController {
	
	@Autowired
	private OrderWebMapper mapper;
	@Autowired
	private CreateOrderUseCase createOrderUseCase;

	@PostMapping("/createOrder")
	public OrderResponse createOrder(@RequestBody CreateOrderRequest request) {
		return mapper.toDto(createOrderUseCase.createOrder(mapper.toDomain(request)));
	}
}
