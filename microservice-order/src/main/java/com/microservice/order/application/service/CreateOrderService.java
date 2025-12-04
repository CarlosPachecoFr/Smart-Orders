package com.microservice.order.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.order.application.event.OrderCreatedEventPublisher;
import com.microservice.order.application.usecase.CreateOrderUseCase;
import com.microservice.order.domain.model.Money;
import com.microservice.order.domain.model.Order;
import com.microservice.order.domain.model.OrderItem;
import com.microservice.order.domain.repository.OrderRepository;
import com.microservice.order.infrastructure.client.ProductClient;
import com.microservice.order.infrastructure.client.ProductDto;
import com.microservice.order.infrastructure.mapper.OrderEventMapper;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class CreateOrderService implements CreateOrderUseCase{
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductClient client;
	@Autowired
	private OrderCreatedEventPublisher publisher;
	@Autowired
	private OrderEventMapper mapperEvent;
	@Autowired
	private EntityManager entityManager; //necesario para forzar el commit a db con el metodo flush

	@Override
	@Transactional
	public Order createOrder(Order order) {
		for(OrderItem item: order.getOrderItems()) {
			ProductDto product = client.findProductById(item.getProductId());
			item.setPrice(new Money(product.getPrice(),product.getCurrency()));
		}
		order.calculateTotal();
		Order saved = orderRepository.save(order);
		entityManager.flush(); //se fuerza el commit a la db
		
		publisher.publish(mapperEvent.toEvent(order));
		
		return saved;
	}

}
