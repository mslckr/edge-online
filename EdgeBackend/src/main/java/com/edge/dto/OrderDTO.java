package com.edge.dto;

import javax.validation.constraints.NotNull;

import com.edge.model.Item;
import com.edge.model.OrderLine;

public class OrderDTO {

	@NotNull
	private Item item;
	private int amount;
	//private OrderLine orderline;
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
	/*public OrderLine getOrderline() {
		return orderline;
	}
	public void setOrderline(OrderLine orderline) {
		this.orderline = orderline;
	}*/
	
}
