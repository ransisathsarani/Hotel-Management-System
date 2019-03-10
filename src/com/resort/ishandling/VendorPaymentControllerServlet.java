package com.resort.ishandling;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

//import com.itp.Inventory.Inventory;
//import com.itp.Inventory.InventoryDbUtil;






/**
 * Servlet implementation class VendorPaymentControllerServlet
 */
@WebServlet("/VendorPaymentControllerServlet")
public class VendorPaymentControllerServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private VendorPaymentDbUtil vendorPaymentDbUtil;
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create teacher db util ... and pass in the conn pool / datasource
		try {
			vendorPaymentDbUtil = new VendorPaymentDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}
	
	
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorPaymentControllerServlet() {
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
			
			//if the command is missing, then default to listing teachers
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listVendorPayment(request,response);
				break;
				
			case "ADD":
				addVendorPayment(request,response);
				break;
				
			case "LOAD":
				loadVendorPayment(request,response);
				break;
				
			case "LOAD_PAYMENT":
				loadPaymentDetails(request,response);
				break;	
				
			case "UPDATE":
				updateVendorPayment(request,response);
				break;
				
			case "DELETE" :
				deleteVendorPayment(request,response);
				break;
				
			case "ADDINFO" :
				addPaymentInfo(request,response);
				break;
				
			case "LISTINFO":
				listPaymentInfo(request,response);
				break;
			case "VENDOR_SEARCH":
				backVendorSearch(request,response);
				break;
			case "LIST_VENDOR":
				listVendorPayment(request,response);
				break;
			
			default:
				listVendorPayment(request,response);
		}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	
		
	






	private void backVendorSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/VendorPayment.jsp");
		dispatcher.forward(request, response);
		
	}






	private void deleteVendorPayment(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read teacher id from the form data
				String theVendorPaymentId = request.getParameter("vendorPaymentId");
				
				// delete teacher from database
				VendorPaymentDbUtil.deleteVendorPayment(theVendorPaymentId);
				
				//send them back to the list teachers page
				listVendorPayment(request,response);
	}


	private void updateVendorPayment(HttpServletRequest request, HttpServletResponse response){

		//read teacher info from form data
		String ids = request.getParameter("vendorPaymentId");
		int id = Integer.parseInt(ids);
		String invoice = request.getParameter("invoice");
		String iDate = request.getParameter("iDate");
		String vendor = request.getParameter("vendor");
		String vendorId = request.getParameter("vendorId");
		String department = request.getParameter("department");
		String stockId = request.getParameter("stockId");
		Float amount = Float.parseFloat(request.getParameter("amount"));
		Float paidAmount = Float.parseFloat(request.getParameter("paidAmount"));
		String paymentType = request.getParameter("paymentType");
		
		//create a new teacher object
		VendorPayment theVendorPayment = new VendorPayment(id, invoice,iDate,vendor,vendorId,department,stockId,amount,paidAmount,paymentType);
		
		
		try {
			
			//perform update on database
			VendorPaymentDbUtil.updateVendorPayment(theVendorPayment);
			
			//send them back to the "list teachers" page
			listVendorPayment(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadVendorPayment(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read teacher id from form data
		String theVendorPaymentId = request.getParameter("vendorPaymentId");
		
		//get teacher from database (db util)
		VendorPayment theVendorPayment = VendorPaymentDbUtil.getVendorPayment(theVendorPaymentId);
		
		//place teacher in the request atrribute
		request.setAttribute("THE_VENDORPAYMENT", theVendorPayment);
		
		// send to jsp page: update-teacher-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/UpdateVendorPayment.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
	private void loadPaymentDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read teacher id from form data
		String theVendorPaymentId = request.getParameter("vendorPaymentId");
		
		//get teacher from database (db util)
		VendorPayment theVendorPayment = VendorPaymentDbUtil.getVendorInfo(theVendorPaymentId);
		
		//place teacher in the request atrribute
		request.setAttribute("THE_VENDORPAYMENT_INFO", theVendorPayment);
		
		// send to jsp page: update-teacher-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/CalculatePayment.jsp");
		dispatcher.forward(request, response);
		
	}
	


	private void addVendorPayment(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read teacher info from form data
		String invoice = request.getParameter("invoice");
		String iDate = request.getParameter("iDate");
		String vendor = request.getParameter("vendor");
		String vendorId = request.getParameter("vendorId");
		String department = request.getParameter("department");
		String stockId = request.getParameter("stockId");
		Float amount = Float.parseFloat(request.getParameter("amount"));
		Float paidAmount = Float.parseFloat(request.getParameter("paidAmount"));
		String paymentType = request.getParameter("paymentType");
		
		// create a new teacher object
		VendorPayment theVendorPayment = new VendorPayment(invoice,iDate,vendor,vendorId,department,stockId,amount,paidAmount,paymentType);
		
		
		// add the teacher to the database
		VendorPaymentDbUtil.addVendorPayment(theVendorPayment);
		
		//send back to main page (teacher list)
		listVendorPayment(request,response);
	}
	
	private void addPaymentInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		String vendorId = request.getParameter("vendorId");
		//String remainingAmount = request.getParameter("remainingAmount");
		String iDate = request.getParameter("iDate");
		Float paidAmount = Float.parseFloat(request.getParameter("paidAmount"));
		
		
		
		VendorPayment theVendorPayment = new VendorPayment(iDate,vendorId,paidAmount);
		
		
		
		VendorPaymentDbUtil.addPaidDetails(theVendorPayment);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/VendorPayment.jsp");
		dispatcher.forward(request, response);
		
		
		
		//listPaymentInfo(request,response);
	}
	
	
	
	
	

	private void listVendorPayment(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		List<VendorPayment> con = VendorPaymentDbUtil.getVendorPayment();
		
		
		request.setAttribute("VENDORPAYMENT_LIST", con);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListVendorPayment.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	private void listPaymentInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		List<VendorPayment> con = VendorPaymentDbUtil.getPaidDetails();
		
		//add to the request
		request.setAttribute("PAIDINFO_LIST", con);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListPaymentDetails.jsp");
		dispatcher.forward(request, response);
	}
		
		
	}


