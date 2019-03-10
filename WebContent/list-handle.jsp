<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Interviews and trainig sessions | kanneliya Forest Resort</title>
	<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
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

      <div style="color:#ffffff;align:center"><h3>Interviews and Training sessions handling - Kanneliya Forest Resort</h3></div>
      
      

      <br />
       </div>
      <div style="background-color:#ffff66">

    </div>
    </div>
  
  <!--  nav tag -->
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
        <li><a href="index.jsp">Home</a></li>
  		<li class="dropdown">
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Inventory
    			<span class="caret"></span></a>
    				<ul class="dropdown-menu">
      					<li><a href="#">Tracking consumption</a></li>
     				 	<li><a href="#">Add order</a></li>
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
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Client Finance
    			<span class="caret"></span></a>
    				<ul class="dropdown-menu">
      					<li><a href="#">Accommodation Payments</a></li>
     				 	<li><a href="#">Restaurant Payments </a></li>
      					<li><a href="#">Events booking Payments</a></li> 
      					
    				</ul>
  		</li>
  		<li class="dropdown">
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Staff and Inventory Finance
    			<span class="caret"></span></a>
    				<ul class="dropdown-menu">
      					<li><a href="#">salary payments</a></li>
     				 	<li><a href="#">Inventory payments</a></li>
      					
      					
    				</ul>
  		</li>
  		
      </ul>
      
    </div>
  </div>
</nav>

  
	<div align="center">
	
	<input type = "button" value = "Add Applicants Details" onClick = "window.location.href='handle.jsp';return false;" data-toggle="collapse" data-target="#myNavbar
	class = "handle-button"/>
	
<div class="container">

	
<div class="container-fluid bg-3">

<h3>Interviews and Training sessions</h3>

  <table class="table table-striped">
	<thead>
	<tr>
		
		<th>Name:</th>
		<th>Address:</th>
		<th>NIC:</th>
		<th>Contact Number:</th>
		<th>E-mail:</th>
		<th>Interview Date:</th>
		<th>Interview Venue:</th>
		<th>Training Date:</th>
		<th>Training Venue:</th>
		<th>Action:</th>
	</tr>
	</thead>
	
	<c:forEach var="tempHandle" items="${HANDLE_LIST}">
	
	<!-- Set a link for each applicant -->
	
	<c:url var="templink" value="HandleControllerServlet">
	<c:param name="command" value="LOAD"/>
	<c:param name="handleId" value="${tempHandle.id}"/>
	</c:url>
	
	<!-- Set a link for each applicant -->
	
	<c:url var="deletelink" value="HandleControllerServlet">
	<c:param name="command" value="DELETE"/>
	<c:param name="handleId" value="${tempHandle.id}"/>
	</c:url>
	
	
	<tr>

	<td>${tempHandle.name}</td>
	<td>${tempHandle.address}</td>
	<td>${tempHandle.nic}</td>
	<td>${tempHandle.contact}</td>
	<td>${tempHandle.mail}</td>
	<td>${tempHandle.intDate}</td>
	<td>${tempHandle.intVenue}</td>
	<td>${tempHandle.tDate}</td>
	<td>${tempHandle.tVenue}</td>
	
	<td><a href="${templink}" class="btn btn-primary">UPDATE</a>
		<a href="${deletelink}"
		onclick="if (!(confirm('Are you sure you want to delete this Applicant?')))return false" class="btn btn-danger" role="button">
		DELETE</a>
	</td>
	</tr>
	
	</c:forEach>
	
	
	</table>
	</div>
	</div>

</body>
</html>