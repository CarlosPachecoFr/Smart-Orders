package com.microservice.order.infrastructure.adapter.outbound.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-product")
public interface ProductClient {
	
	@GetMapping("/sm/product/findProductById/{productId}")
	ProductDto findProductById(@PathVariable Long productId);
	
}
