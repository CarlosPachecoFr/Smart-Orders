package com.microservice.order.domain.port.out;

import com.microservice.order.domain.model.ProductInfo;

public interface ProductClientPort {

	ProductInfo findProductById(Long productId);
	
}
