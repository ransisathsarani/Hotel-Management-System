package com.itp.reports;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class Generate_PDF_Dynamic1
 */
@WebServlet("/Generate_PDF_Dynamic1")
public class Generate_PDF_Dynamic1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Generate_PDF_Dynamic1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	// response.getWriter().append("Served at: ").append(request.getContextPath());
	// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {

			String file_name = "C:\\Users\\DML SANDATHARA\\Desktop\\inventory_report\\Catering.pdf";
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			document.open();

			DBConnection obJDBConnection = new DBConnection();
			Connection connection = obJDBConnection.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;

			String query = "select * from catering";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			Paragraph para1 = new Paragraph("KANNELIYA FOREST RESORT- MONTHLY REPORT OF CATERING - 2018 SEP");
			Paragraph para2 = new Paragraph(" <3 ");
			document.add(para1);
			document.add(para2);
			while (rs.next()) {
				Paragraph para = new Paragraph(rs.getInt("id")+"      "+rs.getString("name")+"    "+rs.getString("contactNumber")+"        "+rs.getString("date")+"         "+rs.getString("numberOfPeople")+"		"+rs.getString("email") + "          "+rs.getString("menuID"));
				document.add(para);
				document.add(new Paragraph(" "));
			}
			document.close();

			System.out.println("Finished!!!");
		} catch (Exception e) {
			System.err.println(e);
		}

	}
}
