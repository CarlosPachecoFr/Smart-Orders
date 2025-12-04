package com.microservice.product.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.events.OrderCreatedEvent;
import com.common.events.OrderItemCreatedEvent;
import com.microservice.product.application.event.StockEventPublisher;
import com.microservice.product.application.usecase.ReserveStockUseCase;
import com.microservice.product.domain.model.Product;
import com.microservice.product.domain.repository.ProductRepository;
import com.microservice.product.infrastructure.persistence.mapper.ProductMapper;

@Service
public class ReserveStockService implements ReserveStockUseCase{
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductMapper mapper;
	@Autowired
	StockEventPublisher publisher;

	@Override
	public void reserve(OrderCreatedEvent event) {
		try {
			for(OrderItemCreatedEvent item: event.getItems()) {
				Product product = productRepository.findById(item.getProductId());
				product.reserve(item.getQuantity());
				
				productRepository.save(product);
			}
			
			publisher.stockReserved(event.getId());
			
		} catch (Exception e) {
			publisher.stockRejected(event.getId());
		}
		
	}

}
