package com.resort.salaryhandling;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import java.sql.*;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;

public class BasicNeedsDbUtil {

	private static DataSource dataSource;

	public BasicNeedsDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public static List<BasicNeeds> getBasicNeeds() throws Exception{
		
		List<BasicNeeds> con = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from basicneeds order by inquiry";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 int inquiry = myRs.getInt("inquiry");
				 String empid = myRs.getString("empid");
				 String iDate = myRs.getString("iDate");
				 String complaint = myRs.getString("complaint");
				 String department = myRs.getString("department");
				 
				
				
				// create new basic needs object
				 BasicNeeds tempBasic = new BasicNeeds(id, inquiry,empid,iDate,complaint,department);
				
				// add it to the list of basic needss
				 con.add(tempBasic);
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

	public static void addBasicNeeds(BasicNeeds theBasicNeeds) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into basicneeds"
						+"(inquiry,empid,iDate,complaint,department)"
						+"values (?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the basic needs
			myStmt.setInt(1, theBasicNeeds.getInquiry());
			myStmt.setString(2, theBasicNeeds.getEmpid());
			myStmt.setString(3, theBasicNeeds.getiDate());
			myStmt.setString(4, theBasicNeeds.getComplaint());
			myStmt.setString(5, theBasicNeeds.getDepartment());
			
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public static BasicNeeds getBasicNeeds(String theBasicNeedsId) throws Exception{

		BasicNeeds theBasicNeeds = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int basicNeedsId;
			
			try {
				//convert basic needs id to int
				basicNeedsId = Integer.parseInt(theBasicNeedsId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected basic needs
				String sql = "select * from basicneeds where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1,basicNeedsId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					int inquiry = myRs.getInt("inquiry");
					 String empid = myRs.getString("empid");
					 String iDate = myRs.getString("iDate");
					 String complaint = myRs.getString("complaint");
					 String department = myRs.getString("department");
					 
					//use the basic needs id during construction
					theBasicNeeds  = new BasicNeeds(id,inquiry,empid,iDate,complaint,department);
				}
				else {
					throw new Exception("Could not find inventory id: " + basicNeedsId);
				}
				
				return theBasicNeeds;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public static void updateBasicNeeds(BasicNeeds theBasicNeeds) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update basicneeds "
					+ "set inquiry=?, empid=?,iDate=?,complaint=?,department=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setInt(1, theBasicNeeds.getInquiry());
		myStmt.setString(2, theBasicNeeds.getEmpid());
		myStmt.setString(3, theBasicNeeds.getiDate());
		myStmt.setString(4, theBasicNeeds.getComplaint());
		myStmt.setString(5, theBasicNeeds.getDepartment());
		myStmt.setInt(6, theBasicNeeds.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public static void deleteBasicNeeds(String theBasicNeedsId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert basic needs id to int
			int basicNeedsId = Integer.parseInt(theBasicNeedsId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete basic needs
			String sql = "delete from basicneeds where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, basicNeedsId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		
		
	}

	


