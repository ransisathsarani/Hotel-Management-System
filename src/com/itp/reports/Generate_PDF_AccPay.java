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
@WebServlet("/Generate_PDF_AccPay")
public class Generate_PDF_AccPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Generate_PDF_AccPay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String file_name = "C:\\Users\\DML SANDATHARA\\Desktop\\inventory_report\\AccPay.pdf";
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			
			document.open();
			
			DBConnection ObJDBConnection = new DBConnection();
			
			Connection conn  = ObJDBConnection.getConnection();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql =" select * from accpay";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Paragraph para = new Paragraph(rs.getString("reserveId")+"          "+rs.getString("date")+"          "+rs.getString("RID")+"           "+rs.getString("category")+"          "+rs.getFloat("days")+"           "+rs.getFloat("advance")+"          "+rs.getFloat("restaurant")+"           "+rs.getFloat("total"));
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
