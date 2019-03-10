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
 * Servlet implementation class reservation_report_pdf
 */
@WebServlet("/reservation_report_pdf")
public class reservation_report_pdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservation_report_pdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			String file_name="C:\\Users\\DML SANDATHARA\\Desktop\\inventory_report\\reservation_report.pdf";
			Document document=new Document();
			PdfWriter.getInstance(document,new FileOutputStream(file_name));
			document.open();
			
			DBConnection obJDBConnection=new DBConnection();
			Connection connection= obJDBConnection.getConnection();
			PreparedStatement ps=null;
			ResultSet rs = null;
			
			String query ="select * from reservation";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			Paragraph para1=new Paragraph("KANNELIYA FOREST RESORT- MONTHLY REPORT OF ROOM RESERVATIONS-2018 SEP");
			Paragraph para2=new Paragraph("ID       Name                In                        Out               Adult     Child          Advance ");
			document.add(para1);
			document.add(para2);
			while(rs.next()) {
				Paragraph para=new Paragraph(rs.getInt("id")+"      "+rs.getString("name")+"    "+rs.getString("checkIn") + "        "+rs.getString("checkOut") + "         "+rs.getString("adults")+ "          "+ rs.getString("children")+"           "+ rs.getString("advance"));
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
