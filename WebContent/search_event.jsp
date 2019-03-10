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
<!DOCTYPE html>
<html>
<body>
<h1>Search Data</h1>
<table border="1">
<tr>
					<th>Date</th>
					<th>Type</th>
					<th>Names</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>Post Code</th>
					<th>Contact No</th>
					<th>Mobile No</th>
					<th>Email</th>
					<th>Head Count</th>
					<th>Requests</th>

</tr>
<%
try{
	
	String date = request.getParameter("date");
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from event where date='"+date+"' ";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("date") %></td>
<td><%=resultSet.getString("type") %></td>
<td><%=resultSet.getString("names") %></td>
<td><%=resultSet.getString("client_first_name") %></td>
<td><%=resultSet.getString("client_last_name") %></td>
<td><%=resultSet.getString("address") %></td>
<td><%=resultSet.getString("post_code") %></td>
<td><%=resultSet.getString("tel_no") %></td>
<td><%=resultSet.getString("mobile_no") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("no_of_people") %></td>
<td><%=resultSet.getString("special_requests") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>