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
 * Servlet implementation class rooms_pdf
 */
@WebServlet("/rooms_pdf")
public class rooms_pdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rooms_pdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			String file_name="C:\\Users\\DML SANDATHARA\\Desktop\\inventory_report\\rooms_report.pdf";
			Document document=new Document();
			PdfWriter.getInstance(document,new FileOutputStream(file_name));
			document.open();
			
			DBConnection obJDBConnection=new DBConnection();
			Connection connection= obJDBConnection.getConnection();
			PreparedStatement ps=null;
			ResultSet rs = null;
			
			String query ="select * from rooms";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			Paragraph para1=new Paragraph("KANNELIYA FOREST RESORT- ANNUAL REPORT FOR ROOMS-2018");
			
			Paragraph para2=new Paragraph("ID     RoomID         Category         Price      Status");
			document.add(para1);
			document.add(para2);
			while(rs.next()) {
				Paragraph para=new Paragraph(rs.getInt("id")+"      "+rs.getString("RID") + "                 "+rs.getString("category") + "          "+rs.getString("price")+ "          "+ rs.getString("status"));
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
