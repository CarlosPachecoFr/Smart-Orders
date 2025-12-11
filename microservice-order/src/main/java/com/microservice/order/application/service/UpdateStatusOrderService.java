package com.microservice.order.application.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.order.domain.model.Order;
import com.microservice.order.domain.port.in.UpdateStatusOrderUseCase;
import com.microservice.order.domain.port.out.OrderRepository;

import jakarta.transaction.Transactional;


@Service
public class UpdateStatusOrderService implements UpdateStatusOrderUseCase{
	
	@Autowired
	private OrderRepository repository;
	
	@Override
	@Transactional
	public void updateStatusOrder(UUID id, String status) {
		Order order = repository.findById(id);
		order.setStatus(status);
		
		repository.save(order);
	}

}
