package com.itp.clientAccPayment;


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
 * Servlet implementation class RestaurantPaymentControllerServelet
 */
@WebServlet("/RestaurantPaymentControllerServelet")
public class RestaurantPaymentControllerServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	
private RestaurantPaymentDbUtil restaurantPaymentDbUtil;
	
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		
		try {
			restaurantPaymentDbUtil = new RestaurantPaymentDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}

    public RestaurantPaymentControllerServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
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
					listRestPay(request,response);
					break;
					
				case "ADD":
					addRestPay(request,response);
					break;
					
				case "LOAD":
					loadRestPay(request,response);
					break;
					
				case "UPDATE":
					updateRestPay(request,response);
					break;
					
				case "DELETE" :
					deleteRestPay(request,response);
					break;
					
				default:
					listRestPay(request,response);
					
				}

			} 
			catch (Exception exc) {
				throw new ServletException(exc);
			}
			
		}


		private void deleteRestPay(HttpServletRequest request, HttpServletResponse response) throws Exception {

					//read teacher id from the form data
					String theRestPayId = request.getParameter("restPayId");
					
					// delete teacher from database
					RestaurantPaymentDbUtil.deleteRestPay(theRestPayId);
					
					//send them back to the list teachers page
					listRestPay(request,response);
		}


		private void updateRestPay(HttpServletRequest request, HttpServletResponse response){

			//read teacher info from form data
			String ids = request.getParameter("id");
			int id = Integer.parseInt(ids);
			String date = request.getParameter("date");
			String reserveId = request.getParameter("reserveId");
			String mID = request.getParameter("mID");
			float total = Float.parseFloat(request.getParameter("total"));
			
			//create a new teacher object
			RestaurantPayments theRestPay = new RestaurantPayments(id,date,reserveId,mID,total);
			
			
			try {
				
				//perform update on database
				RestaurantPaymentDbUtil.updateRestPay(theRestPay);
				
				//send them back to the "list teachers" page
				listRestPay(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}


		private void loadRestPay(HttpServletRequest request, HttpServletResponse response) throws Exception {

			//read teacher id from form data
			String theRestPayId = request.getParameter("restPayId");
			
			//get teacher from database (db util)
			RestaurantPayments theRestPay = RestaurantPaymentDbUtil.getRestPay(theRestPayId);
			
			//place teacher in the request atrribute
			request.setAttribute("THE_RESTPAY", theRestPay);
			
			// send to jsp page: update-teacher-form.jsp
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/update-RestaurantPayment-form.jsp");
			dispatcher.forward(request, response);
			
		}


		private void addRestPay(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			// read teacher info from form data
			String date = request.getParameter("date");
			String reserveId = request.getParameter("reserveId");
			String mID = request.getParameter("mID");
			float total = Float.parseFloat(request.getParameter("total"));	
			
			// create a new teacher object
			RestaurantPayments theRestPay = new RestaurantPayments(date,reserveId,mID,total);
			
			// add the teacher to the database
			RestaurantPaymentDbUtil.addRestPay(theRestPay);
			
			//send back to main page (teacher list)
			listRestPay(request,response);
		}

		private void listRestPay(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			// get teachers from db util
			List<RestaurantPayments> con = RestaurantPaymentDbUtil.getRestPay();
			
			//add teachers to the request
			request.setAttribute("RESTPAY_LIST", con);
			
			//send to JSP page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-RestaurantPayments.jsp");
			dispatcher.forward(request, response);
		}
		

}
