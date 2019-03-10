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
String password = "sliit";

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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kanneliya Forest Resort</title>

	
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

	<body>
  <!--  <body style="background-color:#B82C19">-->
  
  <div id="page" >
  <div id="header">
    <div id="section" style="background-color:#274F75;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>

      <div style="color:#ffffff;align:center"><h3>List Employee Details - Kanneliya Forest Resort</h3></div>
      
      

      <br />
       </div>
      <div style="background-color:#ffff66">

    </div>
    </div>
    </div>
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
  		<li class="dropdown">
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Inventory
    			<span class="caret"></span></a>
    				<ul class="dropdown-menu">
      					<li><a href="#">Tracking consumption</a></li>
     				 	<li><a href="#">Add Order</a></li>
      					<li class="active"><a href="#">Stock Maintenance</a></li> 
    				</ul>
  		</li>
        <li class="dropdown">
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Accommodation
    			<span class="caret"></span></a>
    				<ul class="dropdown-menu">
      					<li><a href="#">Booking handling</a></li>
     				 	<li><a href="#">check availability</a></li>
      					<li><a href="#">Offers Handling</a></li> 
    				</ul>
  		</li>
          <li class="dropdown">
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Career and Staff
    			<span class="caret"></span></a>
    				<ul class="dropdown-menu">
    					<li><a href="Application.jsp">New Applicants</a></li>
      					<li><a href="#">Shifts and schedules</a></li>
     				 	<li><a href="#">Salary </a></li>
      					<li><a href="#">Basic needs</a></li> 
      					<li><a href="list-employee.jsp">Vacancies handling</a></li> 
      					<li><a href="list-application.jsp">Applicant handling</a></li> 
      					<li><a href="list-handle.jsp">Interview and training sessions</a></li> 
    				</ul>
  		</li>
        <li class="dropdown">
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Event Planning
    			<span class="caret"></span></a>
    				<ul class="dropdown-menu">
      					<li><a href="#">Wedding packages booking</a></li>
     				 	<li><a href="#">Other events planning</a></li>
      					<li><a href="#">Entertainment</a></li> 
      					
    				</ul>
  		</li>
       <li class="dropdown">
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Resturaunt
    			<span class="caret"></span></a>
    				<ul class="dropdown-menu">
      					<li><a href="#">Catering Handling</a></li>
     				 	<li><a href="#">Table reservations </a></li>
      					<li><a href="#">Take away</a></li> 
      					<li><a href="#">Menu handling</a></li> 
      					
    				</ul>
  		</li>
  		<li class="dropdown">
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Spa
    			<span class="caret"></span></a>
    				<ul class="dropdown-menu">
      					<li><a href="#">Reservations and schedule</a></li>
     				 	<li><a href="#">Packages booking and handling </a></li>
      					<li><a href="#">Reviews handling</a></li> 
      					
    				</ul>
  		</li>
  		<li class="dropdown">
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Bar
    			<span class="caret"></span></a>
    				<ul class="dropdown-menu">
      					<li><a href="#">Liquor inventory</a></li>
     				 	<li><a href="#">Sales</a></li>
      					<li><a href="#">Pool table booking handling</a></li> 
      					
    				</ul>
  		</li>
      </ul>
      
    </div>
  </div>
</nav>


<h1>Application Details</h1>
<table border="1">
<tr>
<td>Name</td>
<td>Address</td>
<td>NIC</td>
<td>Contact number</td>
<td>E-mail</td>
<td>Gender</td>
<td>Educational Qualification</td>
<td>Job Experience</td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from application";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>

<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("address") %></td>
<td><%=resultSet.getString("nic") %></td>
<td><%=resultSet.getString("contact") %></td>
<td><%=resultSet.getString("mail") %></td>
<td><%=resultSet.getString("gender") %></td>
<td><%=resultSet.getString("edu_qualifi") %></td>
<td><%=resultSet.getString("job_exp") %></td>
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