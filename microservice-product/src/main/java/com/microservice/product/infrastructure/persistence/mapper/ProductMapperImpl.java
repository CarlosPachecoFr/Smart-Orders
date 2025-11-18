package com.microservice.product.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.microservice.product.domain.model.Money;
import com.microservice.product.domain.model.Product;
import com.microservice.product.infrastructure.persistence.MoneyEmbeddable;
import com.microservice.product.infrastructure.persistence.ProductEntity;

@Component
public class ProductMapperImpl implements ProductMapper{

	@Override
	public ProductEntity toEntity(Product product) {
		ProductEntity pe = new ProductEntity();
		pe.setStock(product.getStock());
		return pe;
	}

	@Override
	public Product toDomain(ProductEntity productEntity) {
		Product product = new Product();
		product.setProductId(productEntity.getProductId());
		product.setName(productEntity.getName());
		product.setStock(productEntity.getStock());
		product.setPrice(this.toDomain(productEntity.getPrice()));
		return product;
	}

	@Override
	public MoneyEmbeddable toEmbeddable(Money money) {
		return new MoneyEmbeddable(money.getAmount(),money.getCurrency());
	}

	@Override
	public Money toDomain(MoneyEmbeddable moneyEmbeddable) {
		return new Money(moneyEmbeddable.getAmount(), moneyEmbeddable.getCurrency());
	}
}
