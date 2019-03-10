package com.itp.handleApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeDbUtil {
	
private static DataSource dataSource;
	
	public EmployeeDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;

}
	
public List<Employee> getEmployees() throws Exception {
	
	List<Employee> employees = new ArrayList<>();
	
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	 
		
		
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			
			
			// create sql statement
			String sql = "select * from Employee order by id  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String empid = myRs.getString("empid");
				 String name = myRs.getString("name");
				 String address = myRs.getString("address");
				 String nic = myRs.getString("nic");
				 String contact = myRs.getString("contact");
				 String mail = myRs.getString("mail");
				 String gender = myRs.getString("gender");
				 String job_title = myRs.getString("job_title");
				 String salary = myRs.getString("salary");
				 String department = myRs.getString("department");
				 String appointmentDate = myRs.getString("appointmentDate");
				
				
				// create new emp object
				 Employee tempEmployee = new Employee(id,empid,name,nic,contact,mail,gender,job_title,salary,department,appointmentDate,address);
				
				// add it to the list of emps
				 employees.add(tempEmployee);
			}

		return employees;
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


	public void addEmployee(Employee theEmployee) throws Exception  {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			System.out.println("äppointment date:"+ theEmployee.getAppointmentDate());
			System.out.println("address :" + theEmployee.getAddress() );
			
			// create sql for insert
			String sql = "insert into employee"
						+"(empid,name,nic,contact,mail,gender,job_title,salary,department,appointmentDate,address)"
						+"values ( ?,?,?,?,?,?,?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the emp
			myStmt.setString(1, theEmployee.getEmpid());
			myStmt.setString(2, theEmployee.getName());
			myStmt.setString(3, theEmployee.getNic());
			myStmt.setString(4, theEmployee.getContact());
			myStmt.setString(5, theEmployee.getMail());
			myStmt.setString(6, theEmployee.getGender());
			myStmt.setString(7, theEmployee.getJob_title());
			myStmt.setString(8, theEmployee.getSalary());
			myStmt.setString(9, theEmployee.getDepartment());
			myStmt.setString(10, theEmployee.getAppointmentDate());
			myStmt.setString(11, theEmployee.getAddress());
			
		
			//execute sql insert
			myStmt.execute();
		}
		
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}


	public Employee getEmployee(String theEmployeeId)throws Exception {
		
		Employee theEmployee = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int employeeId;
		
		try {
			
			
			//convert emp id to int
			employeeId = Integer.parseInt(theEmployeeId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to get selected emp
			String sql = "select * from employee where id=?";
			
			//create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, employeeId);
			
			//execute statement
			myRs = myStmt.executeQuery();
			
			//retrieve data from result row
			if (myRs.next()) {
				
				 String empid = myRs.getString("empid");
				 String name = myRs.getString("name");
				 String nic = myRs.getString("nic");
				 String contact = myRs.getString("contact");
				 String mail = myRs.getString("mail");
				 String gender = myRs.getString("gender");
				 String job_title = myRs.getString("job_title");
				 String salary = myRs.getString("salary");
				 String department = myRs.getString("department");
				 String appointmentDate = myRs.getString("appointmentDate");
				 String address = myRs.getString("address");
				
				
				//use the emp id during construction
				theEmployee = new Employee(employeeId,empid,name,nic,contact,mail,gender,job_title,salary,department,appointmentDate,address);
			}
			else {
				throw new Exception("Could not find Employee id: " + employeeId);
			}
			
			
			return theEmployee;
		}
		finally {
			
			// clean up JDBC ojects
			close(myConn, myStmt, myRs);
			
		}
		
		
		
	}

	public Employee getviewEmployee(String theEmployeeId)throws Exception {
		
		Employee theEmployee = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int employeeId;
		
		try {
			
			
			//convert emp id to int
			employeeId = Integer.parseInt(theEmployeeId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to get selected emp
			String sql = "select * from employee where id=?";
			
			//create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, employeeId);
			
			//execute statement
			myRs = myStmt.executeQuery();
			
			//retrieve data from result row
			if (myRs.next()) {
				
				int id = myRs.getInt("id");
				 String empid = myRs.getString("empid");
				 String name = myRs.getString("name");
				 String nic = myRs.getString("nic");
				 String contact = myRs.getString("contact");
				 String mail = myRs.getString("mail");
				 String gender = myRs.getString("gender");
				 String job_title = myRs.getString("job_title");
				 String salary = myRs.getString("salary");
				 String department = myRs.getString("department");
				 String appointmentDate = myRs.getString("appointmentDate");
				 String address = myRs.getString("address");
				
				
				//use the emp id during construction
				theEmployee = new Employee(id,empid,name,nic,contact,mail,gender,job_title,salary,department,appointmentDate,address);
			}
			else {
				throw new Exception("Could not find Employee id: " + employeeId);
			}
			
			
			return theEmployee;
		}
		finally {
			
			// clean up JDBC ojects
			close(myConn, myStmt, myRs);
			
		}
		
	}

	public static void updateEmployee(Employee theEmployee) {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update employee "
					+ "set empid=?, name=?, nic=?, contact=?, mail=?, gender=?, job_title=?, salary=?, department=? appointmentDate=?, address=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theEmployee.getEmpid());
		myStmt.setString(2, theEmployee.getName());
		myStmt.setString(3, theEmployee.getNic());
		myStmt.setString(4, theEmployee.getContact());
		myStmt.setString(5, theEmployee.getMail());
		myStmt.setString(6, theEmployee.getGender());
		myStmt.setString(7, theEmployee.getJob_title());
		myStmt.setString(8, theEmployee.getSalary());
		myStmt.setString(9, theEmployee.getDepartment());
		myStmt.setString(10, theEmployee.getAppointmentDate());
		myStmt.setString(11, theEmployee.getAddress());
		myStmt.setInt(12, theEmployee.getId());
		
	
		
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

	public List<Employee> getViews() throws Exception {
		List<Employee> employees = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		 
			
			
			
			try {
				// get a connection
				myConn = dataSource.getConnection();
				
				// create sql statement
				String sql = "select * from Employee order by id  ";
				
				myStmt = myConn.createStatement();
				
				//execute query
				myRs = myStmt.executeQuery(sql);
				
				//process result set
				while(myRs.next()) {
					
					//retrieve data from result set row
					 int id = myRs.getInt("id");
					 String empid = myRs.getString("empid");
					 String name = myRs.getString("name");
					 String address = myRs.getString("address");
					 String nic = myRs.getString("nic");
					 String contact = myRs.getString("contact");
					 String mail = myRs.getString("mail");
					 String gender = myRs.getString("gender");
					 String job_title = myRs.getString("job_title");
					 String salary = myRs.getString("salary");
					 String department = myRs.getString("department");
					 String appointmentDate = myRs.getString("appointmentDate");
					
					// create new emp object
					 Employee tempEmployee = new Employee(id,empid,name,address,nic,contact,mail,gender,job_title,salary,department,appointmentDate);
					
					// add it to the list of emps
					 employees.add(tempEmployee);
				}

			return employees;
		}
	finally {
				
				//close JDBC objects
				close(myConn, myStmt, myRs);

			}
	}
	}

