package com.itp.clientAccPayment;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class RestaurantPaymentDbUtil {

	private static DataSource dataSource;

	public RestaurantPaymentDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	

	public static List<RestaurantPayments> getRestPay() throws Exception{
		
		List<RestaurantPayments> con = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from restpay";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String date = myRs.getString("date");
				 String reserveId = myRs.getString("reserveId");
				 String mID= myRs.getString("mID");
				 float total = myRs.getFloat("total");
				
				// create new teacher object
				 RestaurantPayments tempRestPay = new RestaurantPayments(id,date,reserveId,mID,total);
				
				// add it to the list of teachers
				 con.add(tempRestPay);
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

	public static void addRestPay(RestaurantPayments theRestPay) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into restpay"
						+"(date,reserveId,mID,total)"
						+"values (?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the teacher
			myStmt.setString(1, theRestPay.getDate());
			myStmt.setString(2, theRestPay.getReserveId());
			myStmt.setString(3, theRestPay.getMID());
			myStmt.setFloat(4, theRestPay.getTotal());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public static RestaurantPayments getRestPay(String theRestPayId) throws Exception{

		RestaurantPayments theRestPay = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int restPayId;
			
			try {
				//convert teacher id to int
				restPayId = Integer.parseInt(theRestPayId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected teacher
				String sql = "select * from restpay where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, restPayId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					 String date = myRs.getString("date");
					 String reserveId = myRs.getString("reserveId");
					 String mID= myRs.getString("mID");
					 float total = myRs.getFloat("total");
					 
					 
					//use the teacher id during construction
					theRestPay  = new RestaurantPayments(id,date,reserveId,mID,total);
				}
				else {
					throw new Exception("Could not find payment id: " + restPayId);
				}
				
				return theRestPay;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public static void updateRestPay(RestaurantPayments theRestPay) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update restpay "
					+ "set date=?,reserveId=?,total=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theRestPay.getDate());
		myStmt.setString(2, theRestPay.getReserveId());
		myStmt.setString(3, theRestPay.getMID());
		myStmt.setFloat(4, theRestPay.getTotal());
		myStmt.setInt(5, theRestPay.getId());
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public static void deleteRestPay(String theRestPayId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert teacher id to int
			int restPayId = Integer.parseInt(theRestPayId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete teacher
			String sql = "delete from restpay where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, restPayId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		
}
