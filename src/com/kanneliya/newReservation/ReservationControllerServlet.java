package com.kanneliya.newReservation;

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

import com.itp.room.RoomControllerServlet;


@WebServlet("/ReservationControllerServlet")
public class ReservationControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ReservationDbUtil reservationDbUtil;
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create reservation db util ... and pass in the conn pool / datasource
		try {
			reservationDbUtil = new ReservationDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}
	
    public ReservationControllerServlet() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

try {
			
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing reservations
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listReservation(request,response);
				break;
				
			case "ADD":
				addReservation(request,response);
				break;
				
			case "LOAD":
				loadReservation(request,response);
				break;
				
			case "UPDATE":
				updateReservation(request,response);
				break;
				
			case "DELETE" :
				deleteReservation(request,response);
				break;
				
			default:
				listReservation(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read reservation id from the form data
				String theReservationId = request.getParameter("reservationId");
				
				// delete reservation from database
				reservationDbUtil.deleteReservation(theReservationId);
				
				//send them back to the list reservations page
				listReservation(request,response);
	}


	private void updateReservation(HttpServletRequest request, HttpServletResponse response){

		//read reservation info from form data
		String ids = request.getParameter("reservationId");
		int id = Integer.parseInt(ids);
		String reserveID = request.getParameter("reserveID");
		String RID = request.getParameter("RID");
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String checkIn = request.getParameter("checkIn");
		String checkOut = request.getParameter("checkOut");
		String days = request.getParameter("days");
		String adults = request.getParameter("adults");
		String children = request.getParameter("children");
		String advance = request.getParameter("advance");
		String slipNo = request.getParameter("slipNo");
		 
		//create a new reservation object
		NewReservation theReservation = new NewReservation(id,reserveID,RID,category,name,phone,email, checkIn,checkOut,days,adults,children,advance,slipNo);
		
		
		try {
			
			//perform update on database
			reservationDbUtil.updateReservation(theReservation);
			
			//send them back to the "list reservations" page
			listReservation(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read reservation id from form data
		String theReservationId = request.getParameter("reservationId");
		
		//get reservation from database (db util)
		NewReservation theReservation = reservationDbUtil.getReservation(theReservationId);
		
		//place reservation in the request atrribute
		request.setAttribute("THE_RESERVATION", theReservation);
		
		// send to jsp page: update-reservation-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-reservation-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addReservation(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read reservation info from form data
		String reserveID = request.getParameter("reserveID");
		String RID = request.getParameter("RID");
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String checkIn = request.getParameter("checkIn");
		String checkOut = request.getParameter("checkOut");
		String days = request.getParameter("days");
		String adults = request.getParameter("adults");
		String children = request.getParameter("children");
		String advance = request.getParameter("advance");	
		String slipNo = request.getParameter("slipNo");
		 
		
		//RoomControllerServlet a = new RoomControllerServlet();
		//String RID = a.getSingleRoomByType();
		
		// create a new reservation object
		NewReservation theReservation = new NewReservation(reserveID,RID,category,name,phone, email,checkIn,checkOut,days,adults,children,advance,slipNo);
		
		// add the reservation to the database
		reservationDbUtil.addReservation(theReservation);
		
		reservationDbUtil.updateStatus(request.getParameter("RID"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ManageAccomodationBooking.jsp");
		dispatcher.forward(request, response);
		
		//send back to main page (reservation list)
		listReservation(request,response);
		
	
	}

	private void listReservation(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get reservations from db util
		List<NewReservation> con = reservationDbUtil.getReservation();
		
		//add reservations to the request
		request.setAttribute("RESERVATION_LIST", con);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-reservations.jsp");
		dispatcher.forward(request, response);
	}
	
 
	
}
		
		