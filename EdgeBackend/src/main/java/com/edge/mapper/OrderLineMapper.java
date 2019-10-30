package com.edge.mapper;

import org.springframework.stereotype.Component;

import com.edge.dto.OrderLineDTO;
import com.edge.model.OrderLine;

@Component
public class OrderLineMapper {

	public OrderLineDTO toDto(OrderLine entity) {
		OrderLineDTO dto= new OrderLineDTO();
		dto.setId(entity.getId());
		dto.setAuth_code(entity.getAuth_code());
		dto.setOrder_stage(entity.getOrder_stage());
		dto.setUser_name(entity.getUser_name());
		dto.setUser_address(entity.getUser_address());
		dto.setUser_card_expdate(entity.getUser_card_expdate());
		dto.setUser_card_no(entity.getUser_card_no());
		dto.setUser_card_sec(entity.getUser_card_sec());
		return dto;
	}
	
	public OrderLine toEntity(OrderLineDTO dto) {
		OrderLine orderline =new OrderLine();
		orderline.setId(dto.getId());
		orderline.setAuth_code(dto.getAuth_code());
		orderline.setOrder_stage(dto.getOrder_stage());
		orderline.setUser_name(dto.getUser_name());
		orderline.setUser_address(dto.getUser_address());
		orderline.setUser_card_expdate(dto.getUser_card_expdate());
		orderline.setUser_card_no(dto.getUser_card_no());
		orderline.setUser_card_sec(dto.getUser_card_sec());
		
		return orderline;
	}
		
}
