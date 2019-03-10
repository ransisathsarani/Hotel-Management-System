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
<script>

</script>  
  
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
 	<li class="active"><a href="#">Add Event</a></li>
    <li ><a href="EnquiriesControllerServlet">Enquiries</a></li>
    <li><a href="EventControllerServlet">Events</a></li>
   
  </ul>
  </div>
  
  <div class="container">
  <h2>Event Form</h2>
  <form action="EventControllerServlet" method="GET">
  <input type="hidden" name="command" value="ADD" />
  
    <div class="form-group">
      <label for="date">Date:</label>
      <input type="date" id="date" class="form-control"  placeholder="yyyy-mm-dd" name="date" required>
    </div>
    <div class="form-group">
      <label for="type">Type:</label>
      <select class="form-control" id="type" name="type" required>
      <option value="wedding">Wedding</option>
      <option value="party">Party</option>
      <option value="conference">Conference</option>
      </select>
    </div>

    <div class="form-group">
      <label for="nic">NIC:</label>
      <input type="text" pattern="[a-zA-Z0-9\s]+$" class="form-control"  name="nic" required>
    </div>
        <div class="form-group">
      <label for="client_first_name ">First Name:</label>
      <input type="text" pattern="[a-zA-Z\s]+$" class="form-control" placeholder="Enter client's first name" name="client_first_name" required>
    </div>
        <div class="form-group">
      <label for="client_last_name">Last Name:</label>
      <input type="text" pattern="[a-zA-Z\s]+$" class="form-control" placeholder="Enter client's last name" name="client_last_name" required>
    </div>
    
        <div class="form-group">
      <label for="address">Address:</label>
      <input type="text" pattern="[a-zA-Z0-9/,\s]+$" class="form-control" placeholder="Enter address" name="address" required>
    </div>
    
        <div class="form-group">
      <label for="post_code">Post Code:</label>
      <input type="tel" pattern="^\d{4}$" class="form-control" placeholder="Enter post_code" name="post_code" required>
    </div>
    
        <div class="form-group">
      <label for="tel_no">Telephone No:</label>
      <input type="tel" pattern="^\d{10}$" class="form-control" placeholder="Enter telephone no" name="tel_no" required>
    </div>
    
        <div class="form-group">
      <label for="mobile_no">Mobile No:</label>
      <input type="tel" pattern="^\d{10}$" class="form-control" placeholder="Enter mobile no" name="mobile_no" required>
    </div>
    
        <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" placeholder="Enter email" name="email" required>
    </div>
    <div class="form-group">
      <label for="special_requests">Special Requests:</label>
      <input type="text" pattern="[a-zA-Z0-9:/,\s]+$" class="form-control" placeholder="Enter special requests" name="special_requests">
    </div>
        <div class="form-group">
      <label for="no_of_people">No Of People:</label>
      <input type="number" class="form-control" placeholder="Enter the no of people attending" id = "no_of_people"name="no_of_people" required>
    </div>
    
    <button type="submit" value="Save" class="btn btn-default save">Submit</button>
  </form>
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