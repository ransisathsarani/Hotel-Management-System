<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.DriverManager" %>'
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>

<%
String id = request.getParameter("userid");
String driver = "com.mysql.jdbc.Drivere";
String connectionUrl = "jdbc:myscl://localhost:3306/";
String database = "kfr";
String userid = "root";
String password = "sliit";
try{
	Class.forName(driver);
}catch(ClassNotFoundException e){
	e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Menus</title>
</head>
<body bgcolor="#34495E">

<h1>Menu</h1>
<table border="1">
	<tr>
		<td>Type</td>
		<td>Menu Id</td>
		<td>Menu Name</td>
		<td>Price</td>
	</tr>
	<%
		try{
			
			connection = DriverManager.getConnection(connectionUrl+database, userid, password);
			statement = connection.createStatement();
			String sql = "select * from menu";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
			%>
			<tr>
			<td><%=resultSet.getString("type") %></td>
			<td><%=resultSet.getString("menuId") %></td>
			<td><%=resultSet.getString("menuName") %></td>
			<td><%=resultSet.getString("price") %></td>
			</tr>
			<%
			
			}}catch(Exception e){
				e.printStackTrace();
			}
	%>
</table>

</body>
</html>