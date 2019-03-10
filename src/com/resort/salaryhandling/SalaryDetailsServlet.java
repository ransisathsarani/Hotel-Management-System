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
@WebServlet("/SalaryDetailsServlet")
public class SalaryDetailsServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
private SalaryDetailsDbUtil salaryDetailsDbUtil;
@Resource(name="jdbc/kfr")
private DataSource dataSource;

@Override
public void init() throws ServletException {
	super.init();
	
	//create salary db util ... and pass in the conn pool / datasource
	try {
		salaryDetailsDbUtil = new SalaryDetailsDbUtil(dataSource);
	}
	catch (Exception exc){
		throw new ServletException(exc);
	}
}
	
	
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaryDetailsServlet() {
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
			
			//if the command is missing, then default to listing salarys
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listSalaryDetails(request,response);
				break;
				
			case "ADD":
				addSalaryDetails(request,response);
				break;
				
			case "LOAD":
				loadSalaryDetails(request,response);
				break;
				
			case "UPDATE":
				updateSalaryDetails(request,response);
				break;
				
			case "DELETE" :
				deleteSalaryDetails(request,response);
				break;
				
			default:
				listSalaryDetails(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteSalaryDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read salary id from the form data
				String theSalaryDetailsId = request.getParameter("salaryDetailsId");
				
				// delete salary from database
				SalaryDetailsDbUtil.deleteSalaryDetails(theSalaryDetailsId);
				
				//send them back to the list salarys page
				listSalaryDetails(request,response);
	}


	private void updateSalaryDetails(HttpServletRequest request, HttpServletResponse response){

		//read salary info from form data
		String ids = request.getParameter("salaryDetailsId");
		int id = Integer.parseInt(ids);
		String empid = request.getParameter("empid");
		String salary = request.getParameter("salary");
		String otRates = request.getParameter("otRates");
		String otHours= request.getParameter("otHours");
		String bonusPayment = request.getParameter("bonusPayment");
		String panaltyPayment = request.getParameter("panaltyPayment");
		
		
		
		//create a new salary object
		SalaryDetails theSalaryDetails = new SalaryDetails(id, empid,salary,otRates,otHours,bonusPayment,panaltyPayment);
		
		
		try {
			
			//perform update on database
			SalaryDetailsDbUtil.updateSalaryDetails(theSalaryDetails);
			
			//send them back to the "list salarys" page
			listSalaryDetails(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadSalaryDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read salary id from form data
		String theSalaryDetailsId = request.getParameter("salaryDetailsId");
		
		//get salary from database (db util)
		SalaryDetails theSalaryDetails = SalaryDetailsDbUtil.getSalaryDetails(theSalaryDetailsId);
		
		//place salary in the request atrribute
		request.setAttribute("THE_SALARYDETAILS", theSalaryDetails);
		
		// send to jsp page: update-inventory-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/UpdateSalaryDetails.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addSalaryDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read salary info from form data
		String empid = request.getParameter("empid");
		String salary = request.getParameter("salary");
		String otRates = request.getParameter("otRates");
		String otHours= request.getParameter("otHours");
		String bonusPayment = request.getParameter("bonusPayment");
		String panaltyPayment = request.getParameter("panaltyPayment");
		
		
		// create a new salary object
		SalaryDetails theSalaryDetails = new SalaryDetails(empid,salary,otRates,otHours,bonusPayment,panaltyPayment);
		
		// add the salary to the database
		SalaryDetailsDbUtil.addSalaryDetails(theSalaryDetails);
		
		//send back to main page (salary list)
		listSalaryDetails(request,response);
	}

	private void listSalaryDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get salarys from db util
		List<SalaryDetails> con = SalaryDetailsDbUtil.getSalaryDetails();
		
		//add salarys to the request
		request.setAttribute("SALARYDETAILS_LIST", con);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListSalaryDetails.jsp");
		dispatcher.forward(request, response);
	}





	


	
	



	
		
	}


