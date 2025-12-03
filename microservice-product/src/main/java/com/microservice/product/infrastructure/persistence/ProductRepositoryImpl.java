package com.microservice.product.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservice.product.domain.model.Product;
import com.microservice.product.domain.repository.ProductRepository;
import com.microservice.product.infrastructure.persistence.mapper.ProductMapper;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	
	@Autowired
	private JpaProductRepository  jpaProductRepository;
	@Autowired
	private ProductMapper productMapper;

	@Override
	public Product findById(Long productId) {
		 ProductEntity entity = jpaProductRepository.findById(productId)
	        .orElseThrow(() -> new RuntimeException("Product not found"));

	    return productMapper.toDomain(entity);
	}

	@Override
	public void save(Product product) {
		ProductEntity entity = productMapper.toEntity(product);
		
		jpaProductRepository.save(entity);
	}

}
