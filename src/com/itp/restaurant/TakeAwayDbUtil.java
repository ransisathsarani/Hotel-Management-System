package com.itp.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
public class TakeAwayDbUtil {

	private static DataSource dataSource;

	public TakeAwayDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public List<TakeAway> getTakeAway() throws Exception{
		
		List<TakeAway> takeAway = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from takeaway order by date  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String date = myRs.getString("date");
				 String name = myRs.getString("name");
				 String numberOfPackets = myRs.getString("numberOfPackets");
				 String contactNumber = myRs.getString("contactNumber");
				 String email = myRs.getString("email");
				 String menuID = myRs.getString("menuID");
				
				// create new take away object
				 TakeAway tempTakeAway = new TakeAway(id, date,name,numberOfPackets,contactNumber,email,menuID);
				
				// add it to the list of take aways
				 takeAway.add(tempTakeAway);
			}

			
			return takeAway;
			
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

	public void addTakeAway(TakeAway theTakeAway) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into takeaway"
						+"(date, name, numberOfPackets, contactNumber, email, menuID)"
						+"values (?, ?, ?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the TakeAway
			myStmt.setString(1, theTakeAway.getDate());
			myStmt.setString(2, theTakeAway.getName());
			myStmt.setString(3, theTakeAway.getNumberOfPackets());
			myStmt.setString(4, theTakeAway.getContactNumber());
			myStmt.setString(5, theTakeAway.getEmail());
			myStmt.setString(6, theTakeAway.getMenuID());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public TakeAway getTakeAway(String theTakeAwayId) throws Exception{

		TakeAway theTakeAway = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int takeAwayId;
			
			try {
				//convert take away id to int
				takeAwayId = Integer.parseInt(theTakeAwayId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected take away
				String sql = "select * from takeaway where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1 , takeAwayId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					 String date = myRs.getString("date");
					 String name = myRs.getString("name");
					 String numberOfPackets = myRs.getString("numberOfPackets");
					 String contactNumber = myRs.getString("contactNumber");
					 String email = myRs.getString("email");
					 String menuID = myRs.getString("menuID");
					
					//use the take away id during construction
					theTakeAway = new TakeAway(id, date,name,numberOfPackets,contactNumber,email,menuID);
				}
				else {
					throw new Exception("Could not find TakeAway id: " + takeAwayId);
				}
				
				return theTakeAway;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public static void updateTakeAway(TakeAway theTakeAway) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update takeaway "
					+ "set date=?,name=?,numberOfPackets=?,contactNumber=?,email=?,menuID=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theTakeAway.getDate());
		myStmt.setString(2, theTakeAway.getName());
		myStmt.setString(3, theTakeAway.getNumberOfPackets());
		myStmt.setString(4, theTakeAway.getContactNumber());
		myStmt.setString(5, theTakeAway.getEmail());
		myStmt.setString(6, theTakeAway.getMenuID());
		myStmt.setInt(7, theTakeAway.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteTakeAway(String theTakeAwayId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert take away id to int
			int takeAwayId = Integer.parseInt(theTakeAwayId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete TakeAway
			String sql = "delete from takeaway where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, takeAwayId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		
}
