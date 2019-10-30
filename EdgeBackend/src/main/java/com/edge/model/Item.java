package com.edge.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="item")
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String item_name;
	private String item_cat;
	private double item_price;
	private String item_img;
	private int item_rating;
	private int item_stock;
	
	@ManyToOne
	@JoinColumn(name="prov_id")
	@JsonIgnore
	private Provider provider;
	
	public Item() {
		
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

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public int getItem_stock() {
		return item_stock;
	}

	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}

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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", item_name=" + item_name + ", item_cat=" + item_cat + ", item_price=" + item_price
				+ ", item_img=" + item_img + ", item_rating=" + item_rating + ", item_stock=" + item_stock
				+ ", provider=" + provider + "]";
	}
	
}
