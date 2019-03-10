package com.itp.bills;

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

import com.itp.Inventory.Inventory;
import com.itp.Inventory.InventoryDbUtil;



/**
 * Servlet implementation class BillsControllerServlet
 */
@WebServlet("/BillsControllerServlet")
public class BillsControllerServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private BillsDbUtil billsDbUtil;
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create bills db util ... and pass in the conn pool / datasource
		try {
			billsDbUtil = new BillsDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}
    public BillsControllerServlet() {
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
			
			//if the command is missing, then default to listing billss
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listBills(request,response);
				break;
				
			case "ADD":
				addBills(request,response);
				break;
				
			case "LOAD":
				loadBills(request,response);
				break;
				
			case "UPDATE":
				updateBills(request,response);
				break;
				
			case "DELETE" :
				deleteBills(request,response);
				break;
				
			default:
				listBills(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteBills(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read bills id from the form data
				String theBillId = request.getParameter("billId");
				
				// delete bills from database
				BillsDbUtil.deleteBill(theBillId);
				
				//send them back to the list billss page
				listBills(request,response);
	}


	private void updateBills(HttpServletRequest request, HttpServletResponse response){

		//read bills info from form data
		String ids = request.getParameter("billId");
		int id = Integer.parseInt(ids);
		String month = request.getParameter("month");
		float water = Float.parseFloat(request.getParameter("water"));
		float tel_1 = Float.parseFloat(request.getParameter("tel_1"));
		float tel_2 = Float.parseFloat(request.getParameter("tel_2"));
		float electricity = Float.parseFloat(request.getParameter("electricity"));
		float satellite = Float.parseFloat(request.getParameter("satellite"));
		float total =Float.parseFloat(request.getParameter("total"));
		String pay_day = request.getParameter("pay_day");
		
		//create a new bills object
		Bills theBill = new Bills(id,month,water,tel_1,tel_2,electricity,satellite,total,pay_day );
		
		
		try {
			
			//perform update on database
			BillsDbUtil.updateBills(theBill);
			
			//send them back to the "list billss" page
			listBills(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadBills(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read bills id from form data
		String theBillId = request.getParameter("billId");
		
		//get bills from database (db util)
		Bills theBill = BillsDbUtil.getBills(theBillId);
		
		//place bills in the request atrribute
		request.setAttribute("THE_BILL", theBill);
		
		// send to jsp page: update-inventory-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-bill-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addBills(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read bills info from form data
		String month = request.getParameter("month");
		float water = Float.parseFloat(request.getParameter("water"));
		float tel_1 = Float.parseFloat(request.getParameter("tel_1"));
		float tel_2 = Float.parseFloat(request.getParameter("tel_2"));
		float electricity = Float.parseFloat(request.getParameter("electricity"));
		float satellite = Float.parseFloat(request.getParameter("satellite"));
		float total =Float.parseFloat(request.getParameter("total"));
		String pay_day = request.getParameter("pay_day");
		
		
		// create a new bills object
		Bills theBill = new Bills(month,water,tel_1,tel_2,electricity,satellite,total,pay_day);
		
		// add the bills to the database
		BillsDbUtil.addBills(theBill);
		
		//send back to main page (bills list)
		listBills(request,response);
	}

	private void listBills(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get billss from db util
		List<Bills> con = BillsDbUtil.getBills();
		
		//add billss to the request
		request.setAttribute("BILL_LIST", con);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-bills.jsp");
		dispatcher.forward(request, response);
	}
}
