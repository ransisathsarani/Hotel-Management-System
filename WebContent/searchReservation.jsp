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
<!DOCTYPE html>
<html>
<head>
<title>Search Data - KFR</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="search.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body >


 
<div style="width:1000px">
<div class="container-fluid bg-3">

<table class="table table-striped" style="margin:10px" >

<tr>	<th>ID</th>
		<th>Reservation ID</th>
		<th>Name</th>
		<th>Phone</th>
		<th>Email</th>
		<th>Check-In</th>
        <th>Check-Out</th>
        <th>Days</th>
        <th>Advance</th>
        <th>Bank Slip Number</th>
     
</tr>
<%
try{
	
	String reserveID = request.getParameter("reserveID");
	
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql1 ="select * from reservation where reserveID='"+reserveID+"'";

resultSet = statement.executeQuery(sql1);

while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getInt("id") %></td>
<td><%=resultSet.getString("reserveID") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("phone") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("checkIn") %></td>
<td><%=resultSet.getString("checkOut") %></td>
<td><%=resultSet.getString("days") %></td>
<td><%=resultSet.getString("adults") %></td>
<td><%=resultSet.getString("children") %></td>
<td><%=resultSet.getString("advance") %></td> 
<td><%=resultSet.getString("slipNo") %></td> 
 

</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

</table>
</div>
</div>

</body>
</html>