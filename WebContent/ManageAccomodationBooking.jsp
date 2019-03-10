<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html lang="en">
<head>
    <title>Manage Accomodation Booking</title>

   
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="StyleSheet1.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
        <li><a href="CheckAvailability.jsp">Check Availability</a></li>
        <li><a href="Offers.jsp">Offers</a></li>
        <li><a href="RoomCategories.jsp">Room Categories</a></li>
      </ul>
      
    </div>
  </div>
</nav>

  


<div class="bg"></div>
<form>
    <div class="container" style="background-color:#ffeecc;width:350px;height:350px">
    <br><br><br>
        <center><h1><B>Successfully Booked!!!</B></h1></center>
        <br><br>

   </div>
    </form>
   
   

 </body>
</html>