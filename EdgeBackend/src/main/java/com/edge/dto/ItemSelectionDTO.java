package com.edge.dto;

import com.edge.model.Item;

public class ItemSelectionDTO {
	
	private Item item;
	//private int item;
	private String name;
	//private double price;
	private int quantity;
	private double total_amount;
	
	public ItemSelectionDTO() {
		
	}
	
	
	public ItemSelectionDTO(Item item, String name, int quantity) {
		super();
		this.setItem(item);
		this.name = name;
		//this.price = price;
		this.quantity = quantity;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}


	public double getTotal_amount() {
		return total_amount;
	}


	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}


	@Override
	public String toString() {
		return "ItemSelectionDTO [item=" + item + ", name=" + name + ", quantity=" + quantity + ", total_amount="
				+ total_amount + "]";
	}
	
	
	
	
}
