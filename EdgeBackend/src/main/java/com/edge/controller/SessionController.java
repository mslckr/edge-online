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
	
}
