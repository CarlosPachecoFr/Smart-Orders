package com.microservice.order.web.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.microservice.order.domain.model.Money;
import com.microservice.order.domain.model.Order;
import com.microservice.order.domain.model.OrderItem;
import com.microservice.order.web.dto.CreateOrderRequest;
import com.microservice.order.web.dto.OrderItemRequest;
import com.microservice.order.web.dto.OrderItemResponse;
import com.microservice.order.web.dto.OrderResponse;


@Component
public class OrderWebMapperImpl implements OrderWebMapper{

	@Override
	public Order toDomain(CreateOrderRequest orderRequest) {
		List<OrderItem> orderItemList = new ArrayList<>();
		for(OrderItemRequest i: orderRequest.getOrderItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setProductId(i.getProductId());
			orderItem.setQuantity(i.getQuantity());
			
			orderItemList.add(orderItem);
		}
		Order order = new Order(orderItemList);
		return order;
	}

	@Override
	public OrderResponse toDto(Order order) {
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setStatus(order.getStatus());
		orderResponse.setTotal(order.getTotal().getAmount());
		orderResponse.setCurrency(order.getTotal().getCurrency());
		List<OrderItemResponse> orderItemList = new ArrayList<>();
		for(OrderItem i: order.getOrderItems()) {
			OrderItemResponse oi = new OrderItemResponse();
			oi.setProductId(i.getProductId());
			oi.setQuantity(i.getQuantity());
			oi.setPrice(i.getPrice().getAmount());
			oi.setCurrency(i.getPrice().getCurrency());
			
			orderItemList.add(oi);
		}
		orderResponse.setOrderItems(orderItemList);
		return orderResponse;
	}

}
