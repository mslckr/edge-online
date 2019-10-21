package com.edge.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="provider")
public class Provider implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String prov_name;
	private String prov_addr;
	private String prov_logo;
	private String prov_link;
	
	@OneToMany(mappedBy="provider", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Item> items;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProv_name() {
		return prov_name;
	}

	public void setProv_name(String prov_name) {
		this.prov_name = prov_name;
	}

	public String getProv_addr() {
		return prov_addr;
	}

	public void setProv_addr(String prov_addr) {
		this.prov_addr = prov_addr;
	}

	public String getProv_logo() {
		return prov_logo;
	}

	public void setProv_logo(String prov_logo) {
		this.prov_logo = prov_logo;
	}

	public String getProv_link() {
		return prov_link;
	}

	public void setProv_link(String prov_link) {
		this.prov_link = prov_link;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
