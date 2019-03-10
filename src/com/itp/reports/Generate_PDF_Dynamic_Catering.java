package com.itp.reports;



import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class Generate_PDF_Dynamic_Catering {
	

	public static void main(String[] args) {
		try {
			
			String file_name="D:\\generate_pdf\\Catering_Report.pdf";
			Document document = new Document();
			PdfWriter.getInstance(document,new FileOutputStream(file_name));
			document.open();
			
			DBConnection obJDBConnection = new DBConnection();
			Connection connection= obJDBConnection.getConnection();
			PreparedStatement ps=null;
			ResultSet rs = null;
			
			String query ="select * from catering";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			Paragraph para1 = new Paragraph("KANNELIYA FOREST RESORT- MONTHLY REPORT OF CATRING SERVICE");
			Paragraph para2 = new Paragraph("Name		Contact Number		Date		Number of People		Email		menu ID");
			document.add(para1);
			document.add(para2);
			while(rs.next()) {
				Paragraph para = new Paragraph(rs.getInt("id")+"      "+rs.getString("name")+"    "+rs.getString("contactNumber") + "        "+rs.getString("date") + "         "+rs.getString("numberOfPeople")+ "          "+ rs.getString("email"));
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
