package com.microservice.product.application.usecase;

import com.microservice.product.domain.model.Product;

public interface FindProductByIdUseCase {

	Product findProductById(Long productId);
}
