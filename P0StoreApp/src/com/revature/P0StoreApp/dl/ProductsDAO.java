package com.revature.P0StoreApp.dl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.P0StoreApp.models.products;
import com.revature.P0StoreApp.storage.ProductList;
import com.revature.P0StoreApp.util.ConnectionFactory;

public class ProductsDAO implements DAO<products>{

	@Override
	public void addInstance(products newInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<products> getAllInstances() {
		// TODO Auto-generated method stub
		ProductList pList = new ProductList();
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from products";
			Statement stmt = connie.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				pList.add(new products(rs.getString("p_name"), rs.getString("details"), rs.getDouble("price"), rs.getInt("inventory"), rs.getInt("fk_StoreID")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pList.getAllElements();
	}

}