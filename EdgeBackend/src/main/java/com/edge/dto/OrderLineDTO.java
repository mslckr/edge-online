package com.edge.dto;

import java.sql.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.edge.model.Order;


public class OrderLineDTO {

	@NotNull
	private int id;
	private String user_name;
	private String user_address;
	private int order_stage;
	private String user_card_no;
	private int user_card_sec;
	private Date user_card_expdate;	//yyyy-mm-dd format
	private int auth_code;
	private Set<Order> orders;
	private CartDTO cart;
	//private OrderConfirmationDTO confirmation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public int getOrder_stage() {
		return order_stage;
	}
	public void setOrder_stage(int order_stage) {
		this.order_stage = order_stage;
	}
	public String getUser_card_no() {
		return user_card_no;
	}
	public void setUser_card_no(String user_card_no) {
		this.user_card_no = user_card_no;
	}
	public int getUser_card_sec() {
		return user_card_sec;
	}
	public void setUser_card_sec(int user_card_sec) {
		this.user_card_sec = user_card_sec;
	}
	public Date getUser_card_expdate() {
		return user_card_expdate;
	}
	public void setUser_card_expdate(Date user_card_expdate) {
		this.user_card_expdate = user_card_expdate;
	}
	public int getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(int auth_code) {
		this.auth_code = auth_code;
	}
//	public OrderConfirmationDTO getConfirmation() {
//		return confirmation;
//	}
//	public void setConfirmation(OrderConfirmationDTO confirmation) {
//		this.confirmation = confirmation;
//	}
//	public CheckoutDTO getPayment() {
//		return payment;
//	}
//	public void setPayment(CheckoutDTO payment) {
//		this.payment = payment;
//	}

	public CartDTO getCart() {
		return cart;
	}
	public void setCart(CartDTO cart) {
		this.cart = cart;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
}
