<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="StyleSheet1.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

 
<title>Enquiries</title>

</head>

<style>

.bg{
        background-image: url("poruwa.JPG");
        height: 100%;

        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<body>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#Navbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      
</div>
     
    
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
       <li><a href="" data-toggle="modal" data-target=".bannerformmodal"><span class="glyphicon glyphicon-log-in"></span>Admin Login</a></li>
      <li><a href="MainHome.jsp">Home</a></li>
      <li><a href="CheckAvailability.jsp">Accomodation</a></li>
      <li class="active">Events</li>
      <li><a href="#">Restaurant</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
  
        <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Register with us</a></li>
      </ul>
    </div>
  </div>
</nav>


<div class="bg" style="background:url(poruwa.JPG)repeat;width:100%;height: 100%;

        background-position: center;
        background-repeat: no-repeat;
        background-size: cover">
        
<div class="container-fluid bg-3 text-left" style="background-color:#ffeecc;width:500px;height:600px">        
<h2>Enquiry</h2>
  <form action="EnquiriesControllerServlet" method="GET">
  <input type="hidden" name="command" value="ADD">
  
    <div class="form-group">
      <label for="date">Date:</label>
      <input id="date" type="date" name="date" class="form-control" placeholder="mdd/mm/yyyy" required/>
    </div>
    <div class="form-group">
      <label for="no_of_persons">No of Persons:</label>
      <input type="number" class="form-control" placeholder="Enter no of persons" name="no_of_persons" required>
    </div>
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" pattern="[a-zA-Z\s]+$" class="form-control" placeholder="eg:- Mary & Tom" name="name" required>
    </div>
        <div class="form-group">
      <label for="email ">Email:</label>
      <input type="email" class="form-control" placeholder="Enter email " name="email" required>
    </div>
        <div class="form-group">
      <label for="contact_no">Contact No:</label>
      <input type="tel" pattern="^\d{10}$" class="form-control" placeholder="Enter contact_no" name="contact_no" required>
    </div>
    
        <div class="form-group">
      <label for="description">Description:</label>
      <input type="text" pattern="[a-zA-Z0-9/,\s]+$" class="form-control" placeholder="Enter description" name="description" required>
    </div>

    <button type="submit" value="Save" class="btn btn-default save">Submit</button>
  </form>
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