package com.microservice.product.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.product.application.usecase.ReserveStockUseCase;
import com.microservice.product.domain.model.Product;
import com.microservice.product.domain.repository.ProductRepository;

@Service
public class ReserveStockService implements ReserveStockUseCase{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product reserve(Product product) {
		return productRepository.reserve(product);
	}

}
