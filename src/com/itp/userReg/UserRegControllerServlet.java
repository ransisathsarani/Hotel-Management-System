package com.itp.userReg;

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
 * Servlet implementation class UserRegControllerServlet
 */
@WebServlet("/UserRegControllerServlet")
public class UserRegControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserRegDbUtil userRegDbUtil;
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create teacher db util ... and pass in the conn pool / datasource
		try {
			userRegDbUtil = new UserRegDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}
    public UserRegControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
try {
			
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing teachers
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listUserReg(request,response);
				break;
				
			case "ADD":
				addUserReg(request,response);
				break;
				
			case "LOAD":
				loadUserReg(request,response);
				break;
				
			case "UPDATE":
				updateUserReg(request,response);
				break;
				
			case "DELETE" :
				deleteUserReg(request,response);
				break;
				
			default:
				listUserReg(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteUserReg(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read teacher id from the form data
				String theUserRegId = request.getParameter("userRegId");
				
				// delete teacher from database
				userRegDbUtil.deleteUserReg(theUserRegId);
				
				//send them back to the list teachers page
				listUserReg(request,response);
	}


	private void updateUserReg(HttpServletRequest request, HttpServletResponse response){

		//read teacher info from form data
		String ids = request.getParameter("userRegId");
		int id = Integer.parseInt(ids);
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		
		//create a new teacher object
		UserRegistration theUserReg = new UserRegistration(id, fname,lname,address,phone,email,sex);
		
		
		try {
			
			//perform update on database
			UserRegDbUtil.updateUserReg(theUserReg);
			
			//send them back to the "list teachers" page
			listUserReg(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadUserReg(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read teacher id from form data
		String theUserRegId = request.getParameter("userRegId");
		
		//get teacher from database (db util)
		UserRegistration theUserReg = userRegDbUtil.getUserReg(theUserRegId);
		
		//place teacher in the request atrribute
		request.setAttribute("THE_USERREG", theUserReg);
		
		// send to jsp page: update-teacher-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-userRegistration-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addUserReg(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read teacher info from form data
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");		
		
		// create a new teacher object
		UserRegistration theUserReg = new UserRegistration(fname,lname,address,phone,email,sex);
		
		// add the teacher to the database
		userRegDbUtil.addUserReg(theUserReg);
		
		//send back to main page (teacher list)
		listUserReg(request,response);
	}

	private void listUserReg(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get teachers from db util
		List<UserRegistration> con = userRegDbUtil.getUserReg();
		
		//add teachers to the request
		request.setAttribute("USERREG_LIST", con);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-userReg.jsp");
		dispatcher.forward(request, response);
	}
	


}
