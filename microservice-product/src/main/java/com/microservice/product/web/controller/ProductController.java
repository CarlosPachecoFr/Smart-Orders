package com.microservice.product.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.product.application.usecase.FindProductByIdUseCase;
import com.microservice.product.application.usecase.ReserveStockUseCase;
import com.microservice.product.web.dto.ProductRequest;
import com.microservice.product.web.dto.ProductResponse;
import com.microservice.product.web.mapper.ProductWebMapper;

@RestController
@RequestMapping("/sm/product")
public class ProductController {
	
	@Autowired
	private FindProductByIdUseCase findByIduseCase;
	@Autowired
	private ReserveStockUseCase reserveStockuseCase;
	@Autowired
	private ProductWebMapper mapper;
	
	@GetMapping("/findProductById/{productId}")
	public ProductResponse findProductById(@PathVariable Long productId) {
		return mapper.toDto(findByIduseCase.findProductById(productId));
	}
	
	@PostMapping("/reserve")
	public ProductResponse reserve(@RequestBody ProductRequest request) {
		return mapper.toDto(reserveStockuseCase.reserve(mapper.toDomain(request)));
	}
	
}
