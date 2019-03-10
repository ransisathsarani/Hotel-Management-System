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
 * Servlet implementation class HandleControllerServlet
 */
@WebServlet("/HandleControllerServlet")
public class HandleControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandleDbUtil handleDbUtil;
	 
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
	
		try {
			
			handleDbUtil = new HandleDbUtil(dataSource);
		}
		catch (Exception exc){
			System.out.println(exc);
			throw new ServletException(exc);
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			

			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing handlings
			if(theCommand == null) {
				theCommand = "LIST";
				
			}
			//route to the appropriate method
			switch(theCommand) {
			
			case"LIST":
			listHandles(request, response);
			break;
			
			case"ADD":
			addHandle(request, response);
			break;
			
			case"LOAD":
			loadHandle(request, response);
			break;
			
			case"UPDATE":
			updateHandle(request, response);
			break;
			
			case"DELETE":
			deleteHandle(request, response);
			break;
				
			default:
			listHandles(request,response);
			}
		}
		
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	private void updateHandle(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String ids =request.getParameter("handleId");
		int id = Integer.parseInt(ids);
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String nic = request.getParameter("nic");
		String contact = request.getParameter("contact");
		String mail = request.getParameter("mail");
		String intDate = request.getParameter("intDate");
		String intVenue = request.getParameter("intVenue");
		String tDate = request.getParameter("tDate");
		String tVenue = request.getParameter("tVenue");
		
		Handle theHandle = new Handle(id,name,address,nic,contact,mail,intDate,intVenue,tDate,tVenue);
		try {
		HandleDbUtil.updateHandle(theHandle);
		
		listHandles(request,response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	private void deleteHandle(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String theHandleId = request.getParameter("handleId");
		
		handleDbUtil.deleteHandle(theHandleId);
		
		listHandles(request,response);
		
		
		
	}
	private void loadHandle(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//read handling id from form data
		String theHandleId = request.getParameter("handleId");
		
		//get handling from database (db util)
		Handle theHandle = handleDbUtil.getHandle(theHandleId);
		
		//place handling in the request atrribute
		request.setAttribute("THE_HANDLE", theHandle);
		
		// send to jsp page: update-handling-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-handle-form.jsp");
		dispatcher.forward(request, response);
		
	}
	private void addHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read handling info from form data
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String nic = request.getParameter("nic");
		String contact = request.getParameter("contact");
		String mail = request.getParameter("mail");
		String intDate = request.getParameter("intDate");
		String intVenue = request.getParameter("intVenue");
		String tDate = request.getParameter("tDate");
		String tVenue = request.getParameter("tVenue");
		
		
		// create a new handling object
		Handle theHandle = new Handle (name,address,nic,contact,mail,intDate,intVenue,tDate,tVenue);
		
		// add the handling to the database
		handleDbUtil.addHandle(theHandle);
		
		//send back to main page (handling list)
		listHandles(request,response);
		
	}
	private void listHandles(HttpServletRequest request, HttpServletResponse response)
	
	throws Exception {
		
		
		List<Handle> handles = handleDbUtil.getHandles();
		
		//add handlings to the request
		request.setAttribute("HANDLE_LIST", handles);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-handle.jsp");
		dispatcher.forward(request, response);
		
	}
}
	
	

