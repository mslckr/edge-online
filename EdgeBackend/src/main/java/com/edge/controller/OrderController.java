package com.edge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edge.dto.OrderConfirmationDTO;
import com.edge.dto.OrderDTO;
import com.edge.dto.OrderLineDTO;
import com.edge.model.Order;
import com.edge.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders")
	private ResponseEntity<List<OrderLineDTO>> getAllOrders(){
		List<OrderLineDTO> all=orderService.fetchAllOrderLines();
		return ResponseEntity.ok().body(all);
	}
	@GetMapping("/order")
	private ResponseEntity<List<OrderDTO>> getAllOrder(){
		List<OrderDTO> all=orderService.fetchAllOrders();
		return ResponseEntity.ok().body(all);
	}
	
	@PostMapping("/orders")
	private ResponseEntity<OrderConfirmationDTO>createOrder(@RequestBody OrderLineDTO orderLine) {
		
		OrderConfirmationDTO saveOrder = orderService.submitOrder(orderLine);
		return ResponseEntity.ok().body(saveOrder);
	}
	
	// method to ship an order based on orderline id.
	@PostMapping("/orders/{id}")
	public ResponseEntity<OrderLineDTO> shipOrders(@PathVariable(name = "id") int orderLineId) {
		OrderLineDTO orderline = orderService.completeOrders(orderLineId);
		return ResponseEntity.ok().body(orderline);
	}

}
