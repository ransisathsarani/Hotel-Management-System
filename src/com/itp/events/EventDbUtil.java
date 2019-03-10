package com.itp.events;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class EventDbUtil {

		private DataSource dataSource;

		public EventDbUtil(DataSource theDataSource) {
			this.dataSource = theDataSource;
		}
		
		public List<Event> getEvents() throws Exception{
			
			List<Event> events = new ArrayList<>();
			
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;
			
			try {
				// get a connection
				myConn = dataSource.getConnection();
				
				// create sql statement
				String sql = "select * from event order by date  ";
				
				myStmt = myConn.createStatement();
				
				//execute query
				myRs = myStmt.executeQuery(sql);
				
				//process result set
				while(myRs.next()) {
					
					//retrieve data from result set row
					 int id = myRs.getInt("id");
					 String date = myRs.getString("date");
					 String type = myRs.getString("type");
					 String nic = myRs.getString("nic");
					 String client_first_name = myRs.getString("client_first_name");
					 String client_last_name = myRs.getString("client_last_name");
					 String address = myRs.getString("address");
					 String post_code = myRs.getString("post_code");
					 String tel_no = myRs.getString("tel_no");
					 String mobile_no = myRs.getString("mobile_no");
					 String email = myRs.getString("email");
					 int no_of_people = myRs.getInt("no_of_people");
					 String special_requests = myRs.getString("special_requests");
					 
					
					// create new event object
						Event tempEvent = new Event(id, date, type, nic, client_first_name, client_last_name, address, post_code, tel_no, mobile_no, email, no_of_people, special_requests);

					
					// add it to the list of events
					 events.add(tempEvent);
				}
	
				
				return events;
				
			}
			finally {
				
				//close JDBC objects
				close(myConn, myStmt, myRs);
	
			}
			
		}

		private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
			
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

		public void addEvent(Event theEvent) throws Exception {
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			try {
				//get db connection
				myConn = dataSource.getConnection();
				
				// create sql for insert
				String sql = "insert into event"
							+"(date, type, nic, client_first_name, client_last_name, address, post_code, tel_no, mobile_no, email, no_of_people, special_requests)"
							+"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
				
				myStmt = myConn.prepareStatement(sql);
			
				// set the param values for the event
				myStmt.setString(1, theEvent.getDate());
				myStmt.setString(2, theEvent.getType());
				myStmt.setString(3, theEvent.getNic());
				myStmt.setString(4, theEvent.getClient_first_name());
				myStmt.setString(5, theEvent.getClient_last_name());
				myStmt.setString(6, theEvent.getAddress());
				myStmt.setString(7, theEvent.getPost_code());
				myStmt.setString(8, theEvent.getTel_no());
				myStmt.setString(9, theEvent.getMobile_no());
				myStmt.setString(10, theEvent.getEmail());
				myStmt.setInt(11, theEvent.getNo_of_people());
				myStmt.setString(12, theEvent.getSpecial_requests());
				
			
				//execute sql insert
				myStmt.execute();
			}
			finally {
				//clean up JDBC objects
				
			close(myConn, myStmt, null);
			}
			
			
		}

		public Event getEvent(String theEventId) throws Exception{

				Event theEvent = null;
				
				Connection myConn = null;
				PreparedStatement myStmt = null;
				ResultSet myRs = null;
				int eventId;
				
				try {
					//convert event id to int
					eventId = Integer.parseInt(theEventId);
					
					//get connection to database
					myConn = dataSource.getConnection();
					
					//create sql to get selected event
					String sql = "select * from event where id=?";
					
					//create prepared statement
					myStmt = myConn.prepareStatement(sql);
					
					//set params
					myStmt.setInt(1, eventId);
					
					//execute statement
					myRs = myStmt.executeQuery();
					
					//retrieve data from result row
					if (myRs.next()) {
						int id = myRs.getInt("id");
						String date = myRs.getString("date");
						String type = myRs.getString("type");
						String nic = myRs.getString("nic");
						String client_first_name = myRs.getString("client_first_name");
						String client_last_name = myRs.getString("client_last_name");
						String address = myRs.getString("address");
						String post_code = myRs.getString("post_code");
						String tel_no = myRs.getString("tel_no");
						String mobile_no = myRs.getString("mobile_no");
						String email = myRs.getString("email");
						int no_of_people = myRs.getInt("no_of_people");
						String special_requests = myRs.getString("special_requests");
						
					
						
						//use the event id during construction
						theEvent = new Event(id, date, type, nic, client_first_name, client_last_name, address, post_code, tel_no, mobile_no, email, no_of_people, special_requests);
					}
					else {
						throw new Exception("Could not find event id: " + eventId);
					}
					
					return theEvent;
				}
				finally {
					// clean up JDBC ojects
					close(myConn, myStmt, myRs);
				}
		
		}

		public void updateEvent(Event theEvent) throws Exception {
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create sql update statement
			String sql = "update event "
						+ "set date=?, type=?, nic=?, client_first_name=?, client_last_name=?, address=?, post_code=?, tel_no=?, mobile_no=?, email=?, no_of_people=?, special_requests=?  "
						+ "where id=?";
			
			
			//prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setString(1, theEvent.getDate());
			myStmt.setString(2, theEvent.getType());
			myStmt.setString(3, theEvent.getNic());
			myStmt.setString(4, theEvent.getClient_first_name());
			myStmt.setString(5, theEvent.getClient_last_name());
			myStmt.setString(6, theEvent.getAddress());
			myStmt.setString(7, theEvent.getPost_code());
			myStmt.setString(8, theEvent.getTel_no());
			myStmt.setString(9, theEvent.getMobile_no());
			myStmt.setString(10, theEvent.getEmail());
			myStmt.setInt(11, theEvent.getNo_of_people());
			myStmt.setString(12, theEvent.getSpecial_requests());
			myStmt.setInt(13, theEvent.getId());
			
			
			//execute sql statement
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

		public void deleteEvent(String theEventId) throws Exception{
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			try {
				// convert event id to int
				int eventId = Integer.parseInt(theEventId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to delete event
				String sql = "delete from event where id=?";
				
				// prepare statement
				myStmt = myConn.prepareStatement(sql);
				
				// set params
				myStmt.setInt(1, eventId);
				
				// execute sql statement
				myStmt.execute();
			}
			finally {
				
				// clean up JDBC code
				close(myConn, myStmt, null);
			}			
		}

		public void updateEventBill(Event theEvent) throws Exception {
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create sql update statement
			String sql = "update event "
						+ "set resort_charges=?, accumulative_tax=?, total=?, prepayment=?, payment_status=?, payment_date=?  "
						+ "where id=?";
			
			
			//prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setDouble(1, theEvent.getResort_charges());
			myStmt.setDouble(2, theEvent.getAccumulative_tax());
			myStmt.setDouble(3, theEvent.getTotal());
			myStmt.setDouble(4, theEvent.getPrepayment());
			myStmt.setString(5, theEvent.getPayment_status());
			myStmt.setString(6, theEvent.getPayment_date());
			myStmt.setInt(7, theEvent.getId());
			
			
			//execute sql statement
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			close(myConn, myStmt, null);
		}			
		}

		public Event getEventBill(String theEventId) throws Exception {
			
			Event theEvent = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int eventId;
			
			try {
				//convert event id to int
				eventId = Integer.parseInt(theEventId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected event
				String sql = "select * from event where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, eventId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					int no_of_people = myRs.getInt("no_of_people");
					double resort_charges = myRs.getDouble("resort_charges");
					double accumulative_tax = myRs.getDouble("accumulative_tax");
					double total = myRs.getDouble("total");
					double prepayment = myRs.getDouble("prepayment");
					String payment_status = myRs.getString("payment_status");
					String payment_date = myRs.getString("payment_date");

					
				
					
					//use the event id during construction
					theEvent = new Event(id, no_of_people, resort_charges, accumulative_tax, total, prepayment, payment_status, payment_date);
				}
				else {
					throw new Exception("Could not find event id: " + eventId);
				}
				
				return theEvent;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
		}

		public Event getEventMenu(String theEventId) throws Exception {
			
			Event theEvent = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int eventId;
			
			try {
				//convert event id to int
				eventId = Integer.parseInt(theEventId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected event
				String sql = "select * from event where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, eventId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String appetizer = myRs.getString("appetizer");
					String soup = myRs.getString("soup");
					String rice1 = myRs.getString("rice1");
					String rice2 = myRs.getString("rice2");
					String noodles = myRs.getString("noodles");
					String fish = myRs.getString("fish");
					String chicken = myRs.getString("chicken");
					String vegetable1 = myRs.getString("vegetable1");
					String vegetable2 = myRs.getString("vegetable2");
					String vegetable3 = myRs.getString("vegetable3");
					String dessert1 = myRs.getString("dessert1");
					String dessert2 = myRs.getString("dessert2");

					
				
					
					//use the event id during construction
					theEvent = new Event(id, appetizer, soup, rice1, rice2, noodles, fish, chicken, vegetable1, vegetable2, vegetable3, dessert1, dessert2);
				}
				else {
					throw new Exception("Could not find wedding id: " + eventId);
				}
				
				return theEvent;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
		}

		public void updateEventMenu(Event theEvent) throws Exception {
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create sql update statement
			String sql = "update event "
						+ "set appetizer=?, soup=?, rice1=?, rice2=?, noodles=?, fish=?, chicken=?, vegetable1=?, vegetable2=?, vegetable3=?, dessert1=?, dessert2=?  "
						+ "where id=?";
			
			
			//prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setString(1, theEvent.getAppetizer());
			myStmt.setString(2, theEvent.getSoup());
			myStmt.setString(3, theEvent.getRice1());
			myStmt.setString(4, theEvent.getRice2());
			myStmt.setString(5, theEvent.getNoodles());
			myStmt.setString(6, theEvent.getFish());
			myStmt.setString(7, theEvent.getChicken());
			myStmt.setString(8, theEvent.getVegetable1());
			myStmt.setString(9, theEvent.getVegetable2());
			myStmt.setString(10, theEvent.getVegetable3());
			myStmt.setString(11, theEvent.getDessert1());
			myStmt.setString(12, theEvent.getDessert2());
			myStmt.setInt(13, theEvent.getId());
			
			
			//execute sql statement
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			close(myConn, myStmt, null);
		}			
			
		}

			
	}
		


