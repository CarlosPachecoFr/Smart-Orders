package com.microservice.order.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.order.application.usecase.CreateOrderUseCase;
import com.microservice.order.web.dto.CreateOrderRequest;
import com.microservice.order.web.dto.OrderResponse;
import com.microservice.order.web.mapper.OrderWebMapper;

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
