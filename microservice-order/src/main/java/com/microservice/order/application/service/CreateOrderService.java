package com.microservice.order.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.order.domain.model.Money;
import com.microservice.order.domain.model.Order;
import com.microservice.order.domain.model.OrderItem;
import com.microservice.order.domain.model.ProductInfo;
import com.microservice.order.domain.port.in.CreateOrderUseCase;
import com.microservice.order.domain.port.out.OrderCreatedEventPublisher;
import com.microservice.order.domain.port.out.OrderRepository;
import com.microservice.order.domain.port.out.ProductClientPort;
import com.microservice.order.infrastructure.adapter.outbound.kafka.OrderEventMapper;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class CreateOrderService implements CreateOrderUseCase{
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductClientPort client;
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
			ProductInfo product = client.findProductById(item.getProductId());
			item.setPrice(new Money(product.getPrice(),product.getCurrency()));
		}
		order.calculateTotal();
		Order saved = orderRepository.save(order);
		entityManager.flush(); //se fuerza el commit a la db
		
		publisher.publish(mapperEvent.toEvent(order));
		
		return saved;
	}

}
