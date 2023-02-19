package com.revature.poms.model;

import java.util.ArrayList;

public class Order {
	private String customerName;
	private String customerContact;
	private String deliveryAddress;
	private String deliveryStatus;
	private int price;
	private String email;
	private ArrayList<OrderedItem> itemList;
	private int orderId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int order_id) {
		this.orderId = order_id;
	}

	public Order() {
		super();
	}

	public Order(String customerName,String email, String customerContact, String deliveryAddress,ArrayList<OrderedItem> itemList,
			String deliveryStatus, int price) {
		this.customerName = customerName;
		this.customerContact = customerContact;
		this.deliveryAddress = deliveryAddress;
		this.email = email;
		this.deliveryStatus = deliveryStatus;
		this.itemList = itemList;
		this.price = price;
	}
	

	public String getEmail() {
		return email;
	}

	public Order(String customerName, String customerContact, String deliveryAddress, String deliveryStatus, int price,
			String email) {
		super();
		this.customerName = customerName;
		this.customerContact = customerContact;
		this.deliveryAddress = deliveryAddress;
		this.deliveryStatus = deliveryStatus;
		this.price = price;
		this.email = email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public ArrayList<OrderedItem> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<OrderedItem> itemList) {
		this.itemList = itemList;
	}

	@Override
	public boolean equals(Object obj) {
		Order order = null;
		if (obj instanceof Order)
			order = (Order) obj;
		if (this == order)
			return true;
		else {
			if (this.getCustomerName().equals(order.getCustomerName())
					&& this.getCustomerContact().equals(order.getCustomerContact())
					&& this.getDeliveryAddress().equals(order)) {
				return true;
			}
			return false;
		}
	}

	@Override
	public String toString() {
		return "Order [customerName=" + customerName + ", customerContact=" + customerContact + ", deliveryAddress="
				+ deliveryAddress + ", deliveryStatus=" + deliveryStatus + "]";
	}

}
