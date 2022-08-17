package com.revature.P0StoreApp.storage;

import java.util.ArrayList;

import com.revature.P0StoreApp.models.oh_product_list;
import com.revature.P0StoreApp.models.order_history;

public class OrderHistoryList {
private ArrayList<order_history> backingArray = new ArrayList<order_history>();
	
	public OrderHistoryList()
	{
		backingArray = new ArrayList<order_history>();
	}
	
	public void add(order_history newOrder)
	{
		backingArray.add(newOrder);
	}
	
	public ArrayList<order_history> getAllElements()
	{
		return backingArray;
	}

}
