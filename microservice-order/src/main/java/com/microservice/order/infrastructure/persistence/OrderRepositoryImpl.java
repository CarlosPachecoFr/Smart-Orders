package com.microservice.order.infrastructure.persistence;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservice.order.domain.model.Order;
import com.microservice.order.domain.repository.OrderRepository;
import com.microservice.order.infrastructure.persistence.mapper.OrderMapper;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
	
	@Autowired
	private JpaOrderRepository jpaOrderRepository;
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public Order findById(UUID id) {
		return orderMapper.toDomain(jpaOrderRepository.findById(id).orElse(null));
	}
	
	@Override
	public Order save(Order order) {
		return orderMapper.toDomain(jpaOrderRepository.save(orderMapper.toEntity(order)));
	}

	

}
