package com.itp.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class validateUser {

	public static boolean checkUser(String email,String password) 
    {
     boolean st =false;
     try{

	 //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql:/ /localhost:3306/kfr","root","root");
        PreparedStatement ps =con.prepareStatement
                            ("select * from admin where email=? and password=?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs =ps.executeQuery();
        st = rs.next();
       
     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return st;                 
 }   
	
	public static boolean checkAdmin(String email,String password) {
		boolean st =false;
	     try{

		 //loading drivers for mysql
	        Class.forName("com.mysql.jdbc.Driver");

		 //creating connection with the database 
	        Connection con=DriverManager.getConnection
	                       ("jdbc:mysql:/ /localhost:3306/tour_mgt","root","root");
	        PreparedStatement ps =con.prepareStatement
	                            ("select * from admin where email=? and password=?");
	        ps.setString(1, email);
	        ps.setString(2, password);
	        ResultSet rs =ps.executeQuery();
	        st = rs.next();
	       
	     }catch(Exception e)
	     {
	         e.printStackTrace();
	     }
	        return st;   
	}
}
