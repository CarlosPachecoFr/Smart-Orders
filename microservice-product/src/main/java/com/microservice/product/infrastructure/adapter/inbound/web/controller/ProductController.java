package com.microservice.product.infrastructure.adapter.intbound.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.product.domain.port.in.FindProductByIdUseCase;
import com.microservice.product.infrastructure.adapter.intbound.web.dto.ProductResponse;
import com.microservice.product.infrastructure.adapter.intbound.web.mapper.ProductWebMapper;

@RestController
@RequestMapping("/sm/product")
public class ProductController {
	
	@Autowired
	private FindProductByIdUseCase findByIduseCase;
	@Autowired
	private ProductWebMapper mapper;
	
	@GetMapping("/findProductById/{productId}")
	public ProductResponse findProductById(@PathVariable Long productId) {
		return mapper.toDto(findByIduseCase.findProductById(productId));
	}
	
}
