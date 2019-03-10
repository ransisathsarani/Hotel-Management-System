package com.itp.events;

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
 * Servlet implementation class eventControllerServlet
 */
@WebServlet("/EventControllerServlet")
public class EventControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EventDbUtil eventDbUtil;
	
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create enquiries db util ... and pass in the conn pool / datasource
		try {
			eventDbUtil = new EventDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing events
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listEvents(request,response);
				break;
				
			case "ADD":
				addEvent(request,response);
				break;
				
			case "LOAD":
				loadEvent(request,response);
				break;
				
			case "UPDATE":
				updateEvent(request,response);
				break;
				
			case "DELETE" :
				deleteEvent(request,response);
				break;
				
			case "UPDATE_BILL":
				updateEventBill(request,response);
				break;
				
			case "BILL":
				loadEventBill(request,response);
				break;
				
			case "UPDATE_MENU":
				updateEventMenu(request,response);
				break;
				
			case "MENU":
				loadEventMenu(request,response);
				break;
				
			default:
				listEvents(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}



	private void loadEventMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//read event id from form data
		String theEventId = request.getParameter("eventId");
		
		//get event from database (db util)
		Event theEvent = eventDbUtil.getEventMenu(theEventId);
		
		//place event in the request atrribute
		request.setAttribute("THE_EVENT", theEvent);
		
		// send to jsp page: update-event-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-event-menu-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void updateEventMenu(HttpServletRequest request, HttpServletResponse response) {
		String ids = request.getParameter("eventId");
		int id = Integer.parseInt(ids);
		String appetizer = request.getParameter("appetizer");
		String soup = request.getParameter("soup");
		String rice1 = request.getParameter("rice1");
		String rice2 = request.getParameter("rice2");
		String noodles = request.getParameter("noodles");
		String fish = request.getParameter("fish");
		String chicken = request.getParameter("chicken");
		String vegetable1 = request.getParameter("vegetable1");
		String vegetable2 = request.getParameter("vegetable2");
		String vegetable3 = request.getParameter("vegetable3");
		String dessert1 = request.getParameter("dessert1");
		String dessert2 = request.getParameter("dessert2");
		
		Event theEvent = new Event(id, appetizer, soup, rice1, rice2, noodles, fish, chicken, vegetable1, vegetable2, vegetable3, dessert1, dessert2);
		
		try {
			
			//perform update on database
			eventDbUtil.updateEventMenu(theEvent);
			
			//send them back to the "list events" page
			listEvents(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void loadEventBill(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
				//read event id from form data
				String theEventId = request.getParameter("eventId");
				
				//get event from database (db util)
				Event theEvent = eventDbUtil.getEventBill(theEventId);
				
				//place event in the request atrribute
				request.setAttribute("THE_EVENT", theEvent);
				
				// send to jsp page: update-event-form.jsp
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/update-event-bill-form.jsp");
				dispatcher.forward(request, response);
		
	}


	private void updateEventBill(HttpServletRequest request, HttpServletResponse response) {

		String ids = request.getParameter("eventId");
		int id = Integer.parseInt(ids);
		int no_of_people = Integer.parseInt(request.getParameter("no_of_people"));
		double resort_charges = Double.parseDouble(request.getParameter("resort_charges"));
		double accumulative_tax = Double.parseDouble(request.getParameter("accumulative_tax"));
		double total = Double.parseDouble(request.getParameter("total"));
		double prepayment = Double.parseDouble(request.getParameter("prepayment"));
		String payment_status = request.getParameter("payment_status");
		String payment_date = request.getParameter("payment_date");
		
		Event theEvent = new Event(id, no_of_people, resort_charges, accumulative_tax, total, prepayment, payment_status, payment_date);
		
		try {
			
			//perform update on database
			eventDbUtil.updateEventBill(theEvent);
			
			//send them back to the "list events" page
			listEvents(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	private void deleteEvent(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read event id from the form data
				String theEventId = request.getParameter("eventId");
				
				// delete event from database
				eventDbUtil.deleteEvent(theEventId);
				
				//send them back to the list events page
				listEvents(request,response);
	}


	private void updateEvent(HttpServletRequest request, HttpServletResponse response){

		//read event info from form data
		String ids = request.getParameter("eventId");
		int id = Integer.parseInt(ids);
		String date = request.getParameter("date");
		String type = request.getParameter("type");
		String nic = request.getParameter("nic");
		String client_first_name = request.getParameter("client_first_name");
		String client_last_name = request.getParameter("client_last_name");
		String address = request.getParameter("address");
		String post_code = request.getParameter("post_code");
		String tel_no = request.getParameter("tel_no");
		String mobile_no = request.getParameter("mobile_no");
		String email = request.getParameter("email");
		int no_of_people = Integer.parseInt(request.getParameter("no_of_people"));
		String special_requests = request.getParameter("special_requests");
		
		
		
		//create a new event object
		Event theEvent = new Event(id, date, type, nic, client_first_name, client_last_name, address, post_code, tel_no, mobile_no, email, no_of_people, special_requests);
		
		
		try {
			
			//perform update on database
			eventDbUtil.updateEvent(theEvent);
			
			//send them back to the "list events" page
			listEvents(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadEvent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read event id from form data
		String theEventId = request.getParameter("eventId");
		
		//get event from database (db util)
		Event theEvent = eventDbUtil.getEvent(theEventId);
		
		//place event in the request atrribute
		request.setAttribute("THE_EVENT", theEvent);
		
		// send to jsp page: update-event-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-event-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addEvent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read event info from form data
		String date = request.getParameter("date");
		String type = request.getParameter("type");
		String nic = request.getParameter("nic");
		String client_first_name = request.getParameter("client_first_name");
		String client_last_name = request.getParameter("client_last_name");
		String address = request.getParameter("address");
		String post_code = request.getParameter("post_code");
		String tel_no = request.getParameter("tel_no");
		String mobile_no = request.getParameter("mobile_no");
		String email = request.getParameter("email");
		int no_of_people = Integer.parseInt(request.getParameter("no_of_people"));
		String special_requests = request.getParameter("special_requests");
		
		
		// create a new event object
		Event theEvent = new Event(date, type, nic, client_first_name, client_last_name, address, post_code, tel_no, mobile_no, email, no_of_people, special_requests);
		
		// add the event to the database
		eventDbUtil.addEvent(theEvent);
		
		//send back to main page (event list)
		listEvents(request,response);
	}

	private void listEvents(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get events from db util
		List<Event> events = eventDbUtil.getEvents();
		
		//add events to the request
		request.setAttribute("EVENT_LIST", events);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-events.jsp");
		dispatcher.forward(request, response);
	}

}
