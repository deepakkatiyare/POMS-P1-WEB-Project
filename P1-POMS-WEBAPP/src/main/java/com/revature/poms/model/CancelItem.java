package com.revature.poms.model;

public class CancelItem {
	private int cancelId;
	private String itemName;
	private int price;
	public CancelItem() {
		
	}
	public CancelItem(int cancelId, String itemName, int price) {
		super();
		this.cancelId = cancelId;
		this.itemName = itemName;
		this.price = price;
		
	}
	public int getCancelId() {
		return cancelId;
	}
	public void setCancelId(int cancelId) {
		this.cancelId = cancelId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	@Override
	public String toString() {
		return "CancelItem [cancelId=" + cancelId + ", itemName=" + itemName + ", price=" + price + "]";
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
