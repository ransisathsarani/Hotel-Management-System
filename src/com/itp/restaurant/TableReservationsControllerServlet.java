package com.itp.restaurant;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class TableReservation
 */
@WebServlet("/TableReservationControllerServlet")
public class TableReservationsControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TableReservationDbUtil tableReservationDbUtil;
	private DinnerTableUtil dinnerTableUtil;

	@Resource(name = "jdbc/kfr")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		// create TableReservation db util ... and pass in the conn pool / datasource
		try {
			tableReservationDbUtil = new TableReservationDbUtil(dataSource);
			dinnerTableUtil = new DinnerTableUtil(dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	public TableReservationsControllerServlet() {
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

			// read the "command" parameter
			String theCommand = request.getParameter("command");

			// if the command is missing, then default to listing teachers
			if (theCommand == null) {
				theCommand = "LIST";
			}

			// route to the appropriate method
			switch (theCommand) {

			case "LIST":
				listTableReservations(request, response);
				break;

			case "ADD":
				loadTableReservations_ADD(request, response);
				break;

			case "LOAD":
				loadTableReservations(request, response);
				break;

			case "UPDATE_GET":
				updateTableReservations_GET(request, response);
				break;

			case "DELETE":
				deleteTableReservations(request, response);
				break;

			default:
				listTableReservations(request, response);

			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			// read the "command" parameter
			String theCommand = request.getParameter("command");

			// if the command is missing, then default to listing teachers
			if (theCommand == null) {
				theCommand = "LIST_POST";
			}

			// route to the appropriate method
			switch (theCommand) {

			case "LIST_POST":
				listTableReservations(request, response);
				break;

			case "ADD_POST":
				addTableReservations(request, response);
				break;

			case "LOAD_POST":
				loadTableReservations(request, response);
				break;

			case "UPDATE_POST":
				updateTableReservations(request, response);
				break;

			case "DELETE_POST":
				deleteTableReservations(request, response);
				break;

			default:
				listTableReservations(request, response);

			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void updateTableReservations_GET(HttpServletRequest request, HttpServletResponse response) {

		int theTableReservationId = Integer.parseInt((request.getParameter("tableReservationId")));
		
		try {
			TableReservation tableReservation = tableReservationDbUtil.getTableReservation(theTableReservationId);
			
			// add teachers to the request
			request.setAttribute("TABLERESERVATION", tableReservation);

			// send to JSP page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/update-tableReservation.jsp");
			dispatcher.forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteTableReservations(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read TableReservation id from the form data
		int theTableReservationId = Integer.parseInt((request.getParameter("tableReservationId")));

		// delete TableReservation from database
		tableReservationDbUtil.deleteTableReservations(theTableReservationId);

		// send them back to the list TableReservation page
		listTableReservations(request, response);
	}

	private void updateTableReservations(HttpServletRequest request, HttpServletResponse response) {

		// read TableReservation info from form data
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String menuId = request.getParameter("menuId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		String contactNo = request.getParameter("contactNo");
		String  noOfPeople= request.getParameter("noOfPeople");
		

		// create a new TableReservation object
		TableReservation theTableReservation = new TableReservation(id,menuId,  name,   email, date,
				contactNo,noOfPeople);
		
		try {

			// perform update on database
			tableReservationDbUtil.updateTableReservations(theTableReservation);

			// send them back to the "list TableReservation" page
			listTableReservations(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void loadTableReservations(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read teacher id from form data
		String theTableReservationId = request.getParameter("tableReservationId");

		// get teacher from database (db util)
		TableReservation theTableReservation = TableReservationDbUtil.getTableReservations(theTableReservationId);

		// place TableReservation in the request atrribute
		request.setAttribute("THE_TABLERESERVATION", theTableReservation);

		// send to jsp page: update-teacher-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-TableReservation-form.jsp");
		dispatcher.forward(request, response);

	}

	private void loadTableReservations_ADD(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<DinnerTable> dinnerTableList = new ArrayList<>();

		dinnerTableList = dinnerTableUtil.dinnerTableList();

		// place TableReservation in the request atrribute

		System.out.println("Here");
		if (dinnerTableList == null)
			System.out.println("Null");
		request.setAttribute("dinnerTableList", dinnerTableList);

		// send to jsp page: update-teacher-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/add-tableReservation.jsp");
		dispatcher.forward(request, response);

	}

	private void addTableReservations(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read teacher info from form data
		int tableId = Integer.parseInt(request.getParameter("tableId"));
		String menuId = request.getParameter("menuId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		String contactNo = request.getParameter("contactNumber");
		String noOfPeople = request.getParameter("noOfPeople");

		// create a new teacher object
		TableReservation theTableReservation = new TableReservation(menuId, name, email, date, contactNo,
				noOfPeople,tableId);

		// add the teacher to the database
		TableReservationDbUtil.addTableReservation(theTableReservation);

		// send back to main page (teacher list)
		listTableReservations(request, response);
	}

	private void listTableReservations(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get teachers from db util
		List<TableReservation> tableReservation = TableReservationDbUtil.getTableReservation();

		// add teachers to the request
		request.setAttribute("TABLERESERVATION_LIST", tableReservation);

		// send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-tableReservation.jsp");
		dispatcher.forward(request, response);
	}

}
