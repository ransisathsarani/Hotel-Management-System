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
 * Servlet implementation class inventryReport
 */
@WebServlet("/inventryReport")
public class inventryReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inventryReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String file_name = "C:\\Users\\DML SANDATHARA\\Desktop\\inventory_report\\inventory_report_3.pdf";
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			
			document.open();
			
			DBConnection ObJDBConnection = new DBConnection();
			
			Connection conn  = ObJDBConnection.getConnection();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql =" select * from stock";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Paragraph para = new Paragraph(rs.getString("date")+"          "+rs.getString("description")+"          "+rs.getString("vendor")+"           "+rs.getString("invoiceNum")+"          "+rs.getFloat("recieved")+"           "+rs.getFloat("weekCon")+"          "+rs.getFloat("current"));
				document.add(para);
				
				document.add(new Paragraph(""));
			}
			
			document.close();
			System.out.println("finished");
			}catch(Exception e) {
				System.out.println(e);
			}
			
				
		}
	

}
