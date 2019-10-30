package com.edge.dto;

import java.util.List;

public class CartDTO {
	
	private List<ItemSelectionDTO> cartItems;
	private int quantity;
	private double Total;
	
	public List<ItemSelectionDTO> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<ItemSelectionDTO> cartItems) {
		this.cartItems = cartItems;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return Total;
	}
	public void setTotal(double Total) {
		this.Total=Total;
	}
//
	

}
