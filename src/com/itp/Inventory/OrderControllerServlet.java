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
 * Servlet implementation class OrderControllerServlet
 */
@WebServlet("/OrderControllerServlet")
public class OrderControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrderDbUtil orderDbUtil;
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create order db util ... and pass in the conn pool / datasource
		try {
			orderDbUtil = new OrderDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}
    public OrderControllerServlet() {
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
			
			//if the command is missing, then default to listing orders
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listOrder(request,response);
				break;
				
			case "ADD":
				addOrder(request,response);
				break;
				
			case "LOAD":
				loadOrder(request,response);
				break;
				
			case "UPDATE":
				updateOrder(request,response);
				break;
				
			case "DELETE" :
				deleteOrder(request,response);
				break;
				
			default:
				listOrder(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read order id from the form data
				String theOrderId = request.getParameter("orderId");
				
				// delete order from database
				orderDbUtil.deleteOrder(theOrderId);
				
				//send them back to the list orders page
				listOrder(request,response);
	}


	private void updateOrder(HttpServletRequest request, HttpServletResponse response){

		//read order info from form data
		String ids = request.getParameter("orderId");
		int id = Integer.parseInt(ids);
		String date = request.getParameter("date");
		String staffid = request.getParameter("staffid");
		String department = request.getParameter("department");
		String description = request.getParameter("description");
		float quantity = Float.parseFloat(request.getParameter("quantity"));
		float unit = Float.parseFloat(request.getParameter("unit"));
		float total = Float.parseFloat(request.getParameter("total"));
		String type = request.getParameter("type");
		
		//create a new order object
		Order theOrder = new Order(id, date,staffid,department,description,quantity,unit,total,type);
		
		
try {
			
			//perform update on database
			OrderDbUtil.updateOrder(theOrder);
			
			//send them back to the "list subjects" page
			listOrder(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read order id from form data
		String theOrderId = request.getParameter("orderId");
		
		//get order from database (db util)
		Order theOrder = orderDbUtil.getOrder(theOrderId);
		
		//place order in the request atrribute
		request.setAttribute("THE_ORDER", theOrder);
		
		// send to jsp page: update-order-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-order-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addOrder(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read order info from form data
		String date = request.getParameter("date");
		String staffid = request.getParameter("staffid");
		String department = request.getParameter("department");
		String description = request.getParameter("description");
		float quantity = Float.parseFloat(request.getParameter("quantity"));
		float unit = Float.parseFloat(request.getParameter("unit"));
		float total = Float.parseFloat(request.getParameter("total"));
		String type = request.getParameter("type");	
		
		// create a new order object
		Order theOrder = new Order(date,staffid,department,description,quantity,unit,total,type);
		
		// add the order to the database
		orderDbUtil.addOrder(theOrder);
		
		//send back to main page (order list)
		listOrder(request,response);
	}

	private void listOrder(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get orders from db util
		List<Order> order = orderDbUtil.getOrder();
		
		//add orders to the request
		request.setAttribute("ORDER_LIST", order);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-order.jsp");
		dispatcher.forward(request, response);
	}
	

	

}
