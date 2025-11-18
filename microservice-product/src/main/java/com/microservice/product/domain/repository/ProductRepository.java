package com.microservice.product.domain.repository;

import com.microservice.product.domain.model.Product;

public interface ProductRepository {
	
	Product findById(Long productId);
	Product reserve(Product product);

}
