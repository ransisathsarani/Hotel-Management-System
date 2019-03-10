<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add monthly bill Info | Kanneliya Forest Resort</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>

	
	function CalcTotalBill(){
		var water = document.getElementById("water").value;
		water= parseFloat(water);
		
		var tel_1 = document.getElementById("tel_1").value;
		tel_1= parseFloat(tel_1);
		
		var tel_2 = document.getElementById("tel_2").value;
		tel_2= parseFloat(tel_2);
		
		var electricity = document.getElementById("electricity").value;
		electricity= parseFloat(electricity);
		
		var satellite = document.getElementById("satellite").value;
		satellite= parseFloat(satellite);
		
		var total = 0;
		total = parseFloat(total);
		
		
		
		total = water + tel_1 + tel_2 + electricity + satellite;
		document.getElementById("total").value = total ;
	 	
	 	
	 	if (total > 15000){
	 		window.alert("Total amount had exceeded Rs.15,000/=. Control the consumption!")
	 	}
		
	
}
</script>
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

<div style="background-color:#adadeb">
<form method="GET" action="BillsControllerServlet"> 
<input type="hidden" name="command" value="ADD" />  
<div class="container-fluid bg-3 text-left" style="background-color:white;width:500px;height:800px">    
 <div class="form-group">
      <label>Month:</label>
      <select class="form-control"  name="month">
     <option value="January">January</option>
   	  <option value="february">February</option>
   	  <option value="march">March</option>
   	  <option value="april">April</option>
   	  <option value="may">May</option>
   	  <option value="June">June</option>
   	  <option value="July">July</option>
   	  <option value="August">August</option>
   	  <option value="september">September</option>
   	  <option value="october">October</option>
   	  <option value="november">November</option>
   	  <option value="december">December</option>
   	  </select>
    </div>
    <div class="form-group">
      <label>Water bill amount:</label>
     <input type="text" class="form-control" placeholder="Enter bill amount" id="water" name="water" required>
     </div>
    
    <div class="form-group">
      <label>Telephone bill amount (1):</label>
     <input type="text" class="form-control" placeholder="Enter bill amount" id="tel_1" name="tel_1" required>
    </div>
    
    <div class="form-group">
      <label>Telephone bill amount(2):</label>
     <input type="text" class="form-control" placeholder="Enter bill amount" id="tel_2" name="tel_2" required>
    </div>
   
    <div class="form-group">
      <label>Electricity bill amount:</label>
     <input type="text" class="form-control" placeholder="Enter bill amount" id="electricity" name="electricity" required>
    </div>
    
    <div class="form-group">
      <label>Satellite bill amount:</label>
     <input type="text" class="form-control" placeholder="Enter bill amount" id="satellite" name="satellite" required>
    </div>
    
    <div class="form-group">
    <button type="button" class="btn btn-default" style="background-color: #e7e7e7;" onClick="CalcTotalBill()" >Calculate total</button>
   	</div>
   <div class="form-group">
   	<label>Total amount :</label>
        <input style="width:250px"type="text" class="form-control" placeholder="Press calculate" id="total" name="total" >
    </div>
    
    <div class="form-group">
      <label>Paying date:</label>
      <input type="date" class="form-control" id="pay_day" placeholder="Enter date" name="pay_day" required>
    </div>
     
     
    <div>
    
    <center><button type="reset" class="btn btn-default">Reset</button>
    <button type="submit" class="btn btn-default">Submit</button></center>
    
    
    </div>
</div>

</form>
</div>
<footer class="container-fluid text-center">
  <p>Footer</p>
</footer>
</body>
</html>