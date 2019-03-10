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
 * Servlet implementation class ApplicationControllerServlet
 */
@WebServlet("/ApplicationControllerServlet")
public class ApplicationControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private ApplicationDbUtil applicationDbUtil;
	 
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create application db util ... and pass in the conn pool / datasource
		try {
			
			applicationDbUtil = new ApplicationDbUtil(dataSource);
		}
		catch (Exception exc){
			System.out.println(exc);
			throw new ServletException(exc);
		}
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
   // public ApplicationControllerServlet() {
        //super();
        // TODO Auto-generated constructor stub
   // }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");
			
			if(theCommand == null) {
			theCommand = "LIST";
			}
			
			switch(theCommand) {
			
			case"LIST":
				listApplications(request, response);
				break;
				
				case"ADD":
				addApplication(request, response);
				break;
				
				default:
					listApplications(request,response);
					}
				}
				
				catch (Exception exc) {
					throw new ServletException(exc);
				}
	}
	private void addApplication(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		// read application info from form data
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String nic = request.getParameter("nic");
		String contact = request.getParameter("contact");
		String mail = request.getParameter("mail");
		String gender = request.getParameter("gender");
		String edu_qualifi = request.getParameter("edu_qualifi");
		String job_exp = request.getParameter("job_exp");
		
		
		// create a new application object
		Application theApplication = new Application  (name,address,nic,contact,mail,gender,edu_qualifi,job_exp);
		
		// add the application to the database
		applicationDbUtil.addApplication(theApplication);
		
		//send back to main page (application list)
		listApplications(request,response);
		
		
	}

	private void listApplications(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Application> applications = applicationDbUtil.getApplications();
		
		request.setAttribute("APPLICATION_LIST", applications);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Application.jsp");
		dispatcher.forward(request, response);
		
		
	}

	}
