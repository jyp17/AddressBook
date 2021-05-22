package com.rest.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ListQuery {
	private Connection connect = null; 
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	
	public ArrayList<Contact> listFromDB() throws Exception {
		try {
			connect = DbConnection.getConnection();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from AddressBook.contacts");
			ArrayList<Contact> contactDB = new ArrayList<Contact>();
			
			while(resultSet.next()) {				
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String address = resultSet.getString("address");
				String phone = resultSet.getString("phone");
				int id = resultSet.getInt("id");
				
				contactDB.add(new Contact(firstName, lastName, address, phone, id));
			}
			
			return contactDB;
			
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
