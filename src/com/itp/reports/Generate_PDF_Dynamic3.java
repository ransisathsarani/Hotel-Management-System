package com.itp.reports;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class Generate_PDF_Dynamic3
 */
@WebServlet("/Generate_PDF_Dynamic3")
public class Generate_PDF_Dynamic3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Generate_PDF_Dynamic3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
try {
			
			String file_name="C:\\Users\\DML SANDATHARA\\Desktop\\inventory_report\\ApplicationHandling_Report_2.pdf";
			Document document=new Document();
			PdfWriter.getInstance(document,new FileOutputStream(file_name));
			document.open();
			
			DBConnection obJDBConnection=new DBConnection();
			Connection connection= obJDBConnection.getConnection();
			PreparedStatement ps=null;
			ResultSet rs = null;
			
			String query ="select * from employee";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			Paragraph para1=new Paragraph("KANNELIYA FOREST RESORT- REPORT OF Employee  Details-2018 SEP");
			Paragraph para2=new Paragraph(" ");
			document.add(para1);
			document.add(para2);
			while(rs.next()) {
				Paragraph para=new Paragraph(rs.getInt("id")+"		"+rs.getString("empid")+"		"+rs.getString("name")+"		"+rs.getString("nic") + "		 "+rs.getString("contact")+ "		"+ rs.getString("mail")+"		"+ rs.getString("gender")+ "		"+rs.getString("job_title")+"		" +rs.getString("salary")+"		 "+rs.getString("department")+"		"+rs.getString("appointmentDate")+"		"+rs.getString("address"));
				document.add(para);
				document.add(new Paragraph(" "));
			}
			document.close();
			
			System.out.println("Finished!!!");
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	}
