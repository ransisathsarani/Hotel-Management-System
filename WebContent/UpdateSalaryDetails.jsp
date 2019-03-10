<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Basic Needs- Kanneliya Forest Resort</title>
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
      					
    				</ul>-c
  		</li>
  		
      </ul>
      
    </div>
  </div>
</nav>

		<div class="container" >
		<h2>Update Payment</h2>
		 <form action="SalaryDetailsServlet" method="GET">
		 
		 	<input type="hidden" name="command" value="UPDATE" />
			
			<input type="hidden" name="salaryDetailsId" value="${THE_SALARYDETAILS.id}" />
		 
		 
		 
			<div class="container-fluid bg-3 text-left" style="width:100%;height:80%">  <!-- background-color:#6393B9; -->  
				<div class="form-group">
					<br>
				<div class="form-group">
      				<label>Employee ID :</label>
      				<input type="text" class="form-control" name="empid" value = "${THE_SALARYDETAILS.empid}">
    			</div>
    			<div class="form-group">
      				<label>Basic Salary :</label>
      				<input type="text" class="form-control" name="salary" value = "${THE_SALARYDETAILS.salary}">
    			</div>
				<div class="form-group">
      				<label>Over Time Rate:</label>
      				<input type="date" class="form-control"  name="otRates" value = "${THE_SALARYDETAILS.otRates}">
    			</div>
     
    			<div class="form-group">
      				<label>Over Time Hours:</label>
      				<input type="text" class="form-control"  name="otHours" value = "${THE_SALARYDETAILS.otHours}">
    			</div>
    			<div class="form-group">
      				<label>Bonus Payment:</label>
      				<input type="text" class="form-control"   name="bonusPayment" value = "${THE_SALARYDETAILS.bonusPayment}">
    			</div>
    			<div class="form-group">
      				<label>Panalty Payment:</label>
      				<input type="text" class="form-control"   name="panaltyPayment" value = "${THE_SALARYDETAILS.panaltyPayment}">
    			</div>
    			
				   
				    <button type="submit" class="btn btn-default">Save</button> </center>
				    <br>
				</div>
				</div>
			</div>

		</form>
		</div>
		



</body>
</html>