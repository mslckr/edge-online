package com.edge.controller;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edge.dto.CartDTO;
import com.edge.dto.CheckoutDTO;
import com.edge.dto.ItemSelectionDTO;
import com.edge.dto.OrderConfirmationDTO;
import com.edge.dto.OrderLineDTO;
import com.edge.service.OrderService;


@RestController
@RequestMapping("/api")
public class SessionController {
	// in memory store to contain the cart data for a user 
	private Map<String, CartDTO> cartStore = new HashMap<>();
	
	// in memory store to contain the payment and shipping data for a user
	private Map<String, CheckoutDTO> checkoutStore= new HashMap<>();
	
	@Autowired
	private OrderService orderService;
	
	// method to return the cart content to the UI. Fetch that from the in memory store
		@GetMapping("/session/cart")
			public ResponseEntity<CartDTO> getCart(@CookieValue(name = "JSESSIONID", required = false) String cookieValue) {
				CartDTO cartDTO = cartStore.get(cookieValue);
				if (cartDTO == null) {
					cartDTO = new CartDTO();
				}
				cartStore.put(cookieValue, cartDTO);
				return ResponseEntity.status(HttpStatus.OK).body(cartDTO);
			}
		
		// method to create a new cart based on selected items and store it in the cart store map
				@PostMapping("/session/cart")
				public ResponseEntity<ItemSelectionDTO[]> create(@RequestBody @Valid ItemSelectionDTO[] items,@CookieValue(name = "JSESSIONID", required = false) String cookieValue) throws URISyntaxException {
					CartDTO cartDTO = cartStore.get(cookieValue);
					if (cartDTO == null) {
						cartDTO = new CartDTO();
					}
					cartDTO.setSelections(items);
					double total = 0.0;
					for (ItemSelectionDTO s : items) {
						total += s.getQuantity() * s.getPrice();
					}
					cartDTO.setTotalPrice(total);

					cartStore.put(cookieValue, cartDTO);
					return ResponseEntity.ok().body(items);
				}
				// method to store the checkout details for a user based on session cookie
				@PostMapping("/session/checkout")
				public ResponseEntity<CheckoutDTO> checkout(@CookieValue(name = "JSESSIONID", required = false) String cookieValue, @RequestBody CheckoutDTO checkout) {
					checkoutStore.put(cookieValue, checkout);
					return ResponseEntity.status(HttpStatus.OK).body(checkout);
				}

				// method to get the checkout details of a user based on session cookie
				@GetMapping("/session/checkout")
				public ResponseEntity<CheckoutDTO> checkout(
						@CookieValue(name = "JSESSIONID", required = false) String cookieValue) {
					CheckoutDTO checkoutDTO = checkoutStore.get(cookieValue);
					return ResponseEntity.status(HttpStatus.OK).body(checkoutDTO);
				}

//			// method to create orderLine of orders and send out confirmation
//				@PostMapping("/orders")
//				public ResponseEntity<OrderConfirmationDTO> saveOrder(@CookieValue(name = "JSESSIONID", required = false) String cookieValue, @RequestBody OrderLineDTO order) {
//					CartDTO cartDTO = cartStore.get(cookieValue);
//					OrderConfirmationDTO saveOrder = orderService.submitOrders(order, cartDTO);
//					cartStore.remove(cookieValue);
//					checkoutStore.remove(cookieValue);
//					return ResponseEntity.ok().body(saveOrder);
//				}

//				// method to return all the orderLines
//				@GetMapping("/orders")
//				public ResponseEntity<List<OrderLineDTO>> fetchOrders(
//						@CookieValue(name = "JSESSIONID", required = false) String cookieValue) {
//					List<OrderLineDTO> orderLines = orderService.fetchAllOrderLines();
//					return ResponseEntity.ok().body(orderLines);
//				}
//
//			// method to ship an order based on orderline id.
//				@PostMapping("/orders/{id}")
//				public ResponseEntity<OrderLineDTO> shipOrders(@CookieValue(name = "JSESSIONID", required = false) String cookieValue, @PathVariable(name = "id") int orderLineId) {
//					OrderLineDTO orderline = orderService.completeOrders(orderLineId);
//					return ResponseEntity.ok().body(orderline);
//				}
}
