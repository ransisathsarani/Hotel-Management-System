<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="StyleSheet3.css" rel="stylesheet" type="text/css">
    
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
 
    <title> Offers</title>
</head>

<body style="background:#ffeecc">

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
        <li class="active"><a href="Offers.jsp">Offers</a></li>
        <li><a href="RoomCategories.jsp">Room Categories</a></li>
      </ul>
    </div>
  </div>
</nav>

 

<div class="coupon" style="background-color: white">
    <div class="col-md-12" style="background-color: white">
        <h3>KANNELIYA FOREST RESORT - SINGLE  BED ROOMS</h3>
    </div>
    <img src="images/singleRoom.jpg" alt="image" style="width:100%;">
    <div class="col-md-12" style="background-color: white" >
        <h2><b>Stay 4 Pay 3</b></h2>
        <p>Stay Four nights at Kanneliya Forest Resort and your last night is free.</p>
        <p>In addition,you'll also enjoy:</p>
        <ul>
            <li>Daily special menu </li>
            <li>Free unlimited Wi-Fi</li>
        </ul>
    </div>
    <div class="coupon" style="background-color: white">
        <p>Per night: <span class="promo">LKR 1500</span></p>
        <p class="expire">Expires: November 03, 2018</p>
        <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
    </div>
</div>

<br>


<div class="coupon" style="background-color: white">
    <div class="col-md-12" style="background-color: white">
        <h3>KANNELIYA FOREST RESORT - DOUBLE BED ROOMS</h3>
    </div>
    <img src="images/doubleRoom.jpg" alt="image" style="width:100%;">
    <div class="col-md-12" style="background-color: white">
        <h2><b>Stay 3 Pay 2</b></h2>
        <p>Stay three nights at Kanneliya Forest Resort and your last night is free.</p>
        <p>In addition,you'll also enjoy:</p>
        <ul>
            <li>Daily special menu </li>
            <li>Free unlimited Wi-Fi</li>
        </ul>
    </div>
    <div class="coupon" style="background-color: white">
        <p>Per night: <span class="promo">LKR 3000</span></p>
        <p class="expire">Expires: October 09, 2018</p>
           <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
    </div>
</div>

<br><br><br>


<div class="coupon" style="background-color: white">
    <div class="col-md-12" style="background-color: white">
        <h3>KANNELIYA FOREST RESORT - FAMILY ROOMS</h3>
    </div>
    <img src="images/FamilyRoom.jpg" alt="image" style="width:100%;">
    <div class="col-md-12" style="background-color: white">
        <h2><b>Stay 3 Pay 2</b></h2>
        <p>Stay three nights at Kanneliya Forest Resort and your last night is free.</p>
        <p>In addition,you'll also enjoy:</p>
        <ul>
            <li>Daily special menu </li>
            <li>Free unlimited Wi-Fi</li>
        </ul>
    </div>
    <div class="coupon" style="background-color: white">
        <p>Per night: <span class="promo">LKR 7000</span></p>
        <p class="expire">Expires: October 29, 2018</p>
        <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
    </div>
</div>
<br>
<br><br><br><br><br>
 


</body>
 <footer style="float:left;width: 100%;background-color: #333333;color: white;text-align: center;padding-top: 5px;padding-bottom: 5px;margin-top: 10px" />Copyright 2018 @KANNELIYA FOREST RESORT.All rights reserved</footer>
</html>