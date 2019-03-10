<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
  
 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Kanneliya Forest Resort</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="index.jsp">Home</a></li>
      <li><a href="#">Inventory</a></li>
      <li><a href=ReservationControllerServlet>Accomodation</a></li>
      <li><a href="#">Staff</a></li>
      <li class="active">Events</li>
      <li><a href="#">Restaurant</a></li>
      <li><a href="#">Client Finance</a></li>
      <li><a href="#">Resort Finance</a></li>
    </ul>
  </div>
</nav>

<div class="container" style="margin-bottom: 20px;">
<ul class="nav nav-tabs">
    <li><a href="checkAvailability_event.jsp">Add Event</a></li>
    <li><a href="EnquiriesControllerServlet">Enquiries</a></li>
    <li class="active"><a href="#">Events</a></li>
  </ul>
  </div>
      <div class="jumbotron jumbotron-fluid">
	<div class="container">
	
	<form class="form-inline" method="post" action="search_event.jsp">
	<input id="date" type="date" name="date" />
	<button type="submit" name="save" class="btn btn-primary">Search</button>
	</form>

		
			<div class="table-responsive">		
			<table class="table table-striped table-hover">
    <thead class="thead-dark">
      <tr>
					<th>Date</th>
					<th>Type</th>
					<th>Nic</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>Post Code</th>
					<th>Contact No</th>
					<th>Mobile No</th>
					<th>Email</th>
					<th>Head Count</th>
					<th>Requests</th>
				</tr>

    </thead>
    
<c:forEach var="tempEvent" items="${EVENT_LIST}">

					<!-- set up a link for each record -->
					<c:url var="billLink" value="EventControllerServlet" >
						<c:param name="command" value="BILL" />
						<c:param name="eventId" value="${tempEvent.id}" />
					</c:url>
					
					<!-- set up a link for each record -->
					<c:url var="menuLink" value="EventControllerServlet" >
						<c:param name="command" value="MENU" />
						<c:param name="eventId" value="${tempEvent.id}" />
					</c:url>

					<!-- set up a link for each record -->
					<c:url var="tempLink" value="EventControllerServlet" >
						<c:param name="command" value="LOAD" />
						<c:param name="eventId" value="${tempEvent.id}" />
					</c:url>
					
					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="EventControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="eventId" value="${tempEvent.id}" />					
					</c:url>
    
    <tbody>
    <tr>
     					<td> ${tempEvent.date} </td>
						<td> ${tempEvent.type} </td>
						<td> ${tempEvent.nic} </td>
						<td> ${tempEvent.client_first_name} </td>
						<td> ${tempEvent.client_last_name} </td>
						<td> ${tempEvent.address} </td>
						<td> ${tempEvent.post_code} </td>
						<td> ${tempEvent.tel_no} </td>
						<td> ${tempEvent.mobile_no} </td>
						<td> ${tempEvent.email} </td>
						<td> ${tempEvent.no_of_people} </td>
						<td> ${tempEvent.special_requests} </td>
						<td>
						<a href="${billLink}" class="btn btn-primary">Bill</a>
						<a href="${menuLink}" class="btn btn-primary">Menu</a>
						<a href="${tempLink}" class="btn btn-primary">Update</a>
						<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this record?')))return false" class="btn btn-danger" role="button">
							Delete</a>
							</td>
	</tr>						
    
    </c:forEach>
    </tbody>
  </table>
  </div>
  </div>
  </div>

</body>
</html>