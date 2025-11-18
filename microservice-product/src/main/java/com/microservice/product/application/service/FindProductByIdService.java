package com.microservice.product.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.product.application.usecase.FindProductByIdUseCase;
import com.microservice.product.domain.model.Product;
import com.microservice.product.domain.repository.ProductRepository;

@Service
public class FindProductByIdService implements FindProductByIdUseCase{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product findProductById(Long productId) {
		return productRepository.findById(productId);
	}

}
