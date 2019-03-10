<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>

<head>
	<title>list reservations | Kanneliya Forest Resort</title>
	
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
     				 	<li><a href="rooms.jsp">Add Rooms</a></li>
     				 	<li><a href="RoomControllerServlet">Room List</a></li>
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


<div class="bg"></div>
 
    <div class="container">
        <h1>New Reservation Details</h1>


 
	 
		<input type="button" value="Add NewReservation"
			onclick="window.location.href='newReservation.jsp'; return false;"
			class="add-reservation-button"/>
								<div class="container">
								
<form class="form-inline" method="post" action="reservation_report_pdf">

<button type="submit" name="save" class="btn btn-primary">Generate Report</button>
</form>
<form class="form-inline" method="post" action="searchReservation.jsp"><br>
<input id="reserveID" type="text" name="reserveID" class="form-control" placeholder="Search ..">
<button type="submit" name="save" class="btn btn-primary">Search</button>
<br><br>
</form>
</div>
		
			<table class="table table-striped">
				<tr>
					
					<th>No</th>
					<th>Reservation ID</th>
					<th>RID</th>
					<th>Category</th>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>checkIn</th>
					<th>checkOut</th>
					<th>Days</th>
					<th>adults</th>
					<th>children</th>
					<th>advance</th>
					<th>slipNo</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempReservation" items="${RESERVATION_LIST}">

					<!-- set up a link for each record -->
					<c:url var="tempLink" value="ReservationControllerServlet" >
						<c:param name="command" value="LOAD" />
						<c:param name="reservationId" value="${tempReservation.id}" />
					</c:url>
					
					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="ReservationControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="reservationId" value="${tempReservation.id}" />					
					</c:url>
					 

					<tr> 
						<td> ${tempReservation.id} </td>
						<td> ${tempReservation.reserveID} </td>
						<td> ${tempReservation.RID}</td>
						<td> ${tempReservation.category}</td>
						<td> ${tempReservation.name} </td>
						<td> ${tempReservation.phone} </td>
						<td> ${tempReservation.email} </td>
						<td> ${tempReservation.checkIn} </td>
						<td> ${tempReservation.checkOut} </td>
						<td> ${tempReservation.days} </td>
						<td> ${tempReservation.adults} </td>
						<td> ${tempReservation.children} </td>
						<td> ${tempReservation.advance} </td>
						<td> ${tempReservation.slipNo} </td>
						
						<td> 
						<a href="${tempLink}">Update</a>
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