package com.edge.dto;

public class ItemSelectionDTO {
	
	private long item_id;
	private String name;
	private double price;
	private int quantity;
	
	public ItemSelectionDTO() {
		
	}
	
	public ItemSelectionDTO(long item_id, String name, double price, int quantity) {
		super();
		this.item_id = item_id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public long getItem_id() {
		return item_id;
	}

	public void setItem_id(long item_id) {
		this.item_id = item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
