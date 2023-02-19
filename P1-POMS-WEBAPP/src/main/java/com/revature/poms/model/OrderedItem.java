package com.revature.poms.model;

public class OrderedItem {
	private  int id;
	private String itemName;
	private int price;
	public OrderedItem() {
		super();
	}
	public OrderedItem(int id,String itemName,int price) {
		this.id = id;
		this.price = price;
		this.itemName = itemName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	@Override
	public String toString() {
		return "OrderedItem [id=" + id + ", itemName=" + itemName + ", price=" + price + "]";
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}