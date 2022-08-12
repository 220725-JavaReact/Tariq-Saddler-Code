package com.revature.P0StoreApp.storage;

import java.util.ArrayList;

import com.revature.P0StoreApp.models.*;

public class CustomerList {
	private ArrayList<customer> backingArray = new ArrayList<customer>();
	private int lastIndex;
	
	// set the intial values of our arrayList
	public CustomerList() {
		backingArray = new ArrayList<customer>();
		lastIndex = 0;
	}
	
	public void add(customer newCustomer)
	{
		// what if the arraylist has reached max cap?
//		if (lastIndex == backingArray.size()) {
//			int newSize = (int) (lastIndex * 1.5);
//			ArrayList<customer> newBacking = new ArrayList<>();
//			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.size());
//			backingArray=newBacking;
//		}
		backingArray.add(newCustomer);
		lastIndex++;
	}
	public ArrayList<customer> getAllElements() {
		return backingArray;
	}



}
