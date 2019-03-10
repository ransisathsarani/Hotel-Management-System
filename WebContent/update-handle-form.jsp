<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kanneliya Forest Resort</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<style>


    .bg{
        background-image: url("images/A14.jpg");
        height: 100%;
       
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>

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

<!--  <div style="background:url(images/employee.jpg)repeat;width:100%">-->

<div style="background:url(images/employee1.jpg)repeat;width:100%">


	<form method="GET" action="HandleControllerServlet">
	
	<div class="container-fluid bg-3 text-left" style="background-color:#E5E8E8  ;width:750px;height:800px">
	
	
 <input type="hidden" name="command" value="UPDATE" />
 <input type="hidden" name="handleId" value="${THE_HANDLE.id}" />
    
<div class="container-fluid bg-3 text-left" style="background-color:#E5E8E8  ;width:750px;height:800px">
	
	
 <div class="form-group">
      <label>Name:</label>
      <input type="text" class="form-control" name="name" value="${THE_HANDLE.name}"/>
    </div>
    <div class="form-group">
      <label>Address:</label>
      <input type="text" class="form-control"  name="address" value="${THE_HANDLE.address}"/>
    </div>
   
    <div class="form-group">
      <label>NIC:</label>
      <input type="text" class="form-control"  name="nic" value="${THE_HANDLE.nic}"/>
    </div>
   
    <div class="form-group">
      <label>Contact Number:</label>
      <input type="text" class="form-control"  name="contact" value="${THE_HANDLE.contact}"/>
    </div>
   
     <div class="form-group">
      <label>E-mail:</label>
      <input type="text" class="form-control"   name="mail" value="${THE_HANDLE.mail}"/>
    </div> 
    
    <div class="form-group">
      <label>Interview Date:</label>
     <input type="date" class="form-control"  name="intDate" value="${THE_HANDLE.intDate}"/>
    </div>
    
     <div class="form-group">
      <label>Interview Venue:</label>
      <input type="text" class="form-control"   name="intVenue" value="${THE_HANDLE.intVenue}"/>
    </div>
    
     <div class="form-group">
      <label>Training Date:</label>
     <input type="date" class="form-control"  name="tDate" value="${THE_HANDLE.tDate}"/>
    </div>
    
     <div class="form-group">
      <label>Training Venue:</label>
      <input type="text" class="form-control"   name="tVenue" value="${THE_HANDLE.tVenue}"/>
    </div>
    
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