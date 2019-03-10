package com.kanneliya.newReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class ReservationDbUtil {

	private static DataSource dataSource;

	public ReservationDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public List<NewReservation> getReservation() throws Exception{
		
		List<NewReservation> con = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from reservation order by checkIn";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String reserveID = myRs.getString("reserveID");
				 String RID = myRs.getString("RID");
				 String category = myRs.getString("category");
				 String name = myRs.getString("name");
				 String phone = myRs.getString("phone");
				 String email = myRs.getString("email");
				 String checkIn = myRs.getString("checkIn");
				 String checkOut = myRs.getString("checkOut");
				 String days = myRs.getString("days");
				 String adults = myRs.getString("adults");
				 String children = myRs.getString("children");
				 String advance = myRs.getString("advance");
				 String slipNo = myRs.getString("slipNo");
			 
				// create new reservation object
				 NewReservation tempReservation = new NewReservation(id,reserveID,RID,category,name,phone,email, checkIn,checkOut,days,adults,children,advance,slipNo);
				
				// add it to the list of reservations
				 con.add(tempReservation);
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

	public void addReservation(NewReservation theReservation) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into reservation"
						+"(reserveID,RID,category,name,phone,email,checkIn,checkOut,days,adults,children,advance,slipNo)"
						+"values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the reservation
			myStmt.setString(1, theReservation.getReserveID());
			myStmt.setString(2, theReservation.getRID());
			myStmt.setString(3, theReservation.getCategory());
			myStmt.setString(4, theReservation.getName());
			myStmt.setString(5, theReservation.getPhone());
			myStmt.setString(6, theReservation.getEmail());
			myStmt.setString(7, theReservation.getCheckIn());
			myStmt.setString(8, theReservation.getCheckOut());
			myStmt.setString(9, theReservation.getDays());
			myStmt.setString(10, theReservation.getAdults());
			myStmt.setString(11, theReservation.getChildren());
			myStmt.setString(12, theReservation.getAdvance());
			myStmt.setString(13, theReservation.getSlipNo());
			 
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public NewReservation getReservation(String theReservationId) throws Exception{

			NewReservation theReservation = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int reservationId;
			
			try {
				//convert reservation id to int
				reservationId = Integer.parseInt(theReservationId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected reservation
				String sql = "select * from reservation where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, reservationId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					 int id = myRs.getInt("id");
					 String reserveID = myRs.getString("reserveID");
					 String RID = myRs.getString("RID");
					 String category = myRs.getString("category");
					 String name = myRs.getString("name");
					 String phone = myRs.getString("phone");
					 String email = myRs.getString("email");
					 String checkIn = myRs.getString("checkIn");
					 String checkOut = myRs.getString("checkOut");
					 String days = myRs.getString("days");
					 String adults = myRs.getString("adults");
					 String children = myRs.getString("children");
					 String advance = myRs.getString("advance");
					 String slipNo = myRs.getString("slipNo");
					 
					//use the reservation id during construction
					theReservation  = new NewReservation(id,reserveID,RID,category,name,phone,email,checkIn,checkOut,days,adults,children,advance,slipNo);
				}
				else {
					throw new Exception("Could not find reservation id: " + reservationId);
				}
				
				return theReservation;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public static void updateReservation(NewReservation theReservation) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update reservation "
					+ "set reserveID=?,RID=?,category=?,name=?,phone=?,email=?,checkIn=?, checkOut=?,days=?, adults=?, children=?,advance=?,slipNo=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theReservation.getReserveID());
		myStmt.setString(2,theReservation.getRID());
		myStmt.setString(3,theReservation.getCategory());
		myStmt.setString(4,theReservation.getName());
		myStmt.setString(5,theReservation.getPhone());
		myStmt.setString(6, theReservation.getEmail());
		myStmt.setString(7, theReservation.getCheckIn());
		myStmt.setString(8, theReservation.getCheckOut());
		myStmt.setString(9, theReservation.getDays());
		myStmt.setString(10, theReservation.getAdults());
		myStmt.setString(11, theReservation.getChildren());
		myStmt.setString(12, theReservation.getAdvance());
		myStmt.setString(13, theReservation.getSlipNo());
		myStmt.setInt(14, theReservation.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteReservation(String theReservationId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert reservation id to int
			int reservationId = Integer.parseInt(theReservationId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete reservation
			String sql = "delete from reservation where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, reservationId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}

	public void updateStatus(String rID) {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete reservation
			String sql = "update rooms "
						+ "set status=?"
						+ " where RID=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1,"Not Available");
			myStmt.setString(2, rID);
			
			// execute sql statement
			myStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
		
	}		

}

