package com.revature.P0StoreApp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.P0StoreApp.models.oh_product_list;
import com.revature.P0StoreApp.models.products;
import com.revature.P0StoreApp.storage.OHProductListList;
import com.revature.P0StoreApp.storage.ProductList;
import com.revature.P0StoreApp.util.ConnectionFactory;

public class OHProductListDAO implements DAO<oh_product_list>{

	@Override
	public void addInstance(oh_product_list newInstance) {
		// TODO Auto-generated method stub
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "Insert into oh_product_list (OrderID, fk_ProductID, fk_CustomerID, how_many) values (?, ?, ?, ?)";
			PreparedStatement pstmt = connie.prepareStatement(query);
			pstmt.setInt(1, newInstance.getOrderID());
			pstmt.setInt(2, newInstance.getProductID()); 
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
		OHProductListList ohpList = new OHProductListList();
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from oh_product_list";
			Statement stmt = connie.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				ohpList.add(new oh_product_list(rs.getInt("OrderID"), rs.getInt("fk_ProductID"), rs.getInt("fk_CustomerID"), rs.getInt("how_many")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ohpList.getAllElements();
	}

	@Override
	public void decrementInventory(int howMany, int productID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int findID(oh_product_list newInstance) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public void incrementNumber(int orderID, int productID) {
		// TODO Auto-generated method stub
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			//String query = "Insert into CustomerInfo (c_fname, c_lname, un, pw, email) values (?, ?, ?, ?, ?)";
			String query = "update oh_product_list set how_many = how_many + 1 where orderID = ? and fk_productID = ?";
			PreparedStatement pstmt = connie.prepareStatement(query);
			pstmt.setInt(1, orderID); 
			pstmt.setInt(2, productID);
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
