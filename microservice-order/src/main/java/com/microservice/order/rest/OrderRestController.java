package com.microservice.order.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sm/order")
public class OrderRestController {

	@GetMapping("/test")
	public String probarComunicacionConGateway() {
		return "Hola desde el gateway";
	}
}
