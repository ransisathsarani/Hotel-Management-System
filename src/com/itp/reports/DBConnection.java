package com.itp.reports;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public Connection getConnection() {
		Connection conn = null;
		System.out.println("Connection started");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kfr", "root", "root");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
}
