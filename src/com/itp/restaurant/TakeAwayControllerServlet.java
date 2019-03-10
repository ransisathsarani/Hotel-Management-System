package com.itp.restaurant;
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
 * Servlet implementation class Level2ControllerServlet
 */
@WebServlet("/TakeAwayControllerServlet")
public class TakeAwayControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TakeAwayDbUtil takeAwayDbUtil;
	
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create enquiries db util ... and pass in the conn pool / datasource
		try {
			takeAwayDbUtil = new TakeAwayDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing level2s
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listTakeAways(request,response);
				break;
				
			case "ADD":
				addTakeAway(request,response);
				break;
				
			case "LOAD":
				loadTakeAway(request,response);
				break;
				
			case "UPDATE":
				updateTakeAway(request,response);
				break;
				
			case "DELETE" :
				deleteTakeAway(request,response);
				break;
				
			default:
				listTakeAways(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteTakeAway(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read level2 id from the form data
				String theTakeAwayId = request.getParameter("takeAwayId");
				
				// delete level2 from database
				takeAwayDbUtil.deleteTakeAway(theTakeAwayId);
				
				//send them back to the list level2s page
				listTakeAways(request,response);
	}


	private void updateTakeAway(HttpServletRequest request, HttpServletResponse response){

		//read level2 info from form data
		String ids = request.getParameter("takeAwayId");
		int id = Integer.parseInt(ids);
		
		String date = request.getParameter("date");
		String name = request.getParameter("name");
		String contactNumber = request.getParameter("contactNumber");
		String numberOfPackets = request.getParameter("numberOfPackets");
		String email = request.getParameter("email");
		String menuID = request.getParameter("menuID");
		
		
		
		//create a new level2 object
		TakeAway theTakeAway = new TakeAway(id, date, name, contactNumber, numberOfPackets, email, menuID);
		
		
		try {
			
			//perform update on database
			TakeAwayDbUtil.updateTakeAway(theTakeAway);
			
			//send them back to the "list level2s" page
			listTakeAways(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadTakeAway(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read level2 id from form data
		String theTakeAwayId = request.getParameter("takeAwayId");
		
		//get level2 from database (db util)
		TakeAway theTakeAway = takeAwayDbUtil.getTakeAway(theTakeAwayId);
		
		//place level2 in the request atrribute
		request.setAttribute("THE_TAKEAWAY", theTakeAway);
		
		// send to jsp page: update-level2-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/updateTakeAway.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addTakeAway(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read level2 info from form data
		String date = request.getParameter("date");
		String name = request.getParameter("name");
		String numberOfPackets = request.getParameter("numberOfPackets");
		String contactNumber = request.getParameter("contactNumber");
		
		String email = request.getParameter("email");
		String menuID = request.getParameter("menuID");
		
		
		
		// create a new level2 object
		TakeAway theTakeAway = new TakeAway(date, name, numberOfPackets,contactNumber, email, menuID);
		
		// add the level2 to the database
		takeAwayDbUtil.addTakeAway(theTakeAway);
		
		//send back to main page (level2 list)
		listTakeAways(request,response);
	}
	

	private void listTakeAways(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get level2s from db util
		List<TakeAway> takeAway = takeAwayDbUtil.getTakeAway();
		
		//add level2s to the request
		request.setAttribute("TAKEAWAY_LIST", takeAway);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-takeAways.jsp");
		dispatcher.forward(request, response);
	}
}	