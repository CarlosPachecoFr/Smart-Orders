package com.microservice.product.infrastructure.persistence.mapper;

import com.microservice.product.domain.model.Money;
import com.microservice.product.domain.model.Product;
import com.microservice.product.infrastructure.persistence.MoneyEmbeddable;
import com.microservice.product.infrastructure.persistence.ProductEntity;

public interface ProductMapper {
	
	ProductEntity toEntity(Product product);
	Product toDomain(ProductEntity productEntity);
	MoneyEmbeddable toEmbeddable(Money money);
	Money toDomain(MoneyEmbeddable moneyEmbeddable);
}
