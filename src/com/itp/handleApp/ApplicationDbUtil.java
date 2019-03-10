package com.itp.handleApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ApplicationDbUtil {
	
private static DataSource dataSource;
	
	public ApplicationDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
public List<Application> getApplications() throws Exception {
		
		List<Application> applications = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from Application order by id  ";
			
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
				 String gender = myRs.getString("gender");
				 String edu_qualifi = myRs.getString("edu_qualifi");
				 String job_exp = myRs.getString("job_exp");

				
				// create new applicaion object
				 Application tempApplication = new Application(id,name,address,nic,contact,mail,gender,edu_qualifi,job_exp);
				
				// add it to the list of applicaions
				 applications.add(tempApplication);
			}

		return applications;
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
		System.out.println(exc);
	}
	
}

public void addApplication(Application theApplication) throws Exception{
	
	Connection myConn = null;
	PreparedStatement myStmt = null;
	
	try {
		//get db connection
		myConn = dataSource.getConnection();
		
		// create sql for insert
		String sql = "insert into application"
					+"(name, address,nic ,contact,mail,gender,edu_qualifi,job_exp)"
					+"values ( ?, ?,?,?,?,?,?,?)";
		
		myStmt = myConn.prepareStatement(sql);
	
		// set the param values for the applicaion
		myStmt.setString(1, theApplication.getName());
		myStmt.setString(2, theApplication.getAddress());
		myStmt.setString(3, theApplication.getNic());
		myStmt.setString(4, theApplication.getContact());
		myStmt.setString(5, theApplication.getMail());
		myStmt.setString(6, theApplication.getGender());
		myStmt.setString(7, theApplication.getEdu_qualifi());
		myStmt.setString(8, theApplication.getJob_exp());
		
		
		
	
		//execute sql insert
		myStmt.execute();
	}
	
	finally {
		//clean up JDBC objects
		
	close(myConn, myStmt, null);
	}
	
	
	
}
}
