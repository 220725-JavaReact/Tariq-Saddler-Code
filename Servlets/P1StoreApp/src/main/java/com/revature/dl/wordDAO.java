package com.revature.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.word;
import com.revature.util.ConnectionFactory;

public class wordDAO implements DAO<word>{

	@Override
	public void addInstance(word newInstance) {
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "Insert into wordsList (wordID, wordLength, wordName) values (DEFAULT, ?, ?)";
			PreparedStatement pstmt = connie.prepareStatement(query);
			pstmt.setInt(1, newInstance.getLength()); 
			pstmt.setString(2, newInstance.getWordName());
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
