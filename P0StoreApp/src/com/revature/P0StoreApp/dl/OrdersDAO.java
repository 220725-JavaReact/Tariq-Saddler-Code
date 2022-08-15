package com.revature.P0StoreApp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.P0StoreApp.models.order_history;
import com.revature.P0StoreApp.util.ConnectionFactory;

public class OrdersDAO implements DAO<order_history>{

	@Override
	public void addInstance(order_history newInstance) {
		// TODO Auto-generated method stub
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "Insert into order_history (fk_StoreID, fk_CustomerID, datetime, total_cost) values (?, ?, ?, ?)";
			PreparedStatement pstmt = connie.prepareStatement(query);
			pstmt.setInt(1, newInstance.getStoreID()); 
			pstmt.setInt(2, newInstance.getCustomerID());
			pstmt.setString(3, newInstance.getDateTime());
			pstmt.setDouble(4, newInstance.getTotalCost());
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<order_history> getAllInstances() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void decrementInventory(int howMany, int productID) {
		// TODO Auto-generated method stub
		
	}

}
