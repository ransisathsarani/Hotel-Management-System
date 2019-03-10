<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "kfr";
String userid = "root";
String password = "root";
try 
{
Class.forName(driver);
} catch (ClassNotFoundException e) {
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
<title>List of User registrations | Kanneliya Forest Resort</title>
<link rel="stylesheet" href="tour.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
     
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
     <ul class="nav navbar-nav">
        <li><a href="adminHome.jsp">Home</a></li>
        <li><a href="list-register.jsp">Handle Registries</a></li>
        <li class="dropdown">
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Handle Package Bookings
    			<span class="caret"></span></a>
    				<ul class="dropdown-menu">
      					<li><a href="list-ReadyPackage.jsp">Readymade Packages</a></li>
     				 	<li><a href="list-cusPackages.jsp">Customized Packages</a></li>
      					<li><a href="list-newTour.jsp">Newly Requested Tours</a></li> 
    				</ul>
  		</li>
         <li class="active"><a href="#">Handle Tours</a></li>
         <li><a href="#">Hotel Booking Handing</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      
    </div>
  </div>
</nav>
<div class="container">
<form class="form-inline" method="post" action="searchTransport.jsp">
<input type="date" name="date" class="form-control" placeholder="Search by date">
<button type="submit" name="save" class="btn btn-primary">Search</button>

</form>
</div>

<div class="container-fluid bg-3">

<h3>List of Registrations - Kanneliya Forest Resort</h3>

  <table class="table table-striped">
    <thead>
      <tr>
         <th>First name</th>
        <th>Last name</th>
        <th>Address</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Password</th>
        
       
        <th>Delete</th>
      </tr>
    </thead>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from userregistration";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("fname") %></td>
<td><%=resultSet.getString("lname") %></td>
<td><%=resultSet.getString("address") %></td>
<td><%=resultSet.getString("phone") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("sex") %></td>
<td><%=resultSet.getString("password") %></td>



<td><a href="delete-UR.jsp?id=<%=resultSet.getString("id")%>">Delete</a></td>
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


</body>
</html>