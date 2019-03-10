package com.itp.clientAccPayment;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class AccomodationPaymentDbUtil {

	private static DataSource dataSource;

	public AccomodationPaymentDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public static List<Accommodation_payments> getAccPay() throws Exception{
		
		List<Accommodation_payments> con = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from accpay order by date  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String reserveId = myRs.getString("reserveId");
				 String date = myRs.getString("date");
				 String RID = myRs.getString("RID");
				 String category = myRs.getString("category");
				 float days= myRs.getFloat("days");
				 float advance = myRs.getFloat("advance");
				 float restaurant = myRs.getFloat("restaurant");
				 float total = myRs.getFloat("total");
				
				// create new teacher object
				 Accommodation_payments tempAccPay = new Accommodation_payments(id,reserveId, date,RID,category,days,advance,restaurant,total);
				
				// add it to the list of teachers
				 con.add(tempAccPay);
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

	public static void addAccPay(Accommodation_payments theAccPay) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into accpay"
						+"(reserveId,date,RID,category,days,advance,restaurant,total)"
						+"values (?,?,?,?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the teacher
			myStmt.setString(1, theAccPay.getReserveId());
			myStmt.setString(2, theAccPay.getDate());
			myStmt.setString(3, theAccPay.getRID());
			myStmt.setString(4, theAccPay.getCategory());
			myStmt.setFloat(5, theAccPay.getDays());
			myStmt.setFloat(6, theAccPay.getAdvance());
			myStmt.setFloat(7, theAccPay.getRestaurant());
			myStmt.setFloat(8, theAccPay.getTotal());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public static Accommodation_payments getAccPay(String theAccPayId) throws Exception{

			Accommodation_payments theAccPay = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int accPayId;
			
			try {
				//convert teacher id to int
				accPayId = Integer.parseInt(theAccPayId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected teacher
				String sql = "select * from accpay where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, accPayId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String reserveId = myRs.getString("reserveId");
					 String date = myRs.getString("date");
					 String RID = myRs.getString("RID");
					 String category = myRs.getString("category");
					 float days= myRs.getFloat("days");
					 float advance = myRs.getFloat("advance");
					 float restaurant = myRs.getFloat("restaurant");
					 float total = myRs.getFloat("total");
					 
					 
					//use the teacher id during construction
					theAccPay  = new Accommodation_payments(id,reserveId,date,RID,category,days,advance,restaurant,total);
				}
				else {
					throw new Exception("Could not find payment id: " + accPayId);
				}
				
				return theAccPay;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public static void updateAccPay(Accommodation_payments theAccPay) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update accpay "
					+ "set reserveId=?,date=?,RID=?,category=?,days=?,advance=?,restaurant=?,total=?"
					+ "where id=?";
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theAccPay.getReserveId());
		myStmt.setString(2, theAccPay.getDate());
		myStmt.setString(3, theAccPay.getRID());
		myStmt.setString(4, theAccPay.getCategory());
		myStmt.setFloat(5, theAccPay.getDays());
		myStmt.setFloat(6, theAccPay.getAdvance());
		myStmt.setFloat(7, theAccPay.getRestaurant());
		myStmt.setFloat(8, theAccPay.getTotal());
		myStmt.setInt(9, theAccPay.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public static void deleteAccPay(String theAccPayId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert teacher id to int
			int accPayId = Integer.parseInt(theAccPayId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete teacher
			String sql = "delete from accpay where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, accPayId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}

	public static Accommodation_payments getReservationInfo(String theReservationId) throws Exception{
		// TODO Auto-generated method stub
		
		Accommodation_payments theReservation = null ;
		
		Connection myConn=null;
		PreparedStatement myStmt =null ;
		ResultSet myRs = null; 
		String reservationId;
		
		try {
			reservationId = theReservationId;
			
			myConn = dataSource.getConnection();
			
			String sql = "select reserveId,RID,category,days,advance from reservation  where reserveId = ? ";
			//String sql1 = "select total from restpay where reserveId = ?";
			
			myStmt = myConn.prepareStatement(sql);
			//myStmt = myConn.prepareStatement(sql1);

			myStmt.setString(1 , reservationId);
			
			myRs = myStmt.executeQuery();
			
			if(myRs.next()) {
				String reserveId = myRs.getString("reserveId");
				String RID = myRs.getString("RID");
				String category = myRs.getString("category");
				float days= myRs.getFloat("days");
				float advance = myRs.getFloat("advance");
				//float restaurant = myRs.getFloat("restaurant");

				//theReservation = new Accommodation_payments( reserveId,RID ,type,days ,advance, restaurant);
				theReservation = new Accommodation_payments( reserveId,RID ,category,days ,advance);

				
			}
			else {
				throw new Exception ("Could not find reservation ID :"+reservationId);
			}
			
			return theReservation ; 
		}
		finally {
		close(myConn,myStmt,myRs);
	}
	}
	
}


