package com.edge.mapper;

import org.springframework.stereotype.Component;
import com.edge.dto.OrderDTO;
import com.edge.model.Order;

@Component
public class OrderMapper {

	public Order toEntity(OrderDTO dto) {
		Order order= new Order();
		
		order.setItem(dto.getItem());
		//order.setOrderline(dto.getOrderline());
		order.setAmount(dto.getAmount());
		order.setComplete(dto.isComplete());
		
		return order;
	}
	
	public OrderDTO toDto(Order entity) {
		OrderDTO dto =new OrderDTO();
		dto.setItem(entity.getItem());
		//dto.setOrderline(entity.getOrderline());
		dto.setAmount(entity.getAmount());
		dto.setComplete(entity.isComplete());
		return dto;
	}
}
