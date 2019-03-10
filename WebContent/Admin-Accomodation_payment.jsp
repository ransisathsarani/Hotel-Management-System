<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html>
<head>
<script>
function APaymentCalculations(){
	var day = document.getElementById("days").value;
	day= parseInt(day);
	var adv = document.getElementById("advance").value;
	adv= parseInt(adv);
	var sin = document.getElementById("singler").value;
	sin= parseInt(sin);
	var doub = document.getElementById("doubler").value;
	doub= parseInt(doub);
	var fam = document.getElementById("familyr").value;
	fam= parseInt(fam);
	var rest = document.getElementById("restaurant").value;
	rest= parseInt(rest);
	

	
	var total = 0;
	total = parseInt(total);
	 
	if(adv == 500){
		total = day*(1000*sin + 2000*doub + 5000*fam) + rest - 500;
	}
	else{
		total = day*(1000*sin + 2000*doub + 5000*fam) + rest;
		}
 	document.getElementById("netTotal").value = total ;
	
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Accommodation Payment Records</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#A93226">

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
    			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Restaurant
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
 	 <div style="background-color:white; width:1000px ; margin:0 auto ;height: 100% ; align:center ;">
  
  	<h3 align="center">Record Accommodation Payments </h3>
  	 
  			<form action="AccomodationPaymentControllerServelet" method="GET"> 	
 			<input type="hidden" name="command" value="ADD" />
 
  			
  <table width="950px" height="500px">
  <tr> <div class="form-group">
      <td><label for="client_ID">Reservation  ID :</label>
      <input type="text" class="form-control"  placeholder="Enter Client ID" name="RID" required> </td>
    </div>
   </tr>
 <tr> <div class="form-group">
      <td><label for="client_ID">Date :</label>
      <input type="date" class="form-control"  placeholder="Enter date" name="date" required> </td>
    </div>
   </tr>
 
  <tr>
     <div class="form-group">
      <td><label for="days">Number of Days at Stay :</label>
      <input type="number" class="form-control" id="days" placeholder="Enter number " name="days" required> </td>
    </div>
  </tr>
  <tr>
    <div class="form-group">
      <td><label for="extra_payments">Advance Payment done :</label>
	<select id="advance">
  <option value=500>500LKR</option>
  <option value=>None</option>
  </select>  
  </td>
  </tr>
  <tr>
    <div class="form-group">
      <td><label for="room_type">Room Type :</label></td></div><tr>
      
      <tr>
   
	  <td><label for="single">single:</label></td>
      <td><input type="number" class="form-control" id="singler" placeholder="Enter Amount" required> </td>
 	  <td><label for="double">double:</label></td>
      <td><input type="number" class="form-control" id="doubler" placeholder="Enter Amount" required> </td>
 	  <td><label for="family">family:</label></td>
      <td><input type="number" class="form-control" id="familyr" placeholder="Enter Amount" required> </td>
  </tr>
	
	<tr>
     <div class="form-group">
      <td><label for="restaurant_payments">Restaurant Payments to be done :</label>
      <input type="number" class="form-control" id="restaurant" placeholder="Enter Amount" name="restaurant" required > </td>
          </div>
    </tr>  
</div>
 
 <tr>
     <div class="form-group">
    <td align="center"><button type="button" class="btn btn-default" style="background-color: #e7e7e7;" onClick="APaymentCalculations()" >CALCULATE</button></td>
    </div>
  </tr>
  
  <tr>
     <div class="form-group">
      <td><label for="due">Total Payment :</label>
        <input type="text" class="form-control" id="netTotal" placeholder="Press calculate to load" name="total" > </td>
       </div>
  </tr>
  <tr>
  </tr>
   
   <tr>
     <div class="form-group">
    <td align="center"><button type="submit" class="btn btn-default" style="background-color: #e7e7e7;">PAID</button></td>
    </div>
  </tr>
  
  </table>
  </form>
</div>
</div>
</body>
</html>