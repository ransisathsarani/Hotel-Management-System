q<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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

 

	<form method="GET" action="EmployeeControllerServlet">
  	
 <!--  <input type="hidden" name="command" value="ADD" />-->
 
  <input type="hidden" name="command" value="VIEW" />
 <input type="hidden" name="employeeId" value="${THE_EMPLOYEE_1.id}" />
    
<div class="container-fluid bg-3 text-left" style="background-color:#FFFFFF;width:500px;height:800px">    
<!--  --> <div class="form-group">
 
 
 	  <!--  <div class="form-group row">
    	<label for="staticEmail" class="col-sm-2 col-form-label">Employee ID:</label>
    	<div class="col-sm-10">
      	<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="email@example.com">
   		</div>
  	</div>-->
  
      <label>Employee ID:</label>
      <input type="text" class="form-control" name="empid" value="${THE_EMPLOYEE_1.empid}" readonly/>
    </div>
    <div class="form-group">
    
      <label>Name:</label>
      <input type="text" class="form-control"  name="name" value="${THE_EMPLOYEE_1.name}" readonly/>
    </div>
    
   
    <div class="form-group">
      <label>NIC:</label>
      <input type="text" class="form-control"  name="nic" value="${THE_EMPLOYEE_1.nic}" readonly/>
    </div>
   
     <div class="form-group">
      <label>Contact Number:</label>
      <input type="text" class="form-control"  name="contact" value="${THE_EMPLOYEE_1.contact}" readonly/>
    </div>
   
     <div class="form-group">
      <label>E-mail:</label>
      <input type="text" class="form-control"   name="mail" value="${THE_EMPLOYEE_1.mail}" readonly/>
    </div> 
    
    <div class="form-group">
      <label>Gender:</label>
     <input type="text" class="form-control"  name="gender" value="${THE_EMPLOYEE_1.gender}" readonly/>
    </div>
    
     <div class="form-group">
      <label>Job Title:</label>
      <input type="text" class="form-control"   name="job_title" value="${THE_EMPLOYEE_1.job_title}" readonly/>
    </div>
    
     <div class="form-group">
      <label>salary:</label>
     <input type="text" class="form-control"  name="salary" value="${THE_EMPLOYEE_1.salary}" readonly/>
    </div>
    
     <div class="form-group">
      <label>Department:</label>
      <input type="text" class="form-control"   name="department" value="${THE_EMPLOYEE_1.department}" readonly/>
    </div>
    
       <div class="form-group">
      <label>Appoinment Date:</label>
      <input type="date" class="form-control"   name="appointmentDate" value="${THE_EMPLOYEE_1.appointmentDate}" readonly/>
    </div>
    
     <div class="form-group">
      <label>Address:</label>
      <input type="text" class="form-control"   name="address" value="${THE_EMPLOYEE_1.address}" readonly/>
    </div>
    
   
  </form>
</div>

 <footer style="float:left;width: 100%;background-color: #333333;color: white;text-align: center;padding-top: 5px;padding-bottom: 5px;margin-top: 10px" />Copyright 2018 @KANNELIYA FOREST RESORT.All rights reserved</footer>
</body>
</html>