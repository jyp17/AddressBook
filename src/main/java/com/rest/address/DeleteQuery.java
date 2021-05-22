package com.rest.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteQuery {
	private Connection connect = null; 
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	public void deleteDB(Contact toDelete) throws Exception {
		try {
			connect = DbConnection.getConnection();
			statement = connect.createStatement();
			
			preparedStatement = connect.prepareStatement("delete from AddressBook.contacts where id = ?;");
			
			preparedStatement.setInt(1, toDelete.getId());
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
