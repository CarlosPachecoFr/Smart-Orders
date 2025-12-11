package com.microservice.order.infrastructure.adapter.outbound.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.order.domain.model.ProductInfo;
import com.microservice.order.domain.port.out.ProductClientPort;

@Component
public class ProductClientAdapter implements ProductClientPort{
	
	@Autowired
	private ProductClient client;

	@Override
	public ProductInfo findProductById(Long productId) {
		ProductDto dto = client.findProductById(productId);
		return new ProductInfo(dto.getPrice(), dto.getCurrency());
	}

}
