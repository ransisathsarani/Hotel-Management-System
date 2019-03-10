package com.itp.reports;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class Generate_PDF_Dynamic_TableReservation {
	

	public static void main(String[] args) {
		try {
			
			String file_name="D:\\generate_pdf\\TableReservation_Report.pdf";
			Document document=new Document();
			PdfWriter.getInstance(document,new FileOutputStream(file_name));
			document.open();
			
			DBConnection obJDBConnection=new DBConnection();
			Connection connection= obJDBConnection.getConnection();
			PreparedStatement ps=null;
			ResultSet rs = null;
			
			String query ="select * from tableReservation";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			Paragraph para1=new Paragraph("KANNELIYA FOREST RESORT- MONTHLY REPORT OF TABLE RESERVATION");
			Paragraph para2=new Paragraph(" - ");
			document.add(para1);
			document.add(para2);
			while(rs.next()) {
				Paragraph para=new Paragraph(rs.getInt("id")+"		"+rs.getString("tableId")+"    "+rs.getString("menuId") + "        "+rs.getString("name") + "         "+rs.getString("email")+ "          "+ rs.getString("date")+"           "+ rs.getString("contactNumber")+ "     "+rs.getString("noOfPeopleo"));
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
