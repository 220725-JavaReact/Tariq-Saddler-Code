package models;

public class EnergyDrink {

	// Fields and Variables
	public String name;
	public double price;

	// Constructor
	public EnergyDrink(String name, double price) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	// To String method to display the Drink parameters
	@Override
	public String toString() {
		return "EnergyDrink [name=" + name + ", price=" + price + "]";
	}







}
