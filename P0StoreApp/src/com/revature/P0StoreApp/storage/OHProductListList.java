package com.revature.P0StoreApp.storage;

import java.util.ArrayList;

import com.revature.P0StoreApp.models.oh_product_list;

public class OHProductListList {
private ArrayList<oh_product_list> backingArray = new ArrayList<oh_product_list>();
	
	public OHProductListList()
	{
		backingArray = new ArrayList<oh_product_list>();
	}
	
	public void add(oh_product_list newProduct)
	{
		backingArray.add(newProduct);
	}
	
	public ArrayList<oh_product_list> getAllElements()
	{
		return backingArray;
	}

}
