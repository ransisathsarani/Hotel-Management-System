package com.itp.userReg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class UserRegDbUtil {

	private static DataSource dataSource;

	public UserRegDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public List<UserRegistration> getUserReg() throws Exception{
		
		List<UserRegistration> con = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from userregistration order by id  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String fname = myRs.getString("fname");
				 String lname = myRs.getString("lname");
				 String address = myRs.getString("address");
				 String phone = myRs.getString("phone");
				 String email = myRs.getString("email");
				 String sex = myRs.getString("sex");
				
				// create new teacher object
				 UserRegistration tempUser = new UserRegistration(id, fname,lname,address,phone,email,sex);
				
				// add it to the list of teachers
				 con.add(tempUser);
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

	public void addUserReg(UserRegistration theUserReg) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into userregistration"
						+"(fname,lname,address,phone,email,sex)"
						+"values (?, ?, ?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the teacher
			myStmt.setString(1, theUserReg.getFname());
			myStmt.setString(2, theUserReg.getLname());
			myStmt.setString(3, theUserReg.getAddress());
			myStmt.setString(4, theUserReg.getPhone());
			myStmt.setString(5, theUserReg.getEmail());
			myStmt.setString(6, theUserReg.getSex());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public UserRegistration getUserReg(String theUserRegId) throws Exception{

			UserRegistration theUserReg = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int userRegId;
			
			try {
				//convert teacher id to int
				userRegId = Integer.parseInt(theUserRegId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected teacher
				String sql = "select * from userregistration where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, userRegId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String fname = myRs.getString("fname");
					 String lname = myRs.getString("lname");
					 String address = myRs.getString("address");
					 String phone = myRs.getString("phone");
					 String email = myRs.getString("email");
					 String sex = myRs.getString("sex");
					
					//use the teacher id during construction
					theUserReg  = new UserRegistration(id,fname,lname,address,phone,email,sex);
				}
				else {
					throw new Exception("Could not find user registration id: " + userRegId);
				}
				
				return theUserReg;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public static void updateUserReg(UserRegistration theUserReg) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update userregistartion "
					+ "set fname=?, lname=?, address?, phone=?, email=?, sex=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theUserReg.getFname());
		myStmt.setString(2, theUserReg.getLname());
		myStmt.setString(3, theUserReg.getAddress());
		myStmt.setString(4, theUserReg.getPhone());
		myStmt.setString(5, theUserReg.getEmail());
		myStmt.setString(6, theUserReg.getSex());
		myStmt.setInt(7, theUserReg.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteUserReg(String theUserRegId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert teacher id to int
			int userRegId = Integer.parseInt(theUserRegId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete teacher
			String sql = "delete from userregitration where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, userRegId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		
}
