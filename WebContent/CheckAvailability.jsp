<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html lang="en">
<head>
    <title> Check Availability</title>

   
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="StyleSheet1.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

</head>
<style>


    .bg{
        background-image: url("images/reservation.jpg");
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
        <li class="active"><a href="CheckAvailability.jsp">Check Availability</a></li>
        <li><a href="Offers.jsp">Offers</a></li>
        <li><a href="RoomCategories.jsp">Room Categories</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="bg"></div>
<form class="form-inline" method="get" action="RoomControllerServlet">
    <div class="container" style="background-color:#ffeecc;width:600px;height:350px">

    
        <center><h1>Book a Room</h1></center>
        
          <div class="form-group">
			<label>Check in   :</label>
			<input type="date" id="checkIn" class="form-control" placeholder="YYYY-MM-DD" name="checkIn" required>
		</div>
		

         <div class="form-group">
			<label>Check out :</label>
			<input type="date" id="checkOut" class="form-control" placeholder="YYYY-MM-DD" name="checkOut" required>
		</div>
 
<center><button type="submit" name="save" class="btn">GET THE BEST RATES</button></center><br>
 </div>
    </form>
           

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
document.getElementById("checkIn").setAttribute("min", today);

////


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
document.getElementById("checkOut").setAttribute("min", today);
</script>  
     

</body>


 <footer style="float:left;width: 100%;background-color: #333333;color: white;text-align: center;padding-top: 5px;padding-bottom: 5px;margin-top: 10px" />Copyright 2018 @KANNELIYA FOREST RESORT.All rights reserved</footer>
</html>









