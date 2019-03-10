package com.resort.salaryhandling;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

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
import com.resort.ishandling.VendorPaymentDbUtil;


//new addd

import java.io.File;

//

/**
 * Servlet implementation class SalaryControllerServlet
 */
@WebServlet("/SalaryControllerServlet")
public class SalaryControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SalaryDbUtil salaryDbUtil;
	@Resource(name = "jdbc/kfr")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		// create salary db util ... and pass in the conn pool / datasource
		try {
			salaryDbUtil = new SalaryDbUtil(dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalaryControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String theCommand = request.getParameter("command");

			switch (theCommand) {

			case "LOAD_SALARY":
				loadSalaryDetails(request, response);
				break;

			case "ADD_SALARY":
				addCalculatedSalary(request, response);
				break;
				
			case "EMP_SEARCH":
				backEmpSearch(request,response);
				break;
				
			case "PRINT":
				genaratePaySlip(request,response);
				break;	

			default:
				loadSalaryDetails(request, response);
			}

		} catch (Exception e) {

		}
	}

	private void genaratePaySlip(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String empID = request.getParameter("employeeId");
		String empName = request.getParameter("employeeName");
		double basicSalary = Double.parseDouble(request.getParameter("basicSalary"));
		double otRate = Double.parseDouble(request.getParameter("otRate"));
		int otHours = Integer.parseInt(request.getParameter("otHours"));
		double bonusPayment = Double.parseDouble(request.getParameter("bonusAmount"));
		double panaltyPayment = Double.parseDouble(request.getParameter("panaltyAmount"));
		double totalSalary = Double.parseDouble(request.getParameter("totalSalary"));
		String action = request.getParameter("command");
		
		LocalDate date = java.time.LocalDate.now();
		
		
		try {
			
			System.out.println("Date : "+date);

		
		
		String fileName = "C:\\Users\\Wenuka Mahanama\\Desktop\\ResortPDF\\salaryReport"+empID+".pdf";
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(fileName));
		
		document.open();
		Paragraph para1 = new Paragraph( "****KANNELIYA FOREST RESORT****");
		Paragraph para2= new Paragraph(  "********EMPLOYEE PAYSLIP*******");
		Paragraph para3 = new Paragraph( "###############################");
		Paragraph para13 = new Paragraph("--------------Date :"+date+"-----------");
		Paragraph para14 = new Paragraph( "###############################");
		Paragraph para4 = new Paragraph( "    Employee ID     : "+empID);
		Paragraph para5 = new Paragraph( "    Employee Name   : "+empName);
		Paragraph para6 = new Paragraph( "    Basic Salary    : "+basicSalary);
		Paragraph para7 = new Paragraph( "    OT Rate         : "+otRate);
		Paragraph para8 = new Paragraph( "    OT Hours        : "+otHours);
		Paragraph para9 = new Paragraph( "    Bonus Payment   : "+bonusPayment);
		Paragraph para10 = new Paragraph("    Panalty Payment : "+panaltyPayment);
		Paragraph para11= new Paragraph( "    Total Salary    : "+totalSalary);
		Paragraph para12 = new Paragraph("###############################");
		
		document.add(para1);
		document.add(para2);
		document.add(para3);
		document.add(para13);
		document.add(para14);
		document.add(para3);
		document.add(para4);
		document.add(para5);
		document.add(para6);
		document.add(para7);
		document.add(para8);
		document.add(para9);
		document.add(para10);
		document.add(para11);
		document.add(para12);
		
		document.add(new Paragraph(""));
		
		document.close();

		}catch(Exception e ) {
			
		}finally {
			System.out.println( "Action : " + action );
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchEmployee.jsp");
		dispatcher.forward(request, response);
		
		
	}

	private void backEmpSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchEmployee.jsp");
		dispatcher.forward(request, response);
	}

	private void addCalculatedSalary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String empID = request.getParameter("employeeId");
		double totalSalary = Double.parseDouble(request.getParameter("totalSalary"));
		String action = request.getParameter("command");
		
		try {

		System.out.println("Action : "+action);
		
		System.out.println("servlet total : " + totalSalary);

		Salary theSalary = new Salary(empID, totalSalary);

		SalaryDbUtil.addEmployeeSalary(theSalary);

		}catch(Exception e ) {
			
		}finally {
			System.out.println( "Action : " + action );
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchEmployee.jsp");
		dispatcher.forward(request, response);
	}

	private void loadSalaryDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String theEmployeeId = request.getParameter("empId");

		Salary theSalary = SalaryDbUtil.getEmployeeDetails(theEmployeeId);

		System.out.println("employee id : " + theEmployeeId);

		request.setAttribute("THE_SALARY_INFO", theSalary);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/CalculateSalary.jsp");
		dispatcher.forward(request, response);
	}

}

