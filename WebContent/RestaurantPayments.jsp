<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html>
<head>
 <script>
function RPaymentCalculations(){

	
	var mid = document.getElementById("menuId").value;
	
	var smid = document.getElementById("mID").value;
	
		
	var price = document.getElementById("price").value;
	price= parseInt(price);
	
	var quantity = document.getElementById("quantity").value;
	quantity= parseInt(quantity);
	
	
	
	var netTotal = document.getElementById("netTotal").value;
	netTotal= parseInt(netTotal);
	
	var allId = mid+"  "+smid;
	
	
	var stot = price*quantity;
	var tot = stot+netTotal;
	
	
	document.getElementById("subTotal").value = stot;
	document.getElementById("netTotal").value = tot;
	document.getElementById("mID").value = allId;
	
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Restaurant Payment Records</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <style>
body, html {
    height: 100%;
    margin: 0;
}

.bg {
    /* The image used */
    background-image: url("images/carrots-food-fresh-616404.jpg");

    /* Full height */
     height: 100%; 

    /* Center and scale the image nicely */
    background-position: center; 
    background-repeat: no-repeat;
     background-size: cover; 
}
</style>
  
  
</head>
<body>


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
      					<li><a href="#">salary payments</a>t</li>
     				 	<li><a href="#">Inventory payments</a></li>
      					
      					
    				</ul>
  		</li>
  		
      </ul>
      
    </div>
  </div>
</nav>

<div class="bg">

	 <div class="container">
 	 <div style="background-color:white; width:600px ; margin:0 auto ;height: 720px; align:center ;">
  
  	<h3 align="center">Record Restaurant Payments </h3>
  	 
  			<form action="RestaurantPaymentControllerServelet" method="GET"> 	
 			<input type="hidden" name="command" value="ADD" />
 
  		
 <div class="form-group">
    <label for="client_ID">Date :</label>
      <input type="date" class="form-control"  placeholder="Enter date" id="date" name="date" required> 
    </div>


 <div class="form-group">
      <label for="reserveId">Reservation ID :</label>
      <input type="text" class="form-control"  placeholder="Enter Reservation ID" pattern="[A-Za-z]*[A-Za-z]*[0-9]*[0-9]" name="reserveId" id="reserveId"  > 
    </div>
 
  
    <div class="form-group">
    <td><label for="menuId">Menu ID :</label>
	<input type="text" class="form-control"  placeholder="Enter Menu ID" id="menuId" name="menuId" required>
 	</td></div>
 	
 	 <div class="form-group">
    <td><label for="menuId">Price :</label>
	<input type="number" class="form-control" pattern= "^\d{4}$" placeholder="Enter price" id="price" name="price" required>
 	</td></div>
  
   <div class="form-group">
      <td><label for="number">Number of Items :</label>
      <input type="text" class="form-control"  placeholder="Enter the number of items" id="quantity" name="quantity" >
    </div>
   
 
     <div class="form-group">
   <button type="button" class="btn btn-default" style="background-color: #e7e7e7;" onClick="RPaymentCalculations()" >CALCULATE SUB TOTAL</button>
    </div>
    
    <div class="form-group">
      <label for="due">Sub Menu IDs' :</label>
        <input type="text" class="form-control" id="mID" name="mID" readonly> 
       </div>
    
    <div class="form-group">
      <label for="due">Sub Total (Rs.) :</label>
        <input type="text" class="form-control" id="subTotal" name="subTotal" placeholder="Press calculate sub total to load"  readonly> 
       </div>
       
  
     <div class="form-group">
      <label for="due">Total Payment (Rs.):</label>
        <input type="text" class="form-control" id="netTotal" value="0"name="total" placeholder="Press calculate to load"  readonly> 
       </div>

     <div class="form-group">
   <button type="submit" class="btn btn-default" style="background-color: #e7e7e7;">PAID</button>
    </div>

  
  </form>
</div>
</div>
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


</body>
</html>
