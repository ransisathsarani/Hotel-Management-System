package com.itp.restaurant;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;



public class CateringDbUtil {

	
	private static DataSource dataSource;

	public CateringDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public static List<Catering> getCaterings() throws Exception{
		
		List<Catering> Catering = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from catering order by date  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String name = myRs.getString("name");
				 String contactNumber = myRs.getString("contactNumber");
				 String date = myRs.getString("date");
				 String numberOfPeople = myRs.getString("numberofPeople");
				 String email = myRs.getString("email");
				 String menuID = myRs.getString("menuID");
			
				// create new catering object
				 Catering tempCatering = new Catering(id, name,contactNumber,date,numberOfPeople,email,menuID);
				
				// add it to the list of caterings
				 Catering.add(tempCatering);    //changed
			}

			
			return Catering;    //changfged
			
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

	public void addCatering(Catering theCatering) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert

			if(myConn == null)
				System.out.println("Null");
			String sql = "insert into catering"
						+"(name, contactNumber, date, numberOfPeople, email, menuID)"
						+"values (?, ?, ?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the catering
			myStmt.setString(1, theCatering.getName());
			myStmt.setString(2, theCatering.getContactNumber());
			myStmt.setString(3, theCatering.getDate());
			myStmt.setString(4, theCatering.getNumberOfPeople());
			myStmt.setString(5, theCatering.getEmail());
			myStmt.setString(6, theCatering.getMenuID());
			
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public Catering getCaterings(String theCateringId) throws Exception{

			Catering theCatering = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int cateringId;
			
			try {
				//convert catering id to int
				cateringId = Integer.parseInt(theCateringId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected catering
				String sql = "select * from catering where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, cateringId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					 String name = myRs.getString("name");
					 String contactNumber = myRs.getString("contactNumber");
					 String date = myRs.getString("date");
					 String numberOfPeople = myRs.getString("numberofPeople");
					 String email = myRs.getString("email");
					 String menuID = myRs.getString("menuID");
					
					theCatering = new Catering(id,name,contactNumber,date,numberOfPeople,email,menuID);
				}
				else {
					throw new Exception("Could not find Catering id: " + cateringId);
				}
				
				return theCatering;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public void updateCaterings(Catering theCatering) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update catering "
					+ "set name=?, contactNumber=?, date=?, numberofPeople=?, email=?, menuID=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theCatering.getName());
		myStmt.setString(2, theCatering.getContactNumber());
		myStmt.setString(3, theCatering.getDate());
		myStmt.setString(4, theCatering.getNumberOfPeople());
		myStmt.setString(5, theCatering.getEmail());
		myStmt.setString(6, theCatering.getMenuID());
		myStmt.setInt(7, theCatering.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteCaterings(String theCateringId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert catering id to int
			int cateringId = Integer.parseInt(theCateringId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete catering
			String sql = "delete from catering where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, cateringId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		
}

