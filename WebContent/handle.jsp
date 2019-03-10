<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Handle Interview and trainig sessions - Kanneliya Forest Resort</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

<div style="background:url(images/employee2.jpeg)repeat;width:100%">


	<form method="GET" action="HandleControllerServlet">
	
 <input type="hidden" name="command" value="ADD" />   
 
<div class="container-fluid bg-3 text-left" style="background-color:#AEB6BF;width:500px;height:800px">    
 <div class="form-group">
      <label>Name:</label>
      <input type="text" class="form-control" placeholder="Enter Name" name="name" required>
    </div>
    <div class="form-group">
      <label>Address:</label>
      <input type="text" class="form-control" placeholder="Enter address" name="address" required>
    </div>
   
    <div class="form-group">
      <label>NIC:</label>
      <input type="text" class="form-control"  placeholder="Enter NIC" name="nic" pattern="[A-Za-z]*[A-Za-z]*[0-9]*[0-9]" required>
    </div>
   
    <div class="form-group">
      <label>Contact Number:</label>
      <input type="text" class="form-control"  placeholder="EnterContactNumber" name="contact" pattern="^\d{10}$" required>
    </div>
   
     <div class="form-group">
      <label>E-mail:</label>
      <input type="mail" class="form-control"  placeholder="Enter E-mail" name="mail" required>
    </div> 
    
    <div class="form-group">
      <label>Interview Date:</label>
     <input type="date" class="form-control" placeholder="Enter Name" name="intDate" id="date" required>
    </div>
    
     <div class="form-group">
      <label>Interview Venue:</label>
      <input type="text" class="form-control"  placeholder="Enter Interview Venue" name="intVenue" required>
    </div>
    
     <div class="form-group">
      <label>Training Date:</label>
     <input type="date" class="form-control" placeholder="Enter Name" name="tDate" id="date" required>
    </div>
    
     <div class="form-group">
      <label>Training Venue:</label>
      <input type="text" class="form-control"  placeholder="Enter Training Venue" name="tVenue" required>
    </div>
    
     <script>
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0!
		var yyyy = today.getFullYear();
			if(dd<10){
    			dd='0'+dd
			}
				if(mm<10){
    			mm='0'+mm
			}
			today = yyyy+'-'+mm+'-'+dd;
			document.getElementById("date").setAttribute("min", today);
	</script>
    
     <script>
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0!
		var yyyy = today.getFullYear();
			if(dd<10){
    			dd='0'+dd
			}
				if(mm<10){
    			mm='0'+mm
			}
			today = yyyy+'-'+mm+'-'+dd;
			document.getElementById("intDate").setAttribute("min", today);
	</script>
    
    
    <div style = "clear:both;"></div>
    <p><a href ="HandleControllerServlet">Back To List</a>
    
    
    <center>
    <button type="submit" value="submit" class="btn btn-default">Submit</button></center>
    
    
    </div>
</form>
</div>

<footer style="float:left;width: 100%;background-color: #333333;color: white;text-align: center;padding-top: 5px;padding-bottom: 5px;margin-top: 10px" />Copyright 2018 @KANNELIYA FOREST RESORT.All rights reserved</footer>
</body>
</html>