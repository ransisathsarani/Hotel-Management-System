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
    <li><a href="checkAvailability.jsp">Add Event</a></li>
    <li ><a href="list-enquiriess.jsp">Enquiries</a></li>
    <li class="active"><a href="#">Events</a></li>
  </ul>
  </div>
  
  <div class="container">
  <h2>Event Form</h2>
  <form action="EventControllerServlet" method="GET">
 <input type="hidden" name="command" value="UPDATE_BILL" />
			
			<input type="hidden" name="eventId" value="${THE_EVENT.id}" />
			
	<div class="form-group">
      <label for="no_of_people">No of people</label>
      <input type="text" class="form-control" name="no_of_people" value="${THE_EVENT.no_of_people}" readonly>
    </div>			
  
    <div class="form-group">
      <label for="resort_charges">Resort Charges:</label>
      <input type="text" class="form-control"  id = "resort_charges" name="resort_charges" value="${THE_EVENT.no_of_people * 600}" readonly >
    </div>

    <div class="form-group">
      <label for="accumulative_tax">Accumulative Tax:</label>
      <input type="text" class="form-control"  id = "accumulative_tax" name="accumulative_tax" value="${THE_EVENT.no_of_people * 600 * 0.3029}" readonly >
    </div>
 
    <div class="form-group">
      <label for="total">Total:</label>
      <input type="text" class="form-control" id = "total" name="total" value="${THE_EVENT.no_of_people * 600 * 1.3029}" readonly >
    </div>
    
        <div class="form-group">
      <label for="prepayment ">Prepayment:</label>
      <input type="text" class="form-control" id = "prepayment" name="prepayment" value="${THE_EVENT.no_of_people * 600 * 1.3029 * 0.5}" readonly >
    </div>
    
    <div class="form-group">
      <label for="payment_status ">Payment Status:</label>
      <input type="text" class="form-control" id = "payment_status" name="payment_status" value="${THE_EVENT.payment_status}" required>
    </div>
    
    <div class="form-group">
      <label for="payment_date ">Payment Date:</label>
      <input type="date" class="form-control" id = "payment_date" name="payment_date" value="${THE_EVENT.payment_date}" >
    </div>
       

    <button type="submit" value="Save" class="btn btn-default save">Submit</button>
  </form>
</div>
  
  

</body>
</html>