package com.itp.bills;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itp.Inventory.Inventory;



public class BillsDbUtil {

	private static DataSource dataSource;

	public BillsDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public static List<Bills> getBills() throws Exception{
		
		List<Bills> con = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from bills order by month  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String month = myRs.getString("month");
				 float water = myRs.getFloat("water");
				 float tel_1 = myRs.getFloat("tel_1");
				 float tel_2 = myRs.getFloat("tel_2");
				 float electricity = myRs.getFloat("electricity");
				 float satellite = myRs.getFloat("satellite");
				 float total = myRs.getFloat("total");
				String pay_day = myRs.getString("pay_day");
				
				// create new bills object
				 Bills tempBill = new Bills(id, month,water,tel_1,tel_2,electricity,satellite,total,pay_day);
				
				// add it to the list of billss
				 con.add(tempBill);
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

	public static void addBills(Bills theBill) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into bills"
						+"(month,water,tel_1,tel_2,electricity,satellite,total,pay_day)"
						+"values (?,?,?,?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the bills
			myStmt.setString(1, theBill.getMonth());
			myStmt.setFloat(2, theBill.getWater());
			myStmt.setFloat(3, theBill.getTel_1());
			myStmt.setFloat(4, theBill.getTel_2());
			myStmt.setFloat(5, theBill.getElectricity());
			myStmt.setFloat(6, theBill.getSatellite());
			myStmt.setFloat(7, theBill.getTotal());
			myStmt.setString(8, theBill.getPay_day());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public static Bills getBills(String theBillId) throws Exception{

		Bills theBill = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int billId;
			
			try {
				//convert bills id to int
				billId = Integer.parseInt(theBillId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected bills
				String sql = "select * from bills where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, billId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String month = myRs.getString("month");
					 float water = myRs.getFloat("water");
					 float tel_1 = myRs.getFloat("tel_1");
					 float tel_2 = myRs.getFloat("tel_2");
					 float electricity = myRs.getFloat("electricity");
					 float satellite = myRs.getFloat("satellite");
					 float total = myRs.getFloat("total");
					String pay_day = myRs.getString("pay_day");
					 
					//use the bills id during construction
					theBill  = new Bills(id,month,water,tel_1,tel_2,electricity,satellite,total,pay_day);
				}
				else {
					throw new Exception("Could not find bill id: " + billId);
				}
				
				return theBill;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public static void updateBills(Bills theBill) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update bills "
					+ "set month=?, water=?,tel_1=?,tel_2=?,electricity=?,satellite=?,total=?,pay_day=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theBill.getMonth());
		myStmt.setFloat(2, theBill.getWater());
		myStmt.setFloat(3, theBill.getTel_1());
		myStmt.setFloat(4, theBill.getTel_2());
		myStmt.setFloat(5, theBill.getElectricity());
		myStmt.setFloat(6, theBill.getSatellite());
		myStmt.setFloat(7, theBill.getTotal());
		myStmt.setString(8, theBill.getPay_day());
		myStmt.setInt(9, theBill.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public static void deleteBill(String theBillId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert bills id to int
			int billId = Integer.parseInt(theBillId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete bills
			String sql = "delete from bills where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, billId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		

		
	

}
