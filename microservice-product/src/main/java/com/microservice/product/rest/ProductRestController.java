package com.microservice.product.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sm/product")
public class ProductRestController {
	
	@GetMapping("/test")
	public String probarComunicacionConGateway() {
		return "Hola estoy comunicado con el Gateway";
	}
}
