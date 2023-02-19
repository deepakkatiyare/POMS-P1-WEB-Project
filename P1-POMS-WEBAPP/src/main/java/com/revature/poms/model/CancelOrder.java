package com.revature.poms.model;

public class CancelOrder {
	private int canceId;
	private String cancelReason;
	private String date;
	private String name;
	private String contacts;
	private int price;
	public CancelOrder() {
		
	}
	public CancelOrder(int canceId, String cancelReason, String date, String name, String contacts, int price) {
		super();
		this.canceId = canceId;
		this.cancelReason = cancelReason;
		this.date = date;
		this.name = name;
		this.contacts = contacts;
		this.price = price;
	}
	public int getCanceId() {
		return canceId;
	}
	@Override
	public String toString() {
		return "CancelOrder [canceId=" + canceId + ", cancelReason=" + cancelReason + ", date=" + date + ", name="
				+ name + ", contacts=" + contacts + ", price=" + price + "]";
	}
	public void setCanceId(int canceId) {
		this.canceId = canceId;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}	
