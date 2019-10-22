package com.edge.dto;

public class CheckoutDTO {

	private String name;
	private String address;
	private String cardNumber;
	private String cardExpiry;
	private int cardSecurityCode;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public int getCardSecurityCode() {
		return cardSecurityCode;
	}
	public void setCardSecurityCode(int cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}
	
	
}
