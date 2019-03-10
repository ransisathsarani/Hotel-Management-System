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


<div class="bg"></div>
 
    <div class="container">
        <h1>New Room Details</h1>


 	<div class="container">
	 <div class="col-xs-6 col-sm-3">
		<input type="button" value="Add Room"
			onclick="window.location.href='rooms.jsp'; return false;"
			class="btn btn-primary"/>
				
	</div>				
	<form class="form-inline" method="post" action="rooms_pdf">
<button type="submit" name="save" href=" class="btn btn-primary">Generate Report</button>
</form>

<form class="form-inline" method="post" action="searchRoom.jsp"><br>
<input id="RID" type="text" name="RID" class="form-control" placeholder="Search by room id ..">
<button type="submit" name="save" class="btn btn-primary">Search</button>
</form>
</div>
		
			<table class="table table-striped">
			<thread>
				<tr>
					
					<th>RID</th>
					<th>category</th>
					<th>price</th>
					<th>status</th>
					<th>Action</th>
					
					 
				</tr>
				</thread>
				<c:forEach var="tempRoom" items="${ROOM_LIST}">

					<!-- set up a link for each record -->
					<c:url var="tempLink" value="RoomControllerServlet" >
						<c:param name="command" value="LOAD" />
						<c:param name="roomId" value="${tempRoom.id}" />
					</c:url>
					
					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="RoomControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="roomId" value="${tempRoom.id}" />					
					</c:url>
					 

					<tr> 
					
						<td> ${tempRoom.RID} </td>
						<td> ${tempRoom.category} </td>
						<td> ${tempRoom.price} </td>
						<td> ${tempRoom.status} </td>
						
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