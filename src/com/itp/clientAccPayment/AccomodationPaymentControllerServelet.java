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
 * Servlet implementation class AccommodationPaymentcontrollerServelet
 */
@WebServlet("/AccomodationPaymentControllerServelet")
public class AccomodationPaymentControllerServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	
     
	
	
private AccomodationPaymentDbUtil accomodationPaymentDbUtil;
	
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		
		try {
			accomodationPaymentDbUtil = new AccomodationPaymentDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}

    public AccomodationPaymentControllerServelet() {
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
					listAccPay(request,response);
					break;
					
				case "ADD":
					addAccPay(request,response);
					break;
					
				case "LOAD":
					loadAccPay(request,response);
					break;
					
				case "UPDATE":
					updateAccPay(request,response);
					break;
					
				case "DELETE" :
					deleteAccPay(request,response);
					break;
					
				case "SEARCHR" :
					loadAccReservation(request,response);
					break;
					
				default:
					listAccPay(request,response);
					
				}

			} 
			catch (Exception exc) {
				throw new ServletException(exc);
			}
			
		}


		
		private void loadAccReservation(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
			
			//read id from form data
			String theReservationId = request.getParameter("reserveId");
			
			//get details from the database(db util)
			Accommodation_payments theReservation = AccomodationPaymentDbUtil.getReservationInfo(theReservationId);
			
			//place details in the request attribute
			request.setAttribute("THE_RESERVATION_INFO", theReservation);
			
			//send to jsp page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Add-Accomodation_payment.jsp");
			dispatcher.forward(request, response);
			
		
	}

		private void deleteAccPay(HttpServletRequest request, HttpServletResponse response) throws Exception {

					//read teacher id from the form data
					String theAccPayId = request.getParameter("accPayId");
					
					// delete teacher from database
					AccomodationPaymentDbUtil.deleteAccPay(theAccPayId);
					
					//send them back to the list teachers page
					listAccPay(request,response);
		}


		private void updateAccPay(HttpServletRequest request, HttpServletResponse response){

			//read teacher info from form data
			String ids = request.getParameter("accPayId");
			int id = Integer.parseInt(ids);
			String reserveId = request.getParameter("reserveId");
			String date = request.getParameter("date");
			String RID = request.getParameter("RID");
			String category = request.getParameter("category");

			float days = Float.parseFloat(request.getParameter("days"));
			float advance= Float.parseFloat(request.getParameter("advance"));
			float restaurant = Float.parseFloat(request.getParameter("restaurant"));
			float total = Float.parseFloat(request.getParameter("total"));
			
			//create a new teacher object
			Accommodation_payments theAccPay = new Accommodation_payments(id, reserveId,date ,RID,category,days,advance,restaurant,total);
			
			
			try {
				
				//perform update on database
				AccomodationPaymentDbUtil.updateAccPay(theAccPay);
				
				//send them back to the "list teachers" page
				listAccPay(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}


		private void loadAccPay(HttpServletRequest request, HttpServletResponse response) throws Exception {

			//read teacher id from form data
			String theAccPayId = request.getParameter("accPayId");
			
			//get teacher from database (db util)
			Accommodation_payments theAccPay = AccomodationPaymentDbUtil.getAccPay(theAccPayId);
			
			//place teacher in the request atrribute
			request.setAttribute("THE_ACCPAY", theAccPay);
			
			// send to jsp page: update-teacher-form.jsp
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/update-AccomodationPayment-form.jsp");
			dispatcher.forward(request, response);
			
		}


		private void addAccPay(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			// read teacher info from form data
			
		
			String reserveId = request.getParameter("reserveId");
			String date = request.getParameter("date");
			String RID = request.getParameter("RID");
			String category = request.getParameter("category");

			float days = Float.parseFloat(request.getParameter("days"));
			float advance= Float.parseFloat(request.getParameter("advance"));
			float restaurant = Float.parseFloat(request.getParameter("restaurant"));
			float total = Float.parseFloat(request.getParameter("total"));
			
			// create a new teacher object
			Accommodation_payments theAccPay = new Accommodation_payments(reserveId,date,RID,category,days,advance,restaurant,total);
			
			// add the teacher to the database
			AccomodationPaymentDbUtil.addAccPay(theAccPay);
			
			//send back to main page (teacher list)
			listAccPay(request,response);
		}

		private void listAccPay(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			// get teachers from db util
			List<Accommodation_payments> con = AccomodationPaymentDbUtil.getAccPay();
			
			//add teachers to the request
			request.setAttribute("ACCPAY_LIST", con);
			
			//send to JSP page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-AccomodationPayments.jsp");
			dispatcher.forward(request, response);
		}
		

}
