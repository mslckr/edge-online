package com.edge.model;

import java.io.Serializable;

import javax.persistence.Id;

public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private long item_id;
	private int amount;
	private int orderlist_id;
	private boolean complete= false;
	
	public Order(long item_id, int amount, int orderlist_id, boolean complete) {
		super();
		this.item_id = item_id;
		this.amount = amount;
		this.orderlist_id = orderlist_id;
		this.complete = complete;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
