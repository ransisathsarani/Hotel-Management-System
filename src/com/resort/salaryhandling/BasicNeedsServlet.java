package com.resort.salaryhandling;

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

//import com.itp.Inventory.Inventory;
//import com.itp.Inventory.InventoryDbUtil;






/**
 * Servlet implementation class VendorPaymentControllerServlet
 */
@WebServlet("/BasicNeedsServlet")
public class BasicNeedsServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
private BasicNeedsDbUtil basicNeedsDbUtil;
@Resource(name="jdbc/kfr")
private DataSource dataSource;

@Override
public void init() throws ServletException {
	super.init();
	
	//create basic needs db util ... and pass in the conn pool / datasource
	try {
		basicNeedsDbUtil = new BasicNeedsDbUtil(dataSource);
	}
	catch (Exception exc){
		throw new ServletException(exc);
	}
}
public BasicNeedsServlet() {
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
			
			//if the command is missing, then default to listing basic needss
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listBasicNeeds(request,response);
				break;
				
			case "ADD":
				addBasicNeeds(request,response);
				break;
				
			case "LOAD":
				loadBasicNeeds(request,response);
				break;
				
			case "UPDATE":
				updateBasicNeeds(request,response);
				break;
				
			case "DELETE" :
				deleteBasicNeeds(request,response);
				break;
				
			default:
				listBasicNeeds(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteBasicNeeds(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read basic needs id from the form data
				String theBasicNeedsId = request.getParameter("basicNeedsId");
				
				// delete basic needs from database
				BasicNeedsDbUtil.deleteBasicNeeds(theBasicNeedsId);
				
				//send them back to the list basic needss page
				listBasicNeeds(request,response);
	}


	private void updateBasicNeeds(HttpServletRequest request, HttpServletResponse response){

		//read basic needs info from form data
		String ids = request.getParameter("basicNeedsId");
		int id = Integer.parseInt(ids);
		int inquiry = Integer.parseInt(request.getParameter("inquiry"));
		String empid = request.getParameter("empid");
		String iDate = request.getParameter("iDate");
		String complaint = request.getParameter("complaint");
		String department =request.getParameter("department");
		
		
		
		//create a new basic needs object
		BasicNeeds theBasicNeeds = new BasicNeeds(id, inquiry,empid,iDate,complaint,department);
		
		
		try {
			
			//perform update on database
			BasicNeedsDbUtil.updateBasicNeeds(theBasicNeeds);
			
			//send them back to the "list basic needss" page
			listBasicNeeds(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadBasicNeeds(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read basic needs id from form data
		String theBasicNeedsId = request.getParameter("basicNeedsId");
		
		//get basic needs from database (db util)
		BasicNeeds theBasicNeeds = BasicNeedsDbUtil.getBasicNeeds(theBasicNeedsId);
		
		//place basic needs in the request atrribute
		request.setAttribute("BASIC_NEEDS", theBasicNeeds);
		
		// send to jsp page: update-inventory-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/UpdateBasicNeeds.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addBasicNeeds(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read basic needs info from form data
		int inquiry = Integer.parseInt(request.getParameter("inquiry"));
		String empid = request.getParameter("empid");
		String iDate = request.getParameter("iDate");
		String complaint = request.getParameter("complaint");
		String department =request.getParameter("department");
		
		System.out.println("empid:" + empid);
		// create a new basic needs object
		BasicNeeds theBasicNeeds = new BasicNeeds(inquiry,empid,iDate,complaint,department);
		
		// add the basic needs to the database
		BasicNeedsDbUtil.addBasicNeeds(theBasicNeeds);
		
		//send back to main page (basic needs list)
		listBasicNeeds(request,response);
	}

	private void listBasicNeeds(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get basic needss from db util
		List<BasicNeeds> con = BasicNeedsDbUtil.getBasicNeeds();
		
		//add basic needss to the request
		request.setAttribute("BASICNEEDS_LIST", con);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListBasicNeeds.jsp");
		dispatcher.forward(request, response);
	}
	



	
		
	}


