package com.microservice.order.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.order.application.usecase.CreateOrderUseCase;
import com.microservice.order.domain.model.Order;
import com.microservice.order.domain.repository.OrderRepository;

@Service
public class CreateOrderService implements CreateOrderUseCase{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

}
