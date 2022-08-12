package com.revature.P0StoreApp.models;

public class products {
	private String name;
	private double price;
	private int inventory;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	@Override
	public String toString() {
		return name + ":  Price = $" + price + ", Inventory = " + inventory + "]";
	}
	
	
	
}
