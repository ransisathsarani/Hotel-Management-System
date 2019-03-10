package com.resort.salaryhandling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.resort.ishandling.VendorPayment;

public class SalaryDbUtil {

	private static DataSource dataSource;

	public SalaryDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}

	public static Salary getEmployeeDetails(String theEmployeeId) throws Exception {

		Salary salary = null;

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String employeeId;

		try {
			// convert salary id to int
			employeeId = theEmployeeId;
			// vendorPaymentId = Integer.parseInt(theVendorPaymentId);

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to get selected salary
			String sql = "SELECT empId,empName,basicSalary,otRate,otHours,bonusPayment,panaltyPayment FROM emp where empId =?";

			// create prepared statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, employeeId);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result row
			if (myRs.next()) {
				// int id = myRs.getInt("id");
				String empId = myRs.getString("empId");
				String empName = myRs.getString("empName");
				double basicSalary = myRs.getDouble("basicSalary");
				double otRate = myRs.getDouble("otRate");
				int otHours = myRs.getInt("otHours");
				double bonusPayment = myRs.getDouble("bonusPayment");
				double panaltyPayment = myRs.getDouble("panaltyPayment");

				// String iDate = myRs.getString("iDate");

				// use the salary id during construction
				salary = new Salary(empId, empName, basicSalary, otRate, otHours, bonusPayment, panaltyPayment);
			} else {
				throw new Exception("Could not find inventory id: " + employeeId);
			}

			return salary;
		} finally {
			// clean up JDBC ojects
			close(myConn, myStmt, myRs);
		}

	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void addEmployeeSalary(Salary theSalary) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			System.out.println("db connection salary : "+theSalary.getTotalSalary());
			
			// create sql for insert
			String sql = "INSERT INTO empsalary (empId,tottalSalary) values (?,?) ";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the salary
			myStmt.setString(1, theSalary.getEmpId());
			myStmt.setDouble(2, theSalary.getTotalSalary());
			
			//execute sql insert for add payment information
			myStmt.execute();
			
			
			
						
		}
		catch (Exception e){
			System.out.println("Exception in AddEmployeeSalary " +e);
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}

	}

}
