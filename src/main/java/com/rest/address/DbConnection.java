package com.rest.address;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbConnection {
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	
	static {
	    try {
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
		    cpds.setJdbcUrl("jdbc:mysql://db-mysql-sfo3-74977-do-user-9250158-0.b.db.ondigitalocean.com:25060/AddressBook");
		    cpds.setUser("doadmin");
		    cpds.setPassword("e4buhxkx5kvl5lnm");
		} catch (PropertyVetoException e) {
			System.out.println("Failed to connect to database.");
			e.printStackTrace();
		}	
	}
	
	public static Connection getConnection() throws SQLException{
		return cpds.getConnection();
	}
}
