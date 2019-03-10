package com.itp.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



public class DinnerTableUtil {

	private static DataSource dataSource;

	public DinnerTableUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<DinnerTable> dinnerTableList() {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		List<DinnerTable> dinnerTable_List = new ArrayList<>();

		String sql = "select * from dinning_table where status_dinning_table=?";
		
		

		try {
			myConn = dataSource.getConnection();
		
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1,"available");

			myRs = myStmt.executeQuery();

			while (myRs.next()) {

				int id = myRs.getInt("id_dinning_table");
				String tableStatus = myRs.getString("status_dinning_table");

				DinnerTable dinnerTable = new DinnerTable();

				dinnerTable.setTableID(id);
				dinnerTable.setTableStatus(tableStatus);

				dinnerTable_List.add(dinnerTable);
			}

			return dinnerTable_List; // changfged

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

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

	public void updateDinnerTable(DinnerTable dinnerTable) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			String sql = "update dinning_table set status_dinning_table=? where id_dinning_table=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			System.out.println("Inside");
			System.out.println(dinnerTable.getTableID());
			myStmt.setInt(2, dinnerTable.getTableID());
			myStmt.setString(1, dinnerTable.getTableStatus());

			myStmt.executeUpdate();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

}
