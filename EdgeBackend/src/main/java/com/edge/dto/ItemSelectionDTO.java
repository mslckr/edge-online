package com.edge.dto;

import com.edge.model.Item;

public class ItemSelectionDTO {
	
	private Item item;
	private int quantity;
	private double total_amount;
	
	public ItemSelectionDTO() {
		
	}
	
	
	public ItemSelectionDTO(Item item, String name, int quantity) {
		super();
		this.setItem(item);
		this.quantity = quantity;
	}

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
		return "ItemSelectionDTO [item=" + item + ", quantity=" + quantity + ", total_amount="
				+ total_amount + "]";
	}
	
	
	
	
}
