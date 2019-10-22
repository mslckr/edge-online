package com.edge.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne
	@JoinColumn(name="item_id")
	private Item item;
	
	private int amount;
	
	@ManyToOne
	@JoinColumn(name="orderline_id")
	private OrderLine orderline;
	
	private boolean complete;
	
	public Order() {}
	

	public Order(long id, Item item, int amount, OrderLine orderline, boolean complete) {
		super();
		this.id = id;
		this.item = item;
		this.amount = amount;
		this.orderline = orderline;
		this.complete = complete;
	}

	public Order(Item item, int amount, OrderLine orderline, boolean complete) {
		super();
		this.item = item;
		this.amount = amount;
		this.orderline = orderline;
		this.complete = complete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public OrderLine getOrderline() {
		return orderline;
	}


	public void setOrderline(OrderLine orderline) {
		this.orderline = orderline;
	}

}
