package com.revature.P0StoreApp.storage;

import java.util.ArrayList;

import com.revature.P0StoreApp.models.products;

public class ProductList {
	private ArrayList<products> backingArray = new ArrayList<products>();
	
	public ProductList()
	{
		backingArray = new ArrayList<products>();
	}
	
	public void add(products newProduct)
	{
		backingArray.add(newProduct);
	}
	
	public ArrayList<products> getAllElements()
	{
		return backingArray;
	}
}
