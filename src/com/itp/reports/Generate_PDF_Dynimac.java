package com.itp.reports;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Generate_PDF_Dynimac
 */
@WebServlet("/Generate_PDF_Dynimac")
public class Generate_PDF_Dynimac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Generate_PDF_Dynimac() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
try {
			
			String file_name="C:\\Users\\DML SANDATHARA\\Desktop\\inventory_report\\ApplicationHandling_Report.pdf";
			Document document=new Document();
			PdfWriter.getInstance(document,new FileOutputStream(file_name));
			document.open();
			
			DBConnection obJDBConnection=new DBConnection();
			Connection connection= obJDBConnection.getConnection();
			PreparedStatement ps=null;
			ResultSet rs = null;
			
			String query ="select * from application";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			Paragraph para1=new Paragraph("KANNELIYA FOREST RESORT- REPORT OF Applicants Details-2018 SEP");
			Paragraph para2=new Paragraph("");
			document.add(para1);
			document.add(para2);
			while(rs.next()) {
				Paragraph para=new Paragraph(rs.getInt("id")	+"		"+	rs.getString("name")	+"		"+	rs.getString("address")	+"		 "+	rs.getString("nic")	+ "		"+	rs.getString("contact")	+ "		"+ rs.getString("mail")	+"		 "+ rs.getString("gender")	+ "		"+	rs.getString("edu_qualifi")	+"		"+	rs.getString("job_exp"));
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
