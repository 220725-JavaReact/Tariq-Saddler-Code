package com.revature.P0StoreApp.dl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.P0StoreApp.models.store;
import com.revature.P0StoreApp.storage.StoreList;
import com.revature.P0StoreApp.util.ConnectionFactory;

public class StoreDAO implements DAO<store> {
	@Override
	public ArrayList<store> getAllInstances()
	{
		StoreList sList = new StoreList();
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from stores";
			Statement stmt = connie.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				sList.add(new store(rs.getInt("storeid"), rs.getString("s_name"), rs.getString("s_address")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sList.getAllElements();
	}

	@Override
	public void addInstance(store newInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementInventory(int howMany, int productID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int findID(store newInstance) {
		// TODO Auto-generated method stub
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "select storeid from stores where s_name = " + newInstance.getStoreName()+ " and s_address = " + newInstance.getStoreAddress();//(fk_StoreID, fk_CustomerID, datetime, total_cost) values (?, ?, ?, ?)";
			//PreparedStatement pstmt = connie.prepareStatement(query);
//			pstmt.setInt(1, newInstance.getStoreID()); 
//			pstmt.setInt(2, newInstance.getCustomerID());
//			pstmt.setString(3, newInstance.getDateTime()); 
//			pstmt.setDouble(4, newInstance.getTotalCost());
			Statement stmt = connie.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				return rs.getInt("storeid");
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

	@Override
	public void incrementInventory(int howMany, int productID) {
		// TODO Auto-generated method stub
		
	}
}
