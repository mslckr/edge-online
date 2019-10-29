package com.edge.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edge.dto.CartDTO;
import com.edge.dto.CheckoutDTO;
import com.edge.dto.ItemSelectionDTO;
import com.edge.dto.OrderConfirmationDTO;
import com.edge.dto.OrderDTO;
import com.edge.dto.OrderLineDTO;
import com.edge.mapper.OrderLineMapper;
import com.edge.mapper.OrderMapper;
import com.edge.model.Item;
import com.edge.model.Order;
import com.edge.model.OrderLine;
import com.edge.repository.ItemRepository;
import com.edge.repository.OrderLineRepository;
import com.edge.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderLineRepository orderLineRepository;
	
	@Autowired
	OrderMapper orderMapper;
	
	@Autowired
	OrderLineMapper orderLineMapper;
	
	//fetch all orders
	public List<OrderDTO> fetchAllOrders(){
		return orderRepository.findAll().stream().map(o-> orderMapper.toDto(o)).collect(Collectors.toList());
	}
	
	//fetch all order with specified orderLineId
	public List<OrderDTO> fetchOrdersInLine (OrderLine orderLine){
		return orderRepository.findAllByOrderline_id(orderLine.getId()).stream()
				.map(o -> orderMapper.toDto(o)).collect(Collectors.toList());
	}
	
	//fetch all orderLines
	public List<OrderLineDTO> fetchAllOrderLines(){
		return orderLineRepository.findAll().stream().map(o -> orderLineMapper.toDto(o)).collect(Collectors.toList());
	}
	
	//
//	public OrderConfirmationDTO submitOrders (OrderLineDTO orderLine, CartDTO cart) {
//		
//		try{
//			if(orderLine.getOrder_stage() != 10)
//				throw new Exception();
//		}
//		catch(Exception e) {
//			System.out.println("ERROR: Invalid Order Stage Code");
//		}
//		
//		OrderConfirmationDTO orderConfirmation= new OrderConfirmationDTO();
//					
//		OrderLine newOrderLine= new OrderLine();
//			
//			CheckoutDTO payment= orderLine.getPayment();
//			List<Item> allItems= itemRepository.findAll();
//			Map<Long, Item> itemsMap= allItems.stream().collect(Collectors.toMap(Item::getId, i -> i));
//			
//			newOrderLine.setUser_name(orderLine.getUser_name());
//			newOrderLine.setUser_address(orderLine.getUser_address());
//			newOrderLine.setUser_card_no(payment.getCardNumber());
//			newOrderLine.setUser_card_expdate(payment.getCardExpiry());
//			newOrderLine.setUser_card_sec(payment.getCardSecurityCode());
//			
//			
//			List<OrderDTO> fetchedOrders= fetchOrdersInLine(orderLineMapper.toEntity(orderLine));
//			for (OrderDTO order : fetchedOrders) {
//				if(itemService.findOne(order.getItem().getId()) == null) {
//					newOrderLine.setOrder_stage(20);
//					newOrderLine.setAuth_code(0);
//					orderConfirmation.setOrderId(orderLine.getId());
//					orderConfirmation.setAuth_code(orderLine.getAuth_code());
//					orderConfirmation.setAmount(cart.getTotalPrice());
//					return orderConfirmation;
//				}
//			}
//			newOrderLine.setOrder_stage(11);
//			
//			OrderLine savedOrderLine =orderLineRepository.save(newOrderLine);
//			
//			List<ItemSelectionDTO> items =orderLine.getItems();
//			Set<Order> orders= new HashSet<>();
//			for(ItemSelectionDTO i: items)
//				orders.add(new Order(itemsMap.get(i.getItem_id()), i.getQuantity(), savedOrderLine,false));
//			
//			orderConfirmation.setOrderId(savedOrderLine.getId());
//			orderConfirmation.setAuth_code(savedOrderLine.getAuth_code());
//			orderConfirmation.setAmount(cart.getTotalPrice());
//			return orderConfirmation;
//	}
	
	//Complete orderline with orderline id
	public OrderLineDTO completeOrders(int orderLine_id) {
		OrderLine orderLine= orderLineRepository.findById(orderLine_id).get();
		List<OrderDTO> fetchedOrders= fetchOrdersInLine(orderLine);
		
		if(orderLine.getOrder_stage() == 11) {
			
			fetchedOrders= fetchedOrders.stream()
			.filter(o -> o.getItem().getItem_stock() >0)
			.map((OrderDTO o) -> {
				o.setComplete(true);
				return o;
				})
			.collect(Collectors.toList());
		}
		else {
			System.out.println("ERROR: Invalid Order Stage Code");
		}
		orderLine.setOrder_stage(12);
		return orderLineMapper.toDto(orderLine);
	}
	
	// terminate orders with the same orderLine id and sets
	// orderline's order_stage to 21
	public void terminateOrders(OrderLineDTO orderLine) {
		if(orderLine.getOrder_stage() != 10) {
			System.out.println("Error: Can't terminate Order of 0rder_stage = 10");
			return;
		}
		List<Order> ordersToDelete = orderRepository.findAllByOrderline_id(orderLine.getId());
		orderRepository.deleteAll(ordersToDelete);
		
		orderLine.setOrder_stage(21);
	}

	public OrderConfirmationDTO submitOrder(OrderLineDTO orderLine) {
		
		try{
			if(orderLine.getOrder_stage() != 10)
				throw new Exception();
		}
		catch(Exception e) {
			System.out.println("ERROR: Invalid Order Stage Code");
		}
		
		OrderConfirmationDTO orderConfirmation= new OrderConfirmationDTO();
					
		OrderLine newOrderLine= orderLineMapper.toEntity(orderLine);
			
			//CheckoutDTO payment= orderLine.getPayment();
//			
//			newOrderLine.setUser_name(orderLine.getUser_name());
//			newOrderLine.setUser_address(orderLine.getUser_address());
//			newOrderLine.setUser_card_no(payment.getCardNumber());
//			newOrderLine.setUser_card_expdate(payment.getCardExpiry());
//			newOrderLine.setUser_card_sec(payment.getCardSecurityCode());
			
			
			List<OrderDTO> fetchedOrders= fetchOrdersInLine(orderLineMapper.toEntity(orderLine));
			for (OrderDTO order : fetchedOrders) {
				if(itemService.findOne(order.getItem().getId()) == null) {
					newOrderLine.setOrder_stage(20);
					orderConfirmation.setAuth_code(0);
					
					orderConfirmation.setOrderId(orderLine.getId());
					//orderConfirmation.setAuth_code(orderLine.getAuth_code());
					orderConfirmation.setAmount(orderLine.getCart().getTotalPrice());
					
					return orderConfirmation;
				}
			}
			orderLine.setOrder_stage(11);
			
			OrderLine savedOrderLine =orderLineRepository.save(newOrderLine);
			
			/*List<ItemSelectionDTO> items =orderLine.getItems();
			Set<Order> orders= new HashSet<>();
			for(ItemSelectionDTO i: items)
				orders.add(new Order(itemsMap.get(i.getItem_id()), i.getQuantity(), savedOrderLine,false));
			*/
			orderConfirmation.setOrderId(savedOrderLine.getId());
			orderConfirmation.setAuth_code(savedOrderLine.getAuth_code());
			orderConfirmation.setAmount(orderLine.getCart().getTotalPrice());
			return orderConfirmation;
	}

}
