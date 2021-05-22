package com.rest.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EditQuery {
	private Connection connect = null; 
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	public void updateDB(Contact toUpdate) throws Exception {
		try {
			connect = DbConnection.getConnection();
			statement = connect.createStatement();
			
			preparedStatement = connect.prepareStatement("update contacts set first_name = ?, "
					+ "last_name = ?, address = ?, phone = ? where id = ?;");
			
			preparedStatement.setString(1, toUpdate.getFirstName());
			preparedStatement.setString(2, toUpdate.getLastName());
			preparedStatement.setString(3, toUpdate.getAddress());
			preparedStatement.setString(4, toUpdate.getPhone());
			preparedStatement.setInt(5, toUpdate.getId());
			
			preparedStatement.executeUpdate();
		} catch(Exception e) {
			close();
			throw e;
		}
	}
	
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			System.out.println("Unable to properly close JDBC interfaces.");
			System.out.println(e.getMessage());
		}
	}
}
