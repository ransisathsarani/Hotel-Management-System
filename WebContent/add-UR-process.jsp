<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html> 
<html>
<head>
	<title>Registered successfully | kanneliya Forest Resort</title>
	<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color:black">
         
<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#85adad;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>

      <div style="color:#ffffff;align:center"><h3>Successfully Registered!!!!</h3></div>
    <strong><a href="MainHome.jsp">Back to Home page</a></strong>
      
<a href="<%=request.getContextPath() %>/logoutServlet">Logout</a></span>
      <br />
      
      <div style="background-color:#ffff66">

    </div>
    </div>
<%
String fname=request.getParameter("fname");
String lname=request.getParameter("lname");
String address=request.getParameter("address");
String phone=request.getParameter("phone");
String email =request.getParameter("email");
String sex =request.getParameter("sex");
String password = request.getParameter("password");





try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kfr", "root", "root");

Statement st=conn.createStatement();

int j=st.executeUpdate("insert into userregistration(fname,lname,address,phone,email,sex,password)values('"+fname+"','"+lname+"','"+address+"','"+phone+"','"+email+"','"+sex+"','"+password+"')");

%>



<% 

}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
<div class="container text-center">    
  <h3 style="color:white">Welcome to Kanneliya Forest Resort </h3><br>
  <div class="row">
    <div class="col-sm-4" style="background-color:#53c68c;width:350px;height:450px">
      <img src="images/entrance_2.jpg" class="img-responsive" style="width:300px;height:200px" alt="Image">
      <h3>Lodging</h3>
      <p>Accommodation facilities at Kanneliya Forest Resort allow guests to experience the calming effect of nature.And also allows guests to spend a relaxed vacation with their loved ones.
       Leave behind the stress of city life as these rooms truly embrace the meaning of one with nature. With clay walls and the stream flows nearby the lodges. 
      The attached bathroom comes with separate shower and toilet areas.</p>
    </div>
    <div class="col-sm-4" style="background-color:#ffff80;width:350px;height:450px"> 
      <img src="images/string-hoppers.jpg" class="img-responsive" style="width:300px;height:200px" alt="Image">
      <h3>Food and beverages</h3>
      <p>Well experienced cooks in Kanneliya resort is ready to serve variety of food and beverages(Non-alcoholic)
      Open for breakfast, lunch and dinner.
       You'll prefer to feast your taste buds after a hike or a natural walk in Kannliya Forest Reserve, 
       with local delicasies.Guess can order food to their lodges or dine in at the open area as their preference.</p>
       <br>   </div>
   
    <div class="col-sm-4" style="background-color:#ffdd99;width:350px;height:450px">
      <img src="images/oil_l.jpg" class="img-responsive" style="width:230px;height:200px" alt="Image">
     <h3>Events and Restaurant</h3>
     <p>Book the restaurant space for your wedding, party, and gatherings at affordable rates and get along with our variety of manues and customize the menues as the gueast preferance.
     
    </div>
    
  </div>
</div>


</div>
</body>
</html>


