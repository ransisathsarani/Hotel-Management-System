package com.itp.Inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class InventoryDbUtil {

	private static DataSource dataSource;

	public InventoryDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public static List<Inventory> getInventory() throws Exception{
		
		List<Inventory> con = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from stock order by date  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String date = myRs.getString("date");
				 String description = myRs.getString("description");
				 String vendor = myRs.getString("vendor");
				 String invoiceNum = myRs.getString("invoiceNum");
				 float recieved = myRs.getFloat("recieved");
				 float weekCon = myRs.getFloat("weekCon");
				 float current = myRs.getFloat("current");
				
				
				// create new stocks object
				 Inventory tempIn = new Inventory(id, date,description,vendor,invoiceNum,recieved,weekCon,current);
				
				// add it to the list of stockss
				 con.add(tempIn);
			}

			
			return con;
			
		}
		finally {
			
			//close JDBC objects
			close(myConn, myStmt, myRs);

		}
		
	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
		try {
			if(myRs != null) {
				myRs.close();
			}
			
			if(myStmt != null) {
				myStmt.close();
			}
			
			if(myConn != null) {
				myConn.close();
			}
		}
		
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void addInventory(Inventory theInventory) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into stock"
						+"(date,description,vendor,invoiceNum,recieved,weekCon,current)"
						+"values (?, ?, ?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the stocks
			myStmt.setString(1, theInventory.getDate());
			myStmt.setString(2, theInventory.getDescription());
			myStmt.setString(3, theInventory.getVendor());
			myStmt.setString(4, theInventory.getInvoiceNum());
			myStmt.setFloat(5, theInventory.getRecieved());
			myStmt.setFloat(6, theInventory.getWeekCon());
			myStmt.setFloat(7, theInventory.getCurrent());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public static Inventory getInventory(String theInventoryId) throws Exception{

		Inventory theInventory = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int inventoryId;
			
			try {
				//convert stocks id to int
				inventoryId = Integer.parseInt(theInventoryId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected stocks
				String sql = "select * from stock where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, inventoryId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String date = myRs.getString("date");
					 String description = myRs.getString("description");
					 String vendor = myRs.getString("vendor");
					 String invoiceNum = myRs.getString("invoiceNum");
					 float recieved = myRs.getFloat("recieved");
					 float weekCon = myRs.getFloat("weekCon");
					 float current = myRs.getFloat("current");
					 
					//use the stocks id during construction
					theInventory  = new Inventory(id,date,description,vendor,invoiceNum,recieved,weekCon,current);
				}
				else {
					throw new Exception("Could not find inventory id: " + inventoryId);
				}
				
				return theInventory;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public static void updateInventory(Inventory theInventory) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update stock "
					+ "set date=?, description=?,vendor=?,invoiceNum=?,recieved=?,weekCon=?,current=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theInventory.getDate());
		myStmt.setString(2, theInventory.getDescription());
		myStmt.setString(3, theInventory.getVendor());
		myStmt.setString(4, theInventory.getInvoiceNum());
		myStmt.setFloat(5, theInventory.getRecieved());
		myStmt.setFloat(6, theInventory.getWeekCon());
		myStmt.setFloat(7, theInventory.getCurrent());
		myStmt.setInt(8, theInventory.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public static void deleteInventory(String theInventoryId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert stocks id to int
			int inventoryId = Integer.parseInt(theInventoryId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete stocks
			String sql = "delete from stock where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, inventoryId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		

}
