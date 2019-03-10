package com.itp.reports;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Genaratepdf
 */
@WebServlet("/Genaratepdf")
public class Genaratepdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Genaratepdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		

				try {
					
					String file_name="C:\\Users\\DML SANDATHARA\\Desktop\\inventory_report\\BasicNeeds.pdf";
					Document document = new Document();
					PdfWriter.getInstance(document,new FileOutputStream(file_name));
					document.open();
					
					DBConnection obJDBConnection = new DBConnection();
					Connection connection= obJDBConnection.getConnection();
					PreparedStatement ps=null;
					ResultSet rs = null;
					
					String query ="select * from basicneeds";
					ps=connection.prepareStatement(query);
					rs=ps.executeQuery();
					Paragraph para1 = new Paragraph("KANNELIYA FOREST RESORT- MONTHLY REPORT OF CATRING SERVICE");
					Paragraph para2 = new Paragraph("      ");
					document.add(para1);
					document.add(para2);
					while(rs.next()) {
						Paragraph para = new Paragraph(rs.getInt("id")+"      "+rs.getString("inquiry")+"    "+rs.getString("empid") + "        "+rs.getString("iDate") + "         "+rs.getString("complaint")+ "          "+ rs.getString("department"));
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
