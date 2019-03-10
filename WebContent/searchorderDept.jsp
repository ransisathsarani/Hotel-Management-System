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

<tr>
		<th>Date</th>
        
        <th>Staff ID</th>
        <th>Department</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Type</th>
        <th>Unit price</th>
        <th>Total price</th>
        
</tr>
<%
try{
	
	String department = request.getParameter("department");
	
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql1 ="select * from ordertable where department='"+department+"' ";

resultSet = statement.executeQuery(sql1);

while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("date") %></td>

<td><%=resultSet.getString("staffid") %></td>
<td><%=resultSet.getString("department") %></td>
<td><%=resultSet.getString("description") %></td>
<td><%=resultSet.getString("quantity") %></td>

<td><%=resultSet.getString("unit") %></td>
<td><%=resultSet.getString("total") %></td>
<td><%=resultSet.getString("type") %></td>



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