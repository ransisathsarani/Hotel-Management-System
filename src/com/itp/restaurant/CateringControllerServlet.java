package com.itp.restaurant;

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
 * Servlet implementation class CateringControllerServlet
 */
@WebServlet("/CateringControllerServlet")
public class CateringControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CateringDbUtil cateringDbUtil;

	@Resource(name = "jdbc/kfr")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		// create Catering db util ... and pass in the conn pool / datasource
		try {
			cateringDbUtil = new CateringDbUtil(dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	public CateringControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			// read the "command" parameter
			String theCommand = request.getParameter("command");

			// if the command is missing, then default to listing Caterings
			if (theCommand == null) {
				theCommand = "LIST";
			}

			// route to the appropriate method
			switch (theCommand) {

			case "LIST":
				listCatering(request, response);
				break;

			case "ADD":
				System.out.println("No Error");
				addCaterings(request, response);
				break;

			case "LOAD":
				loadCaterings(request, response);
				break;

			case "UPDATE":
				updateCaterings(request, response);
				break;

			case "DELETE":
				deleteCaterings(request, response);
				break;

			default:
				listCatering(request, response);

			}

		} catch (Exception exc) {
			System.out.println("Error");
			throw new ServletException(exc);
		}

	}

	private void deleteCaterings(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read Catering id from the form data
		String theCateringId = request.getParameter("cateringId");

		// delete Catering from database
		cateringDbUtil.deleteCaterings(theCateringId);

		// send them back to the list Catering page
		listCatering(request, response);
	}

	private void updateCaterings(HttpServletRequest request, HttpServletResponse response) {

		// read Catering info from form data
		String ids = request.getParameter("cateringId");
		int id = Integer.parseInt(ids);

		String name = request.getParameter("name");
		String contactNumber = request.getParameter("contactNumber");
		String date = request.getParameter("date");
		String numberOfPeople = request.getParameter("numberOfPeople");
		String email = request.getParameter("email");
		String menuID = request.getParameter("menuID");

		// create a new catering object
		Catering theCatering = new Catering(id, name, contactNumber, date, numberOfPeople, email, menuID);

		try {

			// perform update on database
			cateringDbUtil.updateCaterings(theCatering);

			// send them back to the "list caterings" page
			listCatering(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void loadCaterings(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read catering id from form data
		String theCateringId = request.getParameter("cateringId");

		// get catering from database (db util)
		Catering theCatering = cateringDbUtil.getCaterings(theCateringId);

		// place catering in the request atrribute
		request.setAttribute("THE_CATERING", theCatering);

		// send to jsp page: update-catering-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/updateCatering.jsp");
		dispatcher.forward(request, response);

	}

	private void addCaterings(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read catering info from form data

		System.out.println("ÏNSIDE");
		String name = request.getParameter("name");
		String contactNumber = request.getParameter("contactNumber");
		String date = request.getParameter("date");
		String numberOfPeople = request.getParameter("numberOfPeople");
		String email = request.getParameter("email");
		String menuID = request.getParameter("menuID");
		// create a new catering object
		Catering theCatering = new Catering(name, contactNumber, date, numberOfPeople, email, menuID);

		// add the catering to the database
		cateringDbUtil.addCatering(theCatering);

		// send back to main page (catering list)
		listCatering(request, response);
	}

	private void listCatering(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get caterings from db util
		List<Catering> catering = CateringDbUtil.getCaterings();

		// add caterings to the request
		request.setAttribute("CATERING_LIST", catering);

		// send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-catering-form.jsp");
		dispatcher.forward(request, response);
	}

}
