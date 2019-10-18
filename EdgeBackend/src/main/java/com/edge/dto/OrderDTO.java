package com.edge.dto;

import javax.validation.constraints.NotNull;

public class OrderDTO {

	@NotNull
	private long item_id;
	private int amount;
	private int orderlist_id;
	private boolean complete= false;
	public long getItem_id() {
		return item_id;
	}
	public void setItem_id(long item_id) {
		this.item_id = item_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getOrderlist_id() {
		return orderlist_id;
	}
	public void setOrderlist_id(int orderlist_id) {
		this.orderlist_id = orderlist_id;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
}
