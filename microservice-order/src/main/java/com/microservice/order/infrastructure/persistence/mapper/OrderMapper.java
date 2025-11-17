package com.microservice.order.infrastructure.persistence.mapper;

import com.microservice.order.domain.model.Money;
import com.microservice.order.domain.model.Order;
import com.microservice.order.infrastructure.persistence.MoneyEmbeddable;
import com.microservice.order.infrastructure.persistence.OrderEntity;

public interface OrderMapper {

	OrderEntity toEntity(Order order);
	Order toDomain(OrderEntity orderEntity);
	MoneyEmbeddable toEmbeddable(Money money);
	Money toDomain(MoneyEmbeddable moneyEmbeddable);
}
