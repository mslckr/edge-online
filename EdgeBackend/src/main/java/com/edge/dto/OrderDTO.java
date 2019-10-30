package com.edge.dto;

import javax.validation.constraints.NotNull;

import com.edge.model.Item;

public class OrderDTO {

	@NotNull
	private Item item;
	private int amount;

	private boolean complete= false;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
}
