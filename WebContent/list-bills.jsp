<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html>

<head>
	<title>List Inventory | kanneliya Forest Resort</title>
	<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
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
<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#274F75;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>

      <div style="color:#ffffff;align:center"><h3>List Inventory - Kanneliya Forest Resort</h3></div>
      
<a href="<%=request.getContextPath() %>/logoutServlet">Logout</a></span>
      <br />
      </div>
      <div style="background-color:#ffff66">

    </div>
    </div>
    </div>
    
   <div align="center">
		
		
		
		<input type="button" value="Add Bill payments"
			onclick="window.location.href='add-bill-info.jsp'; return false;"
			class="add-bills-button"/>
		<div class="container">
		<div class="col-xs-6 col-sm-6">
<form class="form-inline" method="post" action="searchBills.jsp">
<select class="form-control"  name="month">
<option value="January">January</option>
<option value="February">February</option>
<option value="March">March</option>
<option value="April">April</option>
<option value="May">May</option>
<option value="June">June</option>
<option value="July">July</option>
<option value="August">August</option>
<option value="September">September</option>
<option value="October">October</option>
<option value="November">November</option>
<option value="December">December</option>
</select>
<button type="submit" name="save" class="btn btn-primary">Search</button>
</form>
</div>
<div class="col-xs-6 col-sm-6">

</div>
</div>
</div>

<div class="container-fluid bg-3">

<h3>Bills list - Kanneliya Forest Resort</h3>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Month</th>
        <th>Water bill</th>
       
        <th>Telephone (1)</th>
        
        <th>Telephone (2)</th>
        
        <th>Electricity bill</th>
        
        <th>Satellite bill</th>
        
        <th>Total payments</th>
         <th>Payment date</th>
       
      
      </tr>
    </thead>

	 
			
  



</div>
				
				<c:forEach var="tempBill" items="${BILL_LIST}">

					<!-- set up a link for each record -->
					<c:url var="tempLink" value="BillsControllerServlet" >
						<c:param name="command" value="LOAD" />
						<c:param name="billId" value="${tempBill.id}" />
					</c:url>
					
					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="BillsControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="billId" value="${tempBill.id}" />					
					</c:url>

					<tr>
						<td> ${tempBill.month} </td>
						<td> ${tempBill.water} </td>
						
						<td> ${tempBill.tel_1}</td>
						
						<td> ${tempBill.tel_2} </td>
						
						<td> ${tempBill.electricity} </td>
						
						<td> ${tempBill.satellite} </td>
						
						<td>${tempBill.total}</td>
						<td>${tempBill.pay_day}</td>
						
						
						<td> 
						
						<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this record?')))return false">
							Delete</a> 
						</td>
					</tr>
				</c:forEach>
			
			</table>
			</div>

   
    
    
		
		
		  
</body>


</html>