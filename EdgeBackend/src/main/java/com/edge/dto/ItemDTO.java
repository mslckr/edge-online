package com.edge.dto;

import javax.validation.constraints.NotNull;


public class ItemDTO {
	
	@NotNull
	private long id;
	private String item_name;
	private String item_cat;
	private double item_price;
	private int item_rating;
	private String item_img;
	private int item_stock;
	private ProviderDTO provider;
	
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_cat() {
		return item_cat;
	}
	public void setItem_cat(String item_cat) {
		this.item_cat = item_cat;
	}
	public int getItem_rating() {
		return item_rating;
	}
	public void setItem_rating(int item_rating) {
		this.item_rating = item_rating;
	}
	
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
	
	public int getItem_stock() {
		return item_stock;
	}
	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}
	public ProviderDTO getProvider() {
		return provider;
	}
	public void setProvider(ProviderDTO provider) {
		this.provider = provider;
	}
}
