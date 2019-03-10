<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "kfr";
String userid = "root";
String password = "root";
//String studentID=request.getParameter("studentID");
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Kanneliya Forest Resort</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="#">Home</a></li>
      <li><a href="#">Inventory</a></li>
      <li><a href="#">Accomodation</a></li>
      <li><a href="#">Staff</a></li>
      <li class="active"><a href="#">Events</a></li>
      <li><a href="#">Restaurant</a></li>
      <li><a href="#">Client Finance</a></li>
      <li><a href="#">Resort Finance</a></li>
    </ul>
  </div>
</nav>

<div class="container" style="margin-bottom: 20px;">
<ul class="nav nav-tabs">
    <li class="active"><a href="#">Add Event</a></li>
    <li><a href="list-enquiriess.jsp">Enquiries</a></li>
    <li><a href="list-events.jsp">Events</a></li>
  </ul>
  </div>
   
	<div class="container">
  <div class="jumbotron">

<%
try{
	
	String date = request.getParameter("date");
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from event where date='"+date+"' ";
resultSet = statement.executeQuery(sql);
if(resultSet.next() == false){
	
%>
	<p>Available!!</p>
	<a href="add-event-form.jsp" class="btn btn-primary">Add Event</a>
	
<%
}
if(resultSet.next() == true){
	%>
	<p>Unavailable!!</p>
<%	
}

connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</div>
</div>
</body>
</html>