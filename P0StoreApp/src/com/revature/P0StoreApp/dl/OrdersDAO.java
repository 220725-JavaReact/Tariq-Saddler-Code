package com.revature.P0StoreApp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.P0StoreApp.models.order_history;
import com.revature.P0StoreApp.util.ConnectionFactory;

public class OrdersDAO implements DAO<order_history>{

	@Override
	public void addInstance(order_history newInstance) {
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

	@Override
	public int findID(order_history newInstance) {
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "select orderid from order_history where fk_StoreID = " + newInstance.getStoreID()+ " and fk_CustomerID = " + newInstance.getCustomerID()+ " and datetime = '" + newInstance.getDateTime() + "' and total_cost = " + newInstance.getTotalCost();//(fk_StoreID, fk_CustomerID, datetime, total_cost) values (?, ?, ?, ?)";
			//PreparedStatement pstmt = connie.prepareStatement(query);
//			pstmt.setInt(1, newInstance.getStoreID()); 
//			pstmt.setInt(2, newInstance.getCustomerID());
//			pstmt.setString(3, newInstance.getDateTime()); 
//			pstmt.setDouble(4, newInstance.getTotalCost());
			Statement stmt = connie.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.isFirst()) {
				return rs.getInt("orderid");
			}
			
			//pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	@Override
	public void incrementNumber(int orderID, int productID) {
		// TODO Auto-generated method stub
		
	}

}
