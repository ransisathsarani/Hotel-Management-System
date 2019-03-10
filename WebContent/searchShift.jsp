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
//String studentID=request.getParameter("empid");
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

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
					<th>empid</th>

					<th>s_time</th>
					<th>dept</th>
					<th>Action</th>
				</tr>
<%
try{
	
	String empid = request.getParameter("empid");
	
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql1 ="select * from shift where empid ='"+empid+"' ";

resultSet = statement.executeQuery(sql1);

while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("empid") %></td>
<td><%=resultSet.getString("s_time") %></td>
<td><%=resultSet.getString("dept") %></td>





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