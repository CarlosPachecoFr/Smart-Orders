package com.microservice.order.infrastructure.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.common.events.OrderCreatedEvent;
import com.common.events.OrderItemCreatedEvent;
import com.microservice.order.domain.model.Order;
import com.microservice.order.domain.model.OrderItem;

@Component
public class OrderEventMapper {

	public OrderCreatedEvent toEvent(Order order) {
		OrderCreatedEvent event = new OrderCreatedEvent();
		event.setId(order.getId());
		
		List<OrderItemCreatedEvent> items = new ArrayList<>();
		for(OrderItem i: order.getOrderItems()) {
			OrderItemCreatedEvent itemEvent = new OrderItemCreatedEvent();
			itemEvent.setProductId(i.getProductId());
			itemEvent.setQuantity(i.getQuantity());
			
			items.add(itemEvent);
		}
		
		event.setItems(items);
		return event;
	}
}
