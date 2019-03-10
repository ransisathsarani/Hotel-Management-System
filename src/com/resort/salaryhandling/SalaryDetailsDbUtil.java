package com.resort.salaryhandling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



public class SalaryDetailsDbUtil {
	private static DataSource dataSource;

	public SalaryDetailsDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public static List<SalaryDetails> getSalaryDetails() throws Exception{
		
		List<SalaryDetails> con = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from salarydetails  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String empid = myRs.getString("empid");
				 String salary = myRs.getString("salary");
				 String otRates = myRs.getString("otRates");
				 String otHours = myRs.getString("otHours");
				 String bonusPayment = myRs.getString("bonusPayment");
				 String panaltyPayment = myRs.getString("panaltyPayment");
				
				
				
				// create new salary object
				 SalaryDetails tempSalaryD = new SalaryDetails(id, empid,salary,otRates,otHours,bonusPayment,panaltyPayment);
				
				// add it to the list of salarys
				 con.add(tempSalaryD);
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

	public static void addSalaryDetails(SalaryDetails theSalaryDetails) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into salarydetails"
						+"(empid,salary,otRates,otHours,bonusPayment,panaltyPayment)"
						+"values (?, ?, ?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the salary
			myStmt.setString(1, theSalaryDetails.getEmpid());
			myStmt.setString(2, theSalaryDetails.getSalary());
			myStmt.setString(3, theSalaryDetails.getOtRates());
			myStmt.setString(4, theSalaryDetails.getOtHours());
			myStmt.setString(5, theSalaryDetails.getBonusPayment());
			myStmt.setString(6, theSalaryDetails.getPanaltyPayment());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public static SalaryDetails getSalaryDetails(String theSalaryDetailsId) throws Exception{

		SalaryDetails theSalaryDetails = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int salaryDetailsId;
			
			try {
				//convert salary id to int
				salaryDetailsId = Integer.parseInt(theSalaryDetailsId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected salary
				String sql = "select * from salarydetails where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, salaryDetailsId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String empid = myRs.getString("empid");
					 String salary = myRs.getString("salary");
					 String otRates = myRs.getString("otRates");
					 String otHours = myRs.getString("otHours");
					 String bonusPayment = myRs.getString("bonusPayment");
					 String panaltyPayment = myRs.getString("panaltyPayment");
					 
					//use the salary id during construction
					theSalaryDetails  = new SalaryDetails(id,empid,salary,otRates,otHours,bonusPayment,panaltyPayment);
				}
				else {
					throw new Exception("Could not find salary detials id: " + salaryDetailsId);
				}
				
				return theSalaryDetails;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public static void updateSalaryDetails(SalaryDetails theSalaryDetails) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update salarydetails "
					+ "set empid=?, salary=?,otRates=?,otHours=?,bonusPayment=?,panaltyPayment=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theSalaryDetails.getEmpid());
		myStmt.setString(2, theSalaryDetails.getSalary());
		myStmt.setString(3, theSalaryDetails.getOtRates());
		myStmt.setString(4, theSalaryDetails.getOtHours());
		myStmt.setString(5, theSalaryDetails.getBonusPayment());
		myStmt.setString(6, theSalaryDetails.getPanaltyPayment());
		myStmt.setInt(7, theSalaryDetails.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public static void deleteSalaryDetails(String theSalaryDetailsId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert salary id to int
			int salaryDetailsId = Integer.parseInt(theSalaryDetailsId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete salary
			String sql = "delete from salarydetails where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, salaryDetailsId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		
}

