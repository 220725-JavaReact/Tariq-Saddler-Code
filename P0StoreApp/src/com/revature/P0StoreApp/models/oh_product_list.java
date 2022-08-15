package com.revature.P0StoreApp.models;

public class oh_product_list {
	private int orderID;
	private int storeID;
	private int customerID;
	private int howMany;
	
	
	public oh_product_list(int orderID, int storeID, int customerID, int howMany)
	{
		this.orderID = orderID;
		this.storeID = storeID;
		this.customerID = customerID;
		this.howMany = howMany;
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getHowMany() {
		return howMany;
	}
	public void setHowMany(int howMany) {
		this.howMany = howMany;
	}
	
	
}
