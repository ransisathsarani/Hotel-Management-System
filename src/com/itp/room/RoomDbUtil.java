package com.itp.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class RoomDbUtil {

	private static DataSource dataSource;

	public RoomDbUtil(DataSource theDataSource) {
		RoomDbUtil.dataSource = theDataSource;
	}
	
	public List<Room> getRoom() throws Exception{
		
		List<Room> con = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from rooms order by RID  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String RID = myRs.getString("RID");
				 String category = myRs.getString("category");
				 String price = myRs.getString("price");
				 String status = myRs.getString("status");
				 
				 
				
				// create newroom object
				 Room tempRoom = new Room(id, RID,category,price,status);
				
				// add it to the list ofrooms
				 con.add(tempRoom);
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

	public void addRoom(Room theRoom) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into rooms"
						+"(RID,category,price,status)"
						+"values (?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for theroom
			myStmt.setString(1, theRoom.getRID());
			myStmt.setString(2, theRoom.getCategory());
			myStmt.setString(3, theRoom.getPrice());
			myStmt.setString(4, theRoom.getStatus());
		 
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public Room getRoom(String theRoomId) throws Exception{

		Room theRoom = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int roomId;
			
			try {
				//convertroom id to int
				roomId = Integer.parseInt(theRoomId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selectedroom
				String sql = "select * from rooms where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, roomId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					 int id = myRs.getInt("id");
					 String RID = myRs.getString("RID");
					 String category = myRs.getString("category");
					 String price = myRs.getString("price");
					 String status = myRs.getString("status");
					 
					
					//use theroom id during construction
					theRoom  = new Room(id,RID,category,price,status);
				}
				else {
					throw new Exception("Could not find room id: " + roomId);
				}
				
				return theRoom;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public static void updateRoom(Room theRoom) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update rooms "
					+ "set RID=?, category=?, price=?, status=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theRoom.getRID());
		myStmt.setString(2, theRoom.getCategory());
		myStmt.setString(3, theRoom.getPrice());
		myStmt.setString(4, theRoom.getStatus());
		myStmt.setInt(5, theRoom.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteRoom(String theRoomId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convertroom id to int
			int roomId = Integer.parseInt(theRoomId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to deleteroom
			String sql = "delete from rooms where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, roomId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		

 

public List<Room> getAvailableRoom() throws SQLException {
	
	List<Room> con = new ArrayList<>();
	
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	
	try {
		// get a connection
		myConn = dataSource.getConnection();
		
		// create sql statement
		String sql = "select * from rooms WHERE status='Available'";
		
		myStmt = myConn.createStatement();
		
		//execute query
		myRs = myStmt.executeQuery(sql);
		
		//process result set
		while(myRs.next()) {
			
			//retrieve data from result set row
			 int id = myRs.getInt("id");
			 String RID = myRs.getString("RID");
			 String category = myRs.getString("category");
			 String price = myRs.getString("price");
			 String status = myRs.getString("status");
			 
			 
			
			// create newroom object
			 Room tempRoom = new Room(id, RID,category,price,status);
			
			// add it to the list ofrooms
			 con.add(tempRoom);
		}

		
		return con;
		
	}
	finally {
		
		//close JDBC objects
		close(myConn, myStmt, myRs);

	}
	
}
	
	
	
}



