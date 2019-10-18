package com.edge.dto;

import javax.validation.constraints.NotNull;

public class ItemDTO {
	
	@NotNull
	private long id;
	private double item_price;
	private String item_img;
	private int prov_id;
	private int item_stock;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getItem_price() {
		return item_price;
	}
	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}
	public String getItem_img() {
		return item_img;
	}
	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}
	public int getProv_id() {
		return prov_id;
	}
	public void setProv_id(int prov_id) {
		this.prov_id = prov_id;
	}
	public int getItem_stock() {
		return item_stock;
	}
	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}
}
