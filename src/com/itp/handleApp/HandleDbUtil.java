package com.itp.handleApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class HandleDbUtil {
	
	private static DataSource dataSource;
	
	public HandleDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	

	public List<Handle> getHandles() throws Exception {
		
		List<Handle> handles = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		 
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from handle order by id  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String name = myRs.getString("name");
				 String address = myRs.getString("address");
				 String nic = myRs.getString("nic");
				 String contact = myRs.getString("contact");
				 String mail = myRs.getString("mail");
				 String intDate = myRs.getString("intDate");
				 String intVenue = myRs.getString("intVenue");
				 String tDate = myRs.getString("tDate");
				 String tVenue = myRs.getString("tVenue");
				
				// create new handling object
				 Handle tempHandle = new Handle(id,name,address,nic,contact,mail,intDate,intVenue,tDate,tVenue);
				
				// add it to the list of handlings
				 handles.add(tempHandle);
			}

		return handles;
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
			System.out.println(exc);
		}
		
	}


	public void addHandle(Handle theHandle) throws Exception  {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into handle"
						+"(name, address,nic ,contact,mail,intDate,intVenue,tDate,tVenue)"
						+"values ( ?, ?,?,?,?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the handling
			myStmt.setString(1, theHandle.getName());
			myStmt.setString(2, theHandle.getAddress());
			myStmt.setString(3, theHandle.getNic());
			myStmt.setString(4, theHandle.getContact());
			myStmt.setString(5, theHandle.getmail());
			myStmt.setString(6, theHandle.getIntDate());
			myStmt.setString(7, theHandle.getIntVenue());
			myStmt.setString(8, theHandle.gettDate());
			myStmt.setString(9, theHandle.gettVenue());
			
			
		
			//execute sql insert
			myStmt.execute();
		}
		
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}


	public Handle getHandle(String theHandleId)throws Exception {
		
		Handle theHandle = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int handleId;
		
		try {
			
			
			//convert handling id to int
			handleId = Integer.parseInt(theHandleId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to get selected handling
			String sql = "select * from handle where id=?";
			
			//create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, handleId);
			
			//execute statement
			myRs = myStmt.executeQuery();
			
			//retrieve data from result row
			if (myRs.next()) {
				 String name = myRs.getString("name");
				 String address = myRs.getString("address");
				 String nic = myRs.getString("nic");
				 String contact = myRs.getString("contact");
				 String mail = myRs.getString("mail");
				 String intDate = myRs.getString("intDate");
				 String intVenue = myRs.getString("intVenue");
				 String tDate = myRs.getString("tDate");
				 String tVenue = myRs.getString("tVenue");
				
				//use the handling id during construction
				theHandle = new Handle(handleId,name,address,nic,contact,mail,intDate,intVenue,tDate,tVenue);
			}
			else {
				throw new Exception("Could not find Handle id: " + handleId);
			}
			
			
			return theHandle;
		}
		finally {
			
			// clean up JDBC ojects
			close(myConn, myStmt, myRs);
			
		}
		
		
		
	}


	public void deleteHandle(String theHandleId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			
			int handleId = Integer.parseInt(theHandleId);
			
			myConn = dataSource.getConnection();
			
			String sql = "delete from handle where id=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, handleId);
			
			myStmt.execute();
			
			
			
		}
		finally{
			
			close(myConn, myStmt, null);
			
		}
		
	}



	public static void updateHandle(Handle theHandle)throws Exception {
		
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create sql update statement
			String sql = "update handle "
						+ "set name=?, address=?, nic=?, contact=?, mail=?, intDate=?, intVenue=?, tDate=?, tVenue=?"
						+ "where id=?";
			
			
			
			//prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setString(1, theHandle.getName());
			myStmt.setString(2, theHandle.getAddress());
			myStmt.setString(3, theHandle.getNic());
			myStmt.setString(4, theHandle.getContact());
			myStmt.setString(5, theHandle.getmail());
			myStmt.setString(6, theHandle.getIntDate());
			myStmt.setString(7, theHandle.getIntVenue());
			myStmt.setString(8, theHandle.gettDate());
			myStmt.setString(9, theHandle.gettVenue());
			myStmt.setInt(10, theHandle.getId());
			
		
			
			//execute sql statement
			myStmt.execute();
		}
			
			catch(Exception exc) {
				exc.printStackTrace();
				System.out.println(exc);
				
			}
			
		finally {
			//clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}
		
	
}
