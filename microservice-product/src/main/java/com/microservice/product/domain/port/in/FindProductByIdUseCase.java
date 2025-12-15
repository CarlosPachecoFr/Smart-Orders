package com.microservice.product.domain.port.in;

import com.microservice.product.domain.model.Product;

public interface FindProductByIdUseCase {

	Product findProductById(Long productId);
}
