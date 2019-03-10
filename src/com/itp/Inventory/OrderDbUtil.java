package com.itp.Inventory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class OrderDbUtil {

	private static DataSource dataSource;

	public OrderDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public List<Order> getOrder() throws Exception{
		
		List<Order> order = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from orderTable order by date  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String date = myRs.getString("date");
				 String staffid = myRs.getString("staffid");
				 String department = myRs.getString("department");
				 String description = myRs.getString("description");
				 float quantity = myRs.getFloat("quantity");
				 float unit = myRs.getFloat("unit");
				 float total = myRs.getFloat("total");
				 String type = myRs.getString("type");
				
				// create new order object
				 Order temporder = new Order(id, date,staffid,department,description,quantity,unit,total,type);
				
				// add it to the list of orders
				 order.add(temporder);
			}

			
			return order;
			
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

	public void addOrder(Order theOrder) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into orderTable"
						+"(date,staffid,department,description,quantity,unit,total,type)"
						+"values (?, ?, ?,?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the order
			myStmt.setString(1, theOrder.getDate());
			myStmt.setString(2, theOrder.getStaffid());
			myStmt.setString(3, theOrder.getDepartment());
			myStmt.setString(4, theOrder.getDescription());
			myStmt.setFloat(5, theOrder.getQuantity());
			myStmt.setFloat(6, theOrder.getUnit());
			myStmt.setFloat(7, theOrder.getTotal());
			myStmt.setString(8, theOrder.getType());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public Order getOrder(String theOrderId) throws Exception{

			Order theOrder = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int orderId;
			
			try {
				//convert order id to int
				orderId = Integer.parseInt(theOrderId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected order
				String sql = "select * from orderTable where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, orderId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					 String date = myRs.getString("date");
					 String staffid = myRs.getString("staffid");
					 String department = myRs.getString("department");
					 String description = myRs.getString("description");
					 float quantity = myRs.getFloat("quantity");
					 float unit = myRs.getFloat("unit");
					 float total = myRs.getFloat("total");
					 String type = myRs.getString("type");
					
					//use the order id during construction
					theOrder  = new Order(id,date,staffid,department,description,quantity,unit,total,type);
				}
				else {
					throw new Exception("Could not find order id: " + orderId);
				}
				
				return theOrder;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public static void updateOrder(Order theOrder) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update orderTable "
					+ "set date=?,staffid=?, department=?, description=?, quantity=?,  unit=?, total=?,type=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theOrder.getDate());
		myStmt.setString(2, theOrder.getStaffid());
		myStmt.setString(3, theOrder.getDepartment());
		myStmt.setString(4, theOrder.getDescription());
		myStmt.setFloat(5, theOrder.getQuantity());
		myStmt.setFloat(6, theOrder.getUnit());
		myStmt.setFloat(7, theOrder.getTotal());
		myStmt.setString(8, theOrder.getType());
		myStmt.setInt(9, theOrder.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteOrder(String theOrderId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert order id to int
			int orderId = Integer.parseInt(theOrderId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete order
			String sql = "delete from orderTable where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, orderId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		

}
