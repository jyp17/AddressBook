package com.rest.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddQuery {
	private Connection connect = null; 
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	public void addToDB(Contact toBeAdded) throws Exception {
		try {
			connect = DbConnection.getConnection();
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("insert into AddressBook.contacts (first_name, last_name, address, phone) values(?, ?, ?, ?)");
			
			preparedStatement.setString(1, toBeAdded.getFirstName());
			preparedStatement.setString(2, toBeAdded.getLastName());
			preparedStatement.setString(3, toBeAdded.getAddress());
			preparedStatement.setString(4, toBeAdded.getPhone());
			
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
