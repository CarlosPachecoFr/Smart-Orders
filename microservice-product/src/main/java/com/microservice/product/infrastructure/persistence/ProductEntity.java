package com.microservice.product.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class ProductEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Long productId;
	
	@Column
	private String name;
	
	@Column
	private int stock;
	
	@Embedded
	private MoneyEmbeddable price;

}
