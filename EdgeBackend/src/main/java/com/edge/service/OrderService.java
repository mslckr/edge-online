package com.edge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edge.dto.CartDTO;
import com.edge.dto.CheckoutDTO;
import com.edge.dto.OrderConfirmationDTO;
import com.edge.dto.OrderDTO;
import com.edge.dto.OrderLineDTO;
import com.edge.mapper.OrderMapper;
import com.edge.model.OrderLine;
import com.edge.repository.OrderLineRepository;
import com.edge.repository.OrderRepository;


public class OrderService {

	@Autowired
	ItemService itemService;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderLineRepository orderListRepository;
	
	@Autowired
	OrderMapper orderMapper;
	
	//fetch all orders
	List<OrderDTO> fetchAllOrders(){
		return orderRepository.findAll().stream().map(o-> orderMapper.toDto(o)).collect(Collectors.toList());
	}
	//fetch all order with specified orderLineId
	List<OrderDTO> fetchOrdersInLine (OrderLine orderLine){
		return orderRepository.findAllByOrderLine(orderLine);
	}
	
	//
	OrderConfirmationDTO submitOrders (OrderLineDTO orderLine, CartDTO cart) {
		CheckoutDTO payment;
		if(orderLine.getOrder_stage() == 10) {
			List<OrderDTO> fetchedOrders= fetchOrdersInLine(orderLine.getId());
			for (OrderDTO order : fetchedOrders) {
				if(itemService.findOne(order.get) == null) {
					orderLine.setOrder_stage(20);
					orderList.setAuth_code(0);
					break;
				}
			}
			orderLine.setOrder_stage(11);
		}
		else {
			System.out.println("ERROR: Invalid Order Stage Code");
		}
	}
	
	OrderLineDTO completeOrders(OrderLine orderLine) {
		List<OrderDTO> fetchedOrders= fetchOrdersInLine(orderLine);
		if(orderLine.getOrder_stage() == 11) {
		for (OrderDTO order : fetchedOrders) {
			if(itemService.findOne(order.getItem()).getItem_stock() > 0) {
				order.setComplete(true);
	
			}
		}
		}
		orderLine.setOrder_stage(12);
	}
	
	void terminateOrders(int orderListId) {
		
	}


}
