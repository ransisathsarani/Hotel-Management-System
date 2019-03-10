<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Update Consumption | Kanneliya Forest Resort</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
function CalcCurrentStock(){
	var recieved = document.getElementById("recieved").value;
	recieved= parseInt(recieved);
	var weekCon = document.getElementById("weekCon").value;
	weekCon= parseInt(weekCon);
	
	

	
	var current = 0;
	current = parseInt(current);
	 
	if(weekCon == 0){
		current = recieved;
	}
	else{
		current = recieved - weekCon;
		}
 	document.getElementById("current").value = current ;
	
}

</script>
</head>
<body>

	<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#274F75;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>
      <div style="color:#ffffff;align:center"><h1>Update Consumption - Kanneliya Forest Resort</h1></div>
      
       <span>welcome <%=request.getAttribute("username") %>
<a href="<%=request.getContextPath() %>/logoutServlet">Logout</a></span>
   
      </div>
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
    </div>
    </div>
    

		<div style="background-color:black">
		<form action="InventoryControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			
			<input type="hidden" name="inventoryId" value="${THE_INVENTORY.id}" />
			
			<div class="container-fluid bg-3 text-left" style="background-color:#ffc299;width:550px;height:800px">
				
					<div class="form-group">
						<label>Date:</label>
						<input type="date" class="form-control" name="date" value="${THE_INVENTORY.date}">
					</div>
					
					<div class="form-group">
						<label>Description:</label>
						<input type="text" class="form-control" name="description" value="${THE_INVENTORY.description}"/>
					</div>
					
					
					<div class="form-group">
					
						<label>Vendor:</label>
						<input type="text" class="form-control" name="vendor" value="${THE_INVENTORY.vendor}"/>
					</div>
					<div class="form-group">
						<label>Invoice Number:</label>
						<input type="text" class="form-control" name="invoiceNum" value="${THE_INVENTORY.invoiceNum}"/>
					</div>
					<div class="form-group">
						<label>Recieved quantity:</label>
						<input type="text" class="form-control" id="recieved"name="recieved" value="${THE_INVENTORY.recieved}"/>
					</div>
					<div class="form-group">
						<label>Weekly consumption:</label>
						<input type="text" class="form-control" id="weekCon" name="weekCon" value="${THE_INVENTORY.weekCon}"/>
					</div>
				
				     <div class="form-group">
				    <button type="button" class="btn btn-default" style="background-color: #e7e7e7;" onClick="CalcCurrentStock()" >Current stock</button>
				   	</div>
				   	<div class="form-group">
				   	<label>Current stock :</label>
				        <input style="width:250px"type="text" class="form-control" placeholder="Press Current stock to load" id="current" name="current" value="${THE_INVENTORY.current}">
				    </div>
					
					<div class="form-group">
						<label></label>
						<input type="submit"  value="Save" class="save" />
					</div>
					
				</div>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="InventoryControllerServlet">Back to List</a>
		</p>
		 </div>


            

</body>
</html>