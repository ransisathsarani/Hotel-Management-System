<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html lang="en">
<head>
    <title>Application</title>

   
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="StyleSheet1.css" rel="stylesheet" type="text/css">
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

    
    <!--  <div class="bg"></div>-->

<div style="background:url(images/employee1.jpg)repeat;width:100%">


	<form method="GET" action="ApplicationControllerServlet">
	
 <input type="hidden" name="command" value="ADD" />
 
    
	<div class="container-fluid bg-3 text-left" style="background-color:#E5E8E8  ;width:750px;height:800px">
	
	<!--  <div class="bg"></div>-->
            
 	<div class="form-group">
  	<label>Name:</label>
    <input type="text" class="form-control" title="Numbers cannot be input as a Name" placeholder="Enter Name" name="name"  required>
    </div>
    
    <div class="form-group">
    <label>Address:</label>
    <input type="text" class="form-control" placeholder="Enter address" name="address"  required>
    </div>
   
    <div class="form-group">
      <label>NIC:</label>
      <input type="text" class="form-control"  placeholder="Enter NIC" name="nic" pattern="[A-Za-z]*[A-Za-z]*[0-9]*[0-9]" required>
    </div>
   
    <div class="form-group">
      <label>Contact Number:</label>
      <input type="number" class="form-control"  placeholder="EnterContactNumber" name="contact" pattern="^\d{10}$" required>
    </div>
   
     <div class="form-group">
      <label>E-mail:</label>
      <input type="email" class="form-control"  placeholder="Enter E-mail" name="mail" required>
    </div> 
    
    <div class="form-group">
      <label>Gender:</label>
    
    <select class="form-control" placeholder="Gender" name="gender" >
    <option selected disabled>Gender:</option>
	<option value="male">Male</option>
	<option value="female">Female</option>

</select>
</div>

    
     <div class="form-group">
      <label>Educational Qualification:</label>
     <input type="text" class="form-control" placeholder="Enter Educational Qualifications" name="edu_qualifi" required>
    </div>
    
     <div class="form-group">
      <label>Job Experience:</label>
      <input type="text" class="form-control"  placeholder="Enter Training Venue" name="job_exp" required>
    </div>
   
    <center>
   <button type="submit" class="btn btn-default">Submit</button>
    </center>
  
  	</div>
    </form>
    </div>
    
    
 <footer style="float:left;width: 100%;background-color: #333333;color: white;text-align: center;padding-top: 5px;padding-bottom: 5px;margin-top: 10px" />Copyright 2018 @KANNELIYA FOREST RESORT.All rights reserved</footer>
 </body>
</html>