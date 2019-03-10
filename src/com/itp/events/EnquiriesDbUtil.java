package com.itp.events;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EnquiriesDbUtil {

		private DataSource dataSource;

		public EnquiriesDbUtil(DataSource theDataSource) {
			this.dataSource = theDataSource;
		}
		
		public List<Enquiries> getEnquiriess() throws Exception{
			
			List<Enquiries> enquiriess = new ArrayList<>();
			
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;
			
			try {
				// get a connection
				myConn = dataSource.getConnection();
				
				// create sql statement
				String sql = "select * from enquiries order by date  ";
				
				myStmt = myConn.createStatement();
				
				//execute query
				myRs = myStmt.executeQuery(sql);
				
				//process result set
				while(myRs.next()) {
					
					//retrieve data from result set row
					 int id = myRs.getInt("id");
					 String date = myRs.getString("date");
					 String no_of_persons = myRs.getString("no_of_persons");
					 String name = myRs.getString("name");
					 String email = myRs.getString("email");
					 String contact_no = myRs.getString("contact_no");
					 String description = myRs.getString("description");
					
					// create new enquiries object
					 Enquiries tempEnquiries = new Enquiries(id, date, no_of_persons, name, email, contact_no, description);
					
					// add it to the list of enquiriess
					 enquiriess.add(tempEnquiries);
				}
	
				
				return enquiriess;
				
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

		public void addEnquiries(Enquiries theEnquiries) throws Exception {
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			try {
				//get db connection
				myConn = dataSource.getConnection();
				
				// create sql for insert
				String sql = "insert into enquiries"
							+"(date, no_of_persons, name, email, contact_no, description)"
							+"values (?, ?, ?, ?, ?, ?)";
				
				myStmt = myConn.prepareStatement(sql);
			
				// set the param values for the enquiries
				myStmt.setString(1, theEnquiries.getDate());
				myStmt.setString(2, theEnquiries.getNo_of_persons());
				myStmt.setString(3, theEnquiries.getName());
				myStmt.setString(4, theEnquiries.getEmail());
				myStmt.setString(5, theEnquiries.getContact_no());
				myStmt.setString(6, theEnquiries.getDescription());
				
			
				//execute sql insert
				myStmt.execute();
			}
			finally {
				//clean up JDBC objects
				
			close(myConn, myStmt, null);
			}
			
			
		}

		

		public void deleteEnquiries(String theEnquiriesId) throws Exception{
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			try {
				// convert enquiries id to int
				int enquiriesId = Integer.parseInt(theEnquiriesId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to delete enquiries
				String sql = "delete from enquiries where id=?";
				
				// prepare statement
				myStmt = myConn.prepareStatement(sql);
				
				// set params
				myStmt.setInt(1, enquiriesId);
				
				// execute sql statement
				myStmt.execute();
			}
			finally {
				
				// clean up JDBC code
				close(myConn, myStmt, null);
			}			
		}		
}

