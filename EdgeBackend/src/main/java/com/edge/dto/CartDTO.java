package com.edge.dto;

public class CartDTO {
	
	private ItemSelectionDTO[] selections;
	private int itemCount;
	private double totalPrice;
	
	public ItemSelectionDTO[] getSelections() {
		return selections;
	}
	public void setSelections(ItemSelectionDTO[] selections) {
		this.selections = selections;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	

}
