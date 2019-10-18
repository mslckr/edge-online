package com.edge.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrderList")
public class OrderList implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String user_name;
	private String user_address;
	private int order_stage;
	private String user_card_no;
	private int user_card_sec;
	private String user_card_expdate;	//yyyy-mm-dd format
	private int auth_code;

	public OrderList(int id, String user_name, String user_address, int order_stage, String user_card_no,
			int user_card_sec, String user_card_expdate, int auth_code) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_address = user_address;
		this.order_stage = order_stage;
		this.user_card_no = user_card_no;
		this.user_card_sec = user_card_sec;
		this.user_card_expdate = user_card_expdate;
		this.auth_code = auth_code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public int getOrder_stage() {
		return order_stage;
	}
	public void setOrder_stage(int order_stage) {
		this.order_stage = order_stage;
	}
	public String getUser_card_no() {
		return user_card_no;
	}
	public void setUser_card_no(String user_card_no) {
		this.user_card_no = user_card_no;
	}
	public int getUser_card_sec() {
		return user_card_sec;
	}
	public void setUser_card_sec(int user_card_sec) {
		this.user_card_sec = user_card_sec;
	}
	public String getUser_card_expdate() {
		return user_card_expdate;
	}
	public void setUser_card_expdate(String user_card_expdate) {
		this.user_card_expdate = user_card_expdate;
	}
	public int getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(int auth_code) {
		this.auth_code = auth_code;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
