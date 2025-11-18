package com.microservice.product.web.mapper;

import org.springframework.stereotype.Component;

import com.microservice.product.domain.model.Product;
import com.microservice.product.web.dto.ProductRequest;
import com.microservice.product.web.dto.ProductResponse;

@Component
public class ProductWebMapperImpl implements ProductWebMapper{

	@Override
	public Product toDomain(ProductRequest request) {
		Product product = new Product();
		product.setProductId(request.getProductId());
		product.setQuantity(request.getQuantity());
		return product;
	}

	@Override
	public ProductResponse toDto(Product product) {
		ProductResponse response = new ProductResponse();
		response.setProductId(product.getProductId());
		response.setName(product.getName());
		response.setStock(product.getStock());
		response.setCurrency(product.getPrice().getCurrency());
		response.setPrice(product.getPrice().getAmount());
		return response;
	}

}
