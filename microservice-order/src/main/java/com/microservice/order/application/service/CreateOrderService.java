package com.microservice.order.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.order.application.usecase.CreateOrderUseCase;
import com.microservice.order.domain.model.Money;
import com.microservice.order.domain.model.Order;
import com.microservice.order.domain.model.OrderItem;
import com.microservice.order.domain.repository.OrderRepository;
import com.microservice.order.infrastructure.client.ProductClient;
import com.microservice.order.infrastructure.client.ProductDto;
import com.microservice.order.infrastructure.client.ReserveStockRequest;

@Service
public class CreateOrderService implements CreateOrderUseCase{
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductClient client;

	@Override
	public Order createOrder(Order order) {
		for(OrderItem item: order.getOrderItems()) {
			ProductDto product = client.findProductById(item.getProductId());
			item.setPrice(new Money(product.getPrice(),product.getCurrency()));
			if(product.getStock() < item.getQuantity()) {
				throw new IllegalArgumentException("Not enough stock");
			}
			
			client.reserve(new ReserveStockRequest(item.getProductId(), item.getQuantity()));
		}
		order.calculateTotal();
		return orderRepository.save(order);
	}

}
