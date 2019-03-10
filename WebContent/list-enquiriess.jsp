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
    <li class="active">Enquiries</li>
    <li><a href="EventControllerServlet">Events</a></li>
  </ul>
  </div>
  

    
	<div class="container">
  <div class="jumbotron">
  
    	<form class="form-inline" method="post" action="searchEnquiries.jsp">
	<input id="date" type="date" name="date" />
	<button type="submit" name="save" class="btn btn-primary">Search</button>
	</form>
	<form class="form-inline" method="post" action="EnquiryReport">
	
	<button type="submit" name="save" class="btn btn-primary">Generate Enquiry report</button>
	</form>
		
			<table class="table table-striped table-hover">
    <thead class="thead-dark">
      <tr>
        <th>Date</th>
		<th>Head Count</th>
		<th>Name</th>
		<th>Email</th>
		<th>Contact No</th>
		<th>Description</th>
      </tr>
    </thead>
    
<c:forEach var="tempEnquiries" items="${ENQUIRIES_LIST}">
					
					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="EnquiriesControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="enquiriesId" value="${tempEnquiries.id}" />					
					</c:url>
    
    <tbody>
    <tr>
     <td> ${tempEnquiries.date} </td>
						<td> ${tempEnquiries.no_of_persons} </td>
						<td> ${tempEnquiries.name} </td>
						<td> ${tempEnquiries.email} </td>
						<td> ${tempEnquiries.contact_no} </td>
						<td> ${tempEnquiries.description} </td>
						<td> 
						<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this record?')))return false" class="btn btn-danger" role="button">
							Delete</a>
	</tr>						
    
    </c:forEach>
    </tbody>
  </table>
  </div>
  </div>

</body>
</html>