package com.revature.P0StoreApp.models;

import java.util.ArrayList;

public class cart {
	
	private String productInCart;
	private double priceOfProduct;
	private int amountInCart;
	
	public String getProductInCart() {
		return productInCart;
	}
	public void setProductInCart(String productInCart) {
		this.productInCart = productInCart;
	}
	public double getPriceOfProduct() {
		return priceOfProduct;
	}
	public void setPriceOfProduct(double priceOfProduct) {
		this.priceOfProduct = priceOfProduct;
	}
	public int getAmountInCart() {
		return amountInCart;
	}
	public void setAmountInCart(int amountInCart) {
		this.amountInCart = amountInCart;
	}
	
}
