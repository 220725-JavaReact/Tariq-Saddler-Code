package com.revature.P0StoreApp.dl;

import java.util.ArrayList;

public interface DAO<T> {
	void addInstance(T newInstance);
	ArrayList<T> getAllInstances();
	void decrementInventory (int howMany, int productID);
}
