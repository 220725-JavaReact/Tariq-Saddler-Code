package com.revature.P0StoreApp.models;

import java.util.ArrayList;

public class store {
	private int storeID;
	private String storeName;
	private  String storeAddress;
	
	
	public store(String storeName, String storeAddress)
	{
		this.storeName = storeName;
		this.storeAddress = storeAddress;
	}
	
	
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	
}
