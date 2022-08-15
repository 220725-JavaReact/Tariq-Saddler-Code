package com.revature.P0StoreApp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.P0StoreApp.models.oh_product_list;
import com.revature.P0StoreApp.util.ConnectionFactory;

public class OHProductListDAO implements DAO<oh_product_list>{

	@Override
	public void addInstance(oh_product_list newInstance) {
		// TODO Auto-generated method stub
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "Insert into order_history (OrderID, fk_StoreID, fk_CustomerID, how_many) values (?, ?, ?, ?)";
			PreparedStatement pstmt = connie.prepareStatement(query);
			pstmt.setInt(1, newInstance.getOrderID());
			pstmt.setInt(2, newInstance.getStoreID()); 
			pstmt.setInt(3, newInstance.getCustomerID());
			pstmt.setInt(4, newInstance.getHowMany());
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<oh_product_list> getAllInstances() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void decrementInventory(int howMany, int productID) {
		// TODO Auto-generated method stub
		
	}

}
