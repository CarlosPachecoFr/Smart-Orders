package com.microservice.product.infrastructure.adapter.intbound.web.mapper;

import com.microservice.product.domain.model.Product;
import com.microservice.product.infrastructure.adapter.intbound.web.dto.ProductRequest;
import com.microservice.product.infrastructure.adapter.intbound.web.dto.ProductResponse;

public interface ProductWebMapper {

	Product toDomain(ProductRequest request);
	ProductResponse toDto(Product product);
}
