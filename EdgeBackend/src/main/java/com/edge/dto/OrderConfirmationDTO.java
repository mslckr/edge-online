package com.edge.dto;

public class OrderConfirmationDTO {
	
	private int orderId;
	private int auth_code;
	private double amount;
	
	public OrderConfirmationDTO() {
		
	}
	
	public OrderConfirmationDTO(int orderId, int auth_code, double amount) {
		super();
		this.orderId = orderId;
		this.auth_code = auth_code;
		this.amount = amount;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(int auth_code) {
		this.auth_code = auth_code;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
