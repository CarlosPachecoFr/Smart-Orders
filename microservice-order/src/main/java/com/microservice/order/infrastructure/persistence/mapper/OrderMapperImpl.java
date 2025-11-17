package com.microservice.order.infrastructure.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.microservice.order.domain.model.Money;
import com.microservice.order.domain.model.Order;
import com.microservice.order.domain.model.OrderItem;
import com.microservice.order.infrastructure.persistence.MoneyEmbeddable;
import com.microservice.order.infrastructure.persistence.OrderEntity;
import com.microservice.order.infrastructure.persistence.OrderItemEntity;


@Component
public class OrderMapperImpl implements OrderMapper{

	@Override
	public OrderEntity toEntity(Order order) {
		OrderEntity oe = new OrderEntity();
		oe.setStatus(order.getStatus());
		oe.setTotal(this.toEmbeddable(order.getTotal()));
		
		List<OrderItemEntity> itemEntities = new ArrayList<>();
		for(OrderItem i: order.getOrderItems()) {
			OrderItemEntity oie = new OrderItemEntity();
			oie.setProductId(i.getProductId());
			oie.setQuantity(i.getQuantity());
			oie.setPrice(this.toEmbeddable(i.getPrice()));
			
			oie.setOrder(oe);
			itemEntities.add(oie);
		}
		oe.setOrderItems(itemEntities);
		return oe;
	}

	@Override
	public Order toDomain(OrderEntity orderEntity) {
		Order order = new Order();
		order.setId(orderEntity.getId());
		order.setStatus(orderEntity.getStatus());
		order.setTotal(this.toDomain(orderEntity.getTotal()));
		
		List<OrderItem> items = new ArrayList<>();
		for(OrderItemEntity i: orderEntity.getOrderItems()) {
			OrderItem oi = new OrderItem();
			oi.setProductId(i.getProductId());
			oi.setPrice(this.toDomain(i.getPrice()));
			oi.setQuantity(i.getQuantity());
			
			items.add(oi);
		}
		order.setOrderItems(items);
		return order;
	}

	@Override
	public MoneyEmbeddable toEmbeddable(Money money) {
		return new MoneyEmbeddable(money.getAmount(),money.getCurrency());
	}

	@Override
	public Money toDomain(MoneyEmbeddable moneyEmbeddable) {
		return new Money(moneyEmbeddable.getAmount(), moneyEmbeddable.getCurrency());
	}
	
	

}
