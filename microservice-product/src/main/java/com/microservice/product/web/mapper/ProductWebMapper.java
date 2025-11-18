package com.microservice.product.web.mapper;

import com.microservice.product.domain.model.Product;
import com.microservice.product.web.dto.ProductRequest;
import com.microservice.product.web.dto.ProductResponse;

public interface ProductWebMapper {

	Product toDomain(ProductRequest request);
	ProductResponse toDto(Product product);
}
