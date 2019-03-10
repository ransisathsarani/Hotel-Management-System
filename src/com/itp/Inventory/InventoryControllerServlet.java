package com.itp.Inventory;

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
 * Servlet implementation class InventoryControllerServlet
 */
@WebServlet("/InventoryControllerServlet")
public class InventoryControllerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InventoryDbUtil inventoryDbUtil;
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create stock db util ... and pass in the conn pool / datasource
		try {
			inventoryDbUtil = new InventoryDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}
    public InventoryControllerServlet() {
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
			
			//if the command is missing, then default to listing stocks
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listInventory(request,response);
				break;
				
			case "ADD":
				addInventory(request,response);
				break;
				
			case "LOAD":
				loadInventory(request,response);
				break;
				
			case "UPDATE":
				updateInventory(request,response);
				break;
				
			case "DELETE" :
				deleteInventory(request,response);
				break;
				
			default:
				listInventory(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteInventory(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read stock id from the form data
				String theInventoryId = request.getParameter("inventoryId");
				
				// delete stock from database
				InventoryDbUtil.deleteInventory(theInventoryId);
				
				//send them back to the list stocks page
				listInventory(request,response);
	}


	private void updateInventory(HttpServletRequest request, HttpServletResponse response){

		//read stock info from form data
		String ids = request.getParameter("inventoryId");
		int id = Integer.parseInt(ids);
		String date = request.getParameter("date");
		String description = request.getParameter("description");
		String vendor = request.getParameter("vendor");
		String invoiceNum = request.getParameter("invoiceNum");
		float recieved = Float.parseFloat(request.getParameter("recieved"));
		float weekCon = Float.parseFloat(request.getParameter("weekCon"));
		float current =Float.parseFloat(request.getParameter("current"));
		
		
		//create a new stock object
		Inventory theInventory = new Inventory(id, date,description,vendor,invoiceNum,recieved,weekCon,current);
		
		
		try {
			
			//perform update on database
			InventoryDbUtil.updateInventory(theInventory);
			
			//send them back to the "list stocks" page
			listInventory(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadInventory(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read stock id from form data
		String theInventoryId = request.getParameter("inventoryId");
		
		//get stock from database (db util)
		Inventory theInventory = InventoryDbUtil.getInventory(theInventoryId);
		
		//place stock in the request atrribute
		request.setAttribute("THE_INVENTORY", theInventory);
		
		// send to jsp page: update-inventory-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-inventory-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addInventory(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read stock info from form data
		String date = request.getParameter("date");
		String description = request.getParameter("description");
		String vendor = request.getParameter("vendor");
		String invoiceNum = request.getParameter("invoiceNum");
		float recieved = Float.parseFloat(request.getParameter("recieved"));
		float weekCon = Float.parseFloat(request.getParameter("weekCon"));
		float current =Float.parseFloat(request.getParameter("current"));
		
		
		// create a new stock object
		Inventory theInventory = new Inventory(date,description,vendor,invoiceNum,recieved,weekCon,current);
		
		// add the stock to the database
		InventoryDbUtil.addInventory(theInventory);
		
		//send back to main page (stock list)
		listInventory(request,response);
	}

	private void listInventory(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get stocks from db util
		List<Inventory> con = InventoryDbUtil.getInventory();
		
		//add stocks to the request
		request.setAttribute("INVENTORY_LIST", con);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-stock.jsp");
		dispatcher.forward(request, response);
	}
	
}