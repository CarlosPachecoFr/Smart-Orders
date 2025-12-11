package com.microservice.order.infrastructure.adapter.outbound.persistence.mapper;

import com.microservice.order.domain.model.Money;
import com.microservice.order.domain.model.Order;
import com.microservice.order.infrastructure.adapter.outbound.persistence.MoneyEmbeddable;
import com.microservice.order.infrastructure.adapter.outbound.persistence.OrderEntity;

public interface OrderMapper {

	OrderEntity toEntity(Order order);
	Order toDomain(OrderEntity orderEntity);
	MoneyEmbeddable toEmbeddable(Money money);
	Money toDomain(MoneyEmbeddable moneyEmbeddable);
}
