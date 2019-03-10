package com.itp.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;



public class TableReservationDbUtil {

	private static DataSource dataSource;
   

	public TableReservationDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
		
	}

	public static List<TableReservation> getTableReservation() throws Exception {

		List<TableReservation> con = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			myConn = dataSource.getConnection();
			String sql = "select * from tablereservation order by id";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {
				int Id = Integer.parseInt(myRs.getString("id"));
				int tableId = Integer.parseInt(myRs.getString("tableId"));
				String menuId = myRs.getString("menuId");
				String name = myRs.getString("name");
				String email = myRs.getString("email");
				String date = myRs.getString("date");
				String contactNo = myRs.getString("contactNo");
				String noOfPeople = myRs.getString("noOfPeople");

				TableReservation tempTableReservation = new TableReservation(Id, menuId, name, email,date,contactNo, noOfPeople,tableId);
				con.add(tempTableReservation);
				
				

			}
			return con;
		} finally {

			close(myConn, myStmt, myRs);
		}
	}


	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub

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

	public static void addTableReservation(TableReservation theTableReservation) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		DinnerTable dinnerTable = new DinnerTable();
		
		dinnerTable.setTableID(theTableReservation.getTableId());
		dinnerTable.setTableStatus("reserved");
		DinnerTableUtil dinnerTableUtil = new DinnerTableUtil(dataSource);
		dinnerTableUtil.updateDinnerTable(dinnerTable);
		

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "insert into tablereservation" + "(tableId, menuId, name, date, email, contactNo, noOfPeople)"
					+ "values (?, ?, ?,?,?,?,?)";

			myStmt = myConn.prepareStatement(sql);
			
		

			// set the param values for the TakeAway
			myStmt.setInt(1, theTableReservation.getTableId());
			myStmt.setString(2, theTableReservation.getMenuId());
			myStmt.setString(3, theTableReservation.getName());
			myStmt.setString(4, theTableReservation.getDate());
			myStmt.setString(5, theTableReservation.getEmail());
			myStmt.setString(6, theTableReservation.getContactNo());
			myStmt.setString(7, theTableReservation.getNoOfPeople());

			// execute sql insert
			myStmt.executeUpdate();
		} finally {
			// clean up JDBC objects

			close(myConn, myStmt, null);
		}
	}

	public TableReservation getTableReservation(int theTableReservationId) throws Exception {

		TableReservation theTableReservation = null;

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int tableReservationId;

		try {
			// convert table reservation id to int
			

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to get selected table reservation
			String sql = "select * from tablereservation where id=?";

			// create prepared statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, theTableReservationId);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result row
			if (myRs.next()) {
				int id = myRs.getInt("id");
				int tableId = Integer.parseInt(myRs.getString("tableId"));
				String menuId = myRs.getString("menuId");
				String name = myRs.getString("name");
				String date = myRs.getString("date");
				String email = myRs.getString("email");
				String contactNo = myRs.getString("contactNo");
				String  noOfPeople= myRs.getString("noOfPeople");

				// use the table reservation id during construction
				theTableReservation = new TableReservation(id,  menuId,name,  email,date,   contactNo,
						noOfPeople);
			} else {
				throw new Exception("Could not find TableReservation id: " + theTableReservationId);
			}

			return theTableReservation;
		} finally {
			// clean up JDBC ojects
			close(myConn, myStmt, myRs);
		}

	}

	public void deleteTableReservations(int theTableReservationId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// convert table reservation id to int
			

			// get connection to database
			myConn = dataSource.getConnection();
			
			System.out.println("Delete "+theTableReservationId);

			// create sql to delete TakeAway
			String sql = "delete from tablereservation where id=?";
			
			TableReservation reservation = this.getTableReservation(theTableReservationId);
			
			int tableID = reservation.getTableId();
			
			DinnerTable dinnerTable = new DinnerTable();
			
			dinnerTable.setTableID(tableID);
			dinnerTable.setTableStatus("available");
			
			DinnerTableUtil dinnerTableUtil = new DinnerTableUtil(dataSource);
			dinnerTableUtil.updateDinnerTable(dinnerTable);

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, theTableReservationId);

			// execute sql statement
			myStmt.executeUpdate();
		} finally {

			// clean up JDBC code
			close(myConn, myStmt, null);
		}
	}

	public void updateTableReservations(TableReservation theTableReservation) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create sql update statement
			String sql = "update tablereservation "
					+ "set menuId=?,name=?,date=?,email=?,contactNo=?,noOfPeople=?" + "where id=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			
			myStmt.setString(1, theTableReservation.getMenuId());
			myStmt.setString(2, theTableReservation.getName());
			myStmt.setString(3, theTableReservation.getDate());
			myStmt.setString(4, theTableReservation.getEmail());
			myStmt.setString(5, theTableReservation.getContactNo());
			myStmt.setString(6, theTableReservation.getNoOfPeople());
			myStmt.setInt(7, theTableReservation.getId());

			// execute sql statement
			myStmt.executeUpdate();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public static TableReservation getTableReservations(String theTableReservationId) {
		// TODO Auto-generated method stub
		return null;
	}
}
