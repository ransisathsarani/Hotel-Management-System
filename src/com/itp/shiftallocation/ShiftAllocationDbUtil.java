package com.itp.shiftallocation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ShiftAllocationDbUtil {

	
	private DataSource dataSource;

	public ShiftAllocationDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public List<ShiftAllocation> getShiftAllocation() throws Exception{
		
		List<ShiftAllocation> shift = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from shift order by empid  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String empid = myRs.getString("empid");
				
				 String s_time = myRs.getString("s_time");
				 String dept = myRs.getString("dept");
				 
				
				// create new shifts object
				 ShiftAllocation tempShift = new ShiftAllocation(id, empid,s_time,dept);
				
				// add it to the list of shiftss
				 shift.add(tempShift);
			}

			
			return shift;
			
		}
		finally {
			
			//close JDBC objects
			close(myConn, myStmt, myRs);

		}
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
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

	public void addShiftAllocation(ShiftAllocation theShift) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into shift"
						+"(empid,s_time,dept)"
						+"values (?, ?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the shifts
			myStmt.setString(1, theShift.getempid());
			
			myStmt.setString(2, theShift.gets_time());
			myStmt.setString(3, theShift.getdept());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public ShiftAllocation getShiftAllocation(String theShiftId) throws Exception{

			ShiftAllocation theShift = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int shiftId;
			
			try {
				//convert shifts id to int
				shiftId = Integer.parseInt(theShiftId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected shifts
				String sql = "select * from shift where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, shiftId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String empid = myRs.getString("empid");
					 String s_time = myRs.getString("s_time");
					 String dept = myRs.getString("dept");
					 
					
					//use the shifts id during construction
					theShift = new ShiftAllocation(id,empid,s_time,dept);
				}
				else {
					throw new Exception("Could not find shift id: " + shiftId);
				}
				
				return theShift;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public void updateShiftAllocation(ShiftAllocation theShift) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update shift "
					+ "set empid=?, s_time=?, dept=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theShift.getempid());
		
		myStmt.setString(2, theShift.gets_time());
		myStmt.setString(3, theShift.getdept());
		myStmt.setInt(4, theShift.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteShiftAllocation(String theShiftId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert shifts id to int
			int shiftId = Integer.parseInt(theShiftId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete shifts
			String sql = "delete from shift where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, shiftId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		
}



