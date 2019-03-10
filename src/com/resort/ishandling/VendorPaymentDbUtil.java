
package com.resort.ishandling;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import com.itp.Inventory.Inventory;




public class VendorPaymentDbUtil {
	
	private static DataSource dataSource;

	public VendorPaymentDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public static List<VendorPayment> getVendorPayment() throws Exception{
		
		List<VendorPayment> con = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from vendorpayment order by iDate  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String invoice = myRs.getString("invoice");
			
				 String iDate = myRs.getString("iDate");
				 String vendor = myRs.getString("vendor");
				 String vendorId = myRs.getString("vendorId");
				 String department = myRs.getString("department");
				 String stockId = myRs.getString("stockId");
				 Float amount = myRs.getFloat("amount");
				 Float paidAmount = myRs.getFloat("paidAmount");
				 String paymentType = myRs.getString("paymentType");
				
				// create new teacher object
				 VendorPayment tempVendor = new VendorPayment(id, invoice,iDate,vendor,vendorId,department,stockId,amount,paidAmount,paymentType);
				
				// add it to the list of teachers
				 con.add(tempVendor);
			}

			
			return con;
			
		}
		finally {
			
			//close JDBC objects
			close(myConn, myStmt, myRs);

		}
		
	}
	
	
public static List<VendorPayment> getPaidDetails() throws Exception{
		
		List<VendorPayment> con = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select iDate,vendorId,paidAmount from paymentinfo order by paidAmount";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				// int id = myRs.getInt("id");
				 String iDate = myRs.getString("iDate");
				 String vendorId = myRs.getString("vendorId");
				 Float paidAmount = myRs.getFloat("paidAmount");
								
				// create new teacher object
				 VendorPayment tempPaymentINFO = new VendorPayment(iDate,vendorId,paidAmount);
				
				// add it to the list of teachers
				 con.add(tempPaymentINFO);
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

	public static void addVendorPayment(VendorPayment theVendorPayment){
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		PreparedStatement myStmt1 = null;
		PreparedStatement myStmt2 = null;
		PreparedStatement myStmtCheck = null;
		ResultSet myRs = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into vendorpayment"
						+"(invoice,iDate,vendor,vendorId,department,stockId,amount,paidAmount,paymentType)"
						+"values (?,?,?,?,?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the teacher
			myStmt.setString(1, theVendorPayment.getInvoice());
			myStmt.setString(2, theVendorPayment.getiDate());
			myStmt.setString(3, theVendorPayment.getVendor());
			myStmt.setString(4, theVendorPayment.getVendorId());
			myStmt.setString(5, theVendorPayment.getDepartment());
			myStmt.setString(6, theVendorPayment.getStockId());
			myStmt.setFloat(7, theVendorPayment.getAmount());
			myStmt.setFloat(8, theVendorPayment.getPaidAmount());
			myStmt.setString(9, theVendorPayment.getPaymentType());
			
			//execute sql insert for add payment information
			myStmt.execute();
			
			String sqlinfo = "insert into paymentinfo"
					+"(iDate,vendorId,paidAmount)"
					+"values (?,?,?)";
		
			myStmt1 = myConn.prepareStatement(sqlinfo);
	
			// set the param values for the teacher
			
			myStmt1.setString(1, theVendorPayment.getiDate());
			
			myStmt1.setString(2, theVendorPayment.getVendorId());
			
			myStmt1.setFloat(3, theVendorPayment.getPaidAmount());
			
			//execute sql insert
			myStmt1.execute();
			
			/*String sqlinsert = "insert into paymentinfo"
					+"(iDate,vendorId,paidAmount)"
					+"values (?,?,?)";
			
			String sqlupdate =  "update paymentinfo "
					+ "set iDate=?, paidAmount=?,remainingAmount=?"
					+ "where vendorId=?";
		*/
			
			//myStmt = myConn.prepareStatement();
	
			
			
				
				
				System.out.println("vendorid : "+theVendorPayment.getVendorId());
				String sqlIns ="insert into remainingpayment"
						+"(vendorId,remainingAmount)"
						+"values (?,?)";
				
				myStmt2 = myConn.prepareStatement(sqlIns);
				
				myStmt2.setString(1, theVendorPayment.getVendorId());
				myStmt2.setFloat(2, theVendorPayment.getAmount());
				
				myStmt2.execute();
				
			
			
			
			
			
			
			
		}
		catch (Exception e){
			System.out.println("Exception in AddVendorPayment " +e);
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}
	
		
public static void addPaidDetails(VendorPayment theVendorPayment){
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			String sqlinfo = "insert into paymentinfo"
					+"(iDate,vendorId,paidAmount)"
					+"values (?,?,?)";
		
			myStmt = myConn.prepareStatement(sqlinfo);
	
			// set the param values for the teacher
			
			myStmt.setString(1, theVendorPayment.getiDate());
			myStmt.setString(2, theVendorPayment.getVendorId());
			myStmt.setFloat(3, theVendorPayment.getPaidAmount());
			
			//execute sql insert
			myStmt.execute();
			
		}
		catch (Exception e){
			System.out.println("Exception in Add Paid Details" +e);
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
	}
	

	

	public static VendorPayment getVendorPayment(String theVendorPaymentId) throws Exception{

		VendorPayment theVendorPayment = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int vendorPaymentId;
			
			try {
				//convert teacher id to int
				vendorPaymentId = Integer.parseInt(theVendorPaymentId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected teacher
				String sql = "select * from vendorpayment where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, vendorPaymentId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String invoice = myRs.getString("invoice");
					 String iDate = myRs.getString("iDate");
					 String vendor = myRs.getString("vendor");
					 String vendorId = myRs.getString("vendorId");
					 String department = myRs.getString("department");
					 String stockId = myRs.getString("stockId");
					 Float amount = myRs.getFloat("amount");
					 Float paidAmount = myRs.getFloat("paidAmount");
					 String paymentType = myRs.getString("paymentType");
					
					//use the teacher id during construction
					theVendorPayment  = new VendorPayment(id,invoice,iDate,vendor,vendorId,department,stockId,amount,paidAmount,paymentType);
				}
				else {
					throw new Exception("Could not find inventory id: " + vendorPaymentId);
				}
				
				return theVendorPayment;
			}
			finally {
				// clean up JDBC objects
				close(myConn, myStmt, myRs);
			}
	
	}
	
	
	public static VendorPayment getVendorInfo(String theVendorPaymentId) throws Exception{

		VendorPayment theVendorPayment = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			String vendorPaymentId;
			
			try {
				//convert teacher id to int
				vendorPaymentId = theVendorPaymentId;
				//vendorPaymentId = Integer.parseInt(theVendorPaymentId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected teacher
				String sql = "SELECT vendorId,remainingAmount FROM remainingpayment where vendorId =?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setString(1, vendorPaymentId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					//int id = myRs.getInt("id");
					String vendorId = myRs.getString("vendorId");
					float remainingAmount = myRs.getFloat("remainingAmount");
					//String iDate = myRs.getString("iDate");
					
					
					
					
					//use the teacher id during construction
					theVendorPayment  = new VendorPayment(vendorId, remainingAmount);
				}
				else {
					throw new Exception("Could not find inventory id: " + vendorPaymentId);
				}
				
				return theVendorPayment;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}
	
	
	
	
	
	

	public static void updateVendorPayment(VendorPayment theVendorPayment) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update vendorpayment "
					+ "set invoice=?, iDate=?,vendor=?,vendorId=?,department=?,stockId=?,amount=?,paidAmount=?,paymentType=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theVendorPayment.getInvoice());
		myStmt.setString(2, theVendorPayment.getiDate());
		myStmt.setString(3, theVendorPayment.getVendor());
		myStmt.setString(4, theVendorPayment.getVendorId());
		myStmt.setString(5, theVendorPayment.getDepartment());
		myStmt.setString(6, theVendorPayment.getStockId());
		myStmt.setFloat(7, theVendorPayment.getAmount());
		myStmt.setFloat(8, theVendorPayment.getPaidAmount());
		myStmt.setString(9, theVendorPayment.getPaymentType());
		myStmt.setInt(10, theVendorPayment.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public static void deleteVendorPayment(String theVendorPaymentId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert teacher id to int
			int vendorPaymentId = Integer.parseInt(theVendorPaymentId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete teacher
			String sql = "delete from vendorpayment where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, vendorPaymentId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		

}

