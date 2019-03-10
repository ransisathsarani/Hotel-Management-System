package com.itp.events;


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
 * Servlet implementation class enquiriesControllerServlet
 */
@WebServlet("/EnquiriesControllerServlet")
public class EnquiriesControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EnquiriesDbUtil enquiriesDbUtil;
	
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create enquiries db util ... and pass in the conn pool / datasource
		try {
			enquiriesDbUtil = new EnquiriesDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing enquiriess
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listEnquiriess(request,response);
				break;
				
			case "ADD":
				addEnquiries(request,response);
				break;
				
			case "DELETE" :
				deleteEnquiries(request,response);
				break;
				
			default:
				listEnquiriess(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteEnquiries(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read enquiries id from the form data
				String theEnquiriesId = request.getParameter("enquiriesId");
				
				// delete enquiries from database
				enquiriesDbUtil.deleteEnquiries(theEnquiriesId);
				
				//send them back to the list enquiriess page
				listEnquiriess(request,response);
	}




	private void addEnquiries(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read enquiries info from form data
		String date = request.getParameter("date");
		String no_of_persons = request.getParameter("no_of_persons");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact_no = request.getParameter("contact_no");
		String description = request.getParameter("description");
		
		// create a new enquiries object
		Enquiries theEnquiries = new Enquiries(date, no_of_persons, name, email, contact_no, description);
		
		// add the enquiries to the database
		enquiriesDbUtil.addEnquiries(theEnquiries);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-enquiries-form.jsp");
		dispatcher.forward(request, response);
		
		//send back to main page (enquiries list)
		listEnquiriess(request,response);
		
		
	}

	private void listEnquiriess(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get enquiriess from db util
		List<Enquiries> enquiriess = enquiriesDbUtil.getEnquiriess();
		
		//add enquiriess to the request
		request.setAttribute("ENQUIRIES_LIST", enquiriess);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-enquiriess.jsp");
		dispatcher.forward(request, response);
	}

}
