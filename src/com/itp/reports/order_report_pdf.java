package com.itp.reports;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class order_report_pdf {

	public static void main(String[] args) throws Exception {
		
		try{
	String file_name = "C:\\Users\\DML SANDATHARA\\Desktop\\inventory_report\\order_report.pdf";
	Document document = new Document();
	PdfWriter.getInstance(document, new FileOutputStream(file_name));
	
	document.open();
	
	DBConnection ObJDBConnection = new DBConnection();
	
	Connection conn  = ObJDBConnection.getConnection();
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql ="select * from ordertable where department = 'Kitchen'";
	ps = conn.prepareStatement(sql);
	rs = ps.executeQuery();
	
	while(rs.next()) {
		Paragraph para = new Paragraph(rs.getString("date")+"        "+rs.getString("staffid")+"        "+rs.getString("department")+"        "+rs.getString("description")+"        "+rs.getFloat("quantity")+"         "+rs.getFloat("unit")+"        "+rs.getFloat("total")+"        "+rs.getString("type"));
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
