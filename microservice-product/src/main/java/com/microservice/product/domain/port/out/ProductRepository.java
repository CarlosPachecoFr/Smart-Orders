package com.microservice.product.domain.port.out;

import com.microservice.product.domain.model.Product;

public interface ProductRepository {
	
	Product findById(Long productId);
	void save(Product product);
}
