package com.itp.shiftallocation;

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




@WebServlet("/ShiftAllocationServlet")
public class ShiftAllocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ShiftAllocationDbUtil shiftAllocationDbUtil;
	
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create shifts db util ... and pass in the conn pool / datasource
		try {
			shiftAllocationDbUtil = new ShiftAllocationDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}

	public ShiftAllocationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
try {
			
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing shiftss
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listShiftAllocation(request,response);
				break;
				
			case "ADD":
				addShiftAllocation(request,response);
				break;
				
			case "LOAD":
				loadShiftAllocation(request,response);
				break;
				
			case "UPDATE":
				updateShiftAllocation(request,response);
				break;
				
			case "DELETE" :
				deleteShiftAllocation(request,response);
				break;
				
			default:
				listShiftAllocation(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteShiftAllocation(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read shifts id from the form data
				String theShiftId = request.getParameter("shiftId");
				
				// delete shifts from database
				shiftAllocationDbUtil.deleteShiftAllocation(theShiftId);
				
				//send them back to the list shiftss page
				listShiftAllocation(request,response);
	}


	private void updateShiftAllocation(HttpServletRequest request, HttpServletResponse response){

		//read shifts info from form data
		String ids = request.getParameter("shiftId");
		int id = Integer.parseInt(ids);
		String empid = request.getParameter("empid");
		
		String s_time = request.getParameter("s_time");
		String dept = request.getParameter("dept");
		
		
		//create a new shifts object
		ShiftAllocation theShift = new ShiftAllocation(id, empid,s_time,dept);
		
		
		try {
			
			//perform update on database
			shiftAllocationDbUtil.updateShiftAllocation(theShift);
			
			//send them back to the "list shiftss" page
			listShiftAllocation(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadShiftAllocation(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read shifts id from form data
				String theShiftId = request.getParameter("shiftId");
				
				//get shifts from database (db util)
				ShiftAllocation theShift = shiftAllocationDbUtil.getShiftAllocation(theShiftId);
				
				//place shifts in the request atrribute
				request.setAttribute("THE_SHIFT", theShift);
				
				// send to jsp page: update-shifts-form.jsp
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/update-shift-form.jsp");
				dispatcher.forward(request, response);
		
	}


	private void addShiftAllocation(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read shifts info from form data
		String empid = request.getParameter("empid");
		
		String s_time = request.getParameter("s_time");
		String dept = request.getParameter("dept");
			
		
		// create a new shifts object
	ShiftAllocation theShift = new ShiftAllocation(empid,s_time,dept);
		
		// add the shifts to the database
		shiftAllocationDbUtil.addShiftAllocation(theShift);
		
		//send back to main page (shifts list)
		listShiftAllocation(request,response);
	}

	private void listShiftAllocation(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get shiftss from db util
		List<ShiftAllocation> shift = shiftAllocationDbUtil.getShiftAllocation();
		
		//add shiftss to the request
		request.setAttribute("SHIFT_LIST", shift);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListShifts.jsp");
		dispatcher.forward(request, response);
	}
	

}
