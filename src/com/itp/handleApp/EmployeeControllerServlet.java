package com.itp.handleApp;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EmployeeControllerServlet
 */
@WebServlet("/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeDbUtil employeeDbUtil;
	 
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
	
		try {
			
			employeeDbUtil = new EmployeeDbUtil(dataSource);
		}
		catch (Exception exc){
			System.out.println(exc);
			throw new ServletException(exc);
		}
	}


	
   public EmployeeControllerServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
try {
			

			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing emps
			if(theCommand == null) {
				theCommand = "LIST";
				
			}
			//route to the appropriate method
			switch(theCommand) {
			
			case"LIST":
			listEmployees(request, response);
			break;
			
			case"ADD":
			addEmployee(request, response);
			break;
			
			case"LOAD":
			loadEmployee(request, response);
			break;
			
			case"VIEW":
			viewEmployee(request, response);
			break;
			
			
			default:
			listEmployees(request,response);
				}
			}
			
			catch (Exception exc) {
				throw new ServletException(exc);
			}
	}




/*private void updateviewEmployee(HttpServletRequest request, HttpServletResponse response) {
	
	String ids =request.getParameter("employeeId");
	int id = Integer.parseInt(ids);
	String empid = request.getParameter("empid");
	String name = request.getParameter("name");
	String nic = request.getParameter("nic");
	String contact = request.getParameter("contact");
	String mail = request.getParameter("mail");
	String gender = request.getParameter("gender");
	String job_title = request.getParameter("job_title");
	String salary = request.getParameter("salary");
	String department = request.getParameter("department");
	String appointmentDate = request.getParameter("appointmentDate");
	String address = request.getParameter("address");
	
	Employee theEmployee = new Employee(id,empid,name,nic,contact,mail,gender,job_title,salary,department,appointmentDate,address);
	try {
		EmployeeDbUtil.updateEmployee(theEmployee);
	
	listEmployees(request,response);
	}catch(Exception e) {
		e.printStackTrace();
	}*/
	
		
	//}



private void viewEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
	//read emp id from form data
		String theEmployeeId = request.getParameter("employeeId");
		
		//get emp from database (db util)
		Employee theEmployee = employeeDbUtil.getviewEmployee(theEmployeeId);
		
		//place emp in the request atrribute
		request.setAttribute("THE_EMPLOYEE_1", theEmployee);
		
		// send to jsp page: update-emp-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/view-employee-form.jsp");
		dispatcher.forward(request, response);
	}



private void loadEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	//read emp id from form data
	String theEmployeeId = request.getParameter("employeeId");
	
	//get emp from database (db util)
	Employee theEmployee = employeeDbUtil.getEmployee(theEmployeeId);
	
	//place emp in the request atrribute
	request.setAttribute("THE_EMPLOYEE", theEmployee);
	
	// send to jsp page: update-emp-form.jsp
	RequestDispatcher dispatcher = 
			request.getRequestDispatcher("/update-employee-form.jsp");
	dispatcher.forward(request, response);
	
		
	}


private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
	String empid = request.getParameter("empid");
	String name = request.getParameter("name");
	String nic = request.getParameter("nic");
	String contact = request.getParameter("contact");
	String mail = request.getParameter("mail");
	String gender = request.getParameter("gender");
	String job_title = request.getParameter("job_title");
	String salary = request.getParameter("salary");
	String department = request.getParameter("department");
	String appointmentDate = request.getParameter("appointmentDate");
	String address = request.getParameter("address");
	
	// create a new emp object
	Employee theEmployee = new Employee (empid,name,nic,contact,mail,gender,job_title,salary,department,appointmentDate,address);
	
	// add the emp to the database
	employeeDbUtil.addEmployee(theEmployee);
	
	//send back to main page (emp list)
	listEmployees(request,response);
	
	}


private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
	List<Employee> employees = employeeDbUtil.getEmployees();
	
	//add emps to the request
	request.setAttribute("EMPLOYEE_LIST", employees);
	
	//send to JSP page
	RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employee.jsp");
	dispatcher.forward(request, response);
}

	
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
	//}

}
