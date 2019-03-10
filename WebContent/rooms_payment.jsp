<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Admin Accommodation Payment Records</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body style="background-color:#A93226">
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
      					<li><a href="#">Shifts and schedules</a></li>
     				 	<li><a href="#">Salary </a></li>
      					<li><a href="#">Basic needs</a></li> 
      					<li><a href="#">Vacancies handling</a></li> 
      					<li><a href="#">Applicant handling</a></li> 
      					<li><a href="#">Interview and training sessions</a></li> 
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
	<div class="container">
	<div style="background-color:white; width:650px ; margin:0 auto ;height: 100% ; align:center ;">
	
	<h3 align="center">Record Accommodation Payments </h3> 
	<form action="/acc_pay.jsp">
	
	
	 <div class="form-group">
	<label for="client_ID">Client ID :</label>
	<input type="text" class="form-control" id="client_ID" placeholder="Enter Client ID" name="client_ID">
	</div>
	
	<div class="form-group">
      <label>Room ID:</label>
      <input type="text" class="form-control"  placeholder="Enter room id" name="room_id">
    </div>
	
	
	<div class="form-group">
	<label>Number of Days at Stay :</label>
	<input type="text" class="form-control" id="days" placeholder="press Load to load" name="days"> 
		</div>

	
	<div class="form-group">
	<label>Extra Payments to be done :</label>
	<input type="text" class="form-control" id="extra" placeholder="press Load to load" name="extra"> 
		</div>
	
	
	<div class="form-group">
	<label>Advance Payment done :</label>
	<input type="number" class="form-control" id="advance" placeholder="press Load to load" name="advance"> 
	</div>
	
	<div class="form-group">
	<label for="due">Due Payment :</label>
	<input type="number" class="form-control" id="due" placeholder="press Load to load" name="due"> </td>
	</div>
	
	<div class="form-group">
	<label for="total">Total Amount to be Paid:</label>
	<input type="number" class="form-control" id="total" placeholder="press Load to load" name="total"> </td>
	</div>
	<div>
	<center>
	<button type="submit" class="btn btn-default" >PAID</button>
	<button type="submit" class="btn btn-default" >ISSUE INVOICE</button>
	<button type="submit" class="btn btn-default" style="background-color: #e7e7e7;">Load Details</button>
	</center>
	</div>
	
	
	</form>
	</div>
	</div><
	</body>
	</html>
