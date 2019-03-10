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

 
<title>New Reservation</title>

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
        <li class="active"><a href="newReservation.jsp">New Reservation</a></li>
       	<li><a href="Offers.jsp">Offers</a></li>
        <li><a href="RoomCategories.jsp">Room Categories</a></li>
      </ul>
      
    </div>
  </div>
</nav>


<div class="bg" style="background:url(images/reservation.jpg)repeat;width:100%;height: 100%;

        background-position: center;
        background-repeat: no-repeat;
        background-size: cover">
<form data-toggle="validator" role="form" action="ReservationControllerServlet" method="GET"> 
  <input type="hidden" name="command" value="ADD" />
  
			
			<input type="hidden" name="RID" value="${THE_ROOM.RID}" />
 
<div class="container-fluid bg-3 text-left" style="background-color:#ffeecc;width:900px;height:700px">  
 <center><h1>New Reservation</h1></center>
 
 <div class="form-row"> 
    <div class="form-group col-md-4">
      <label for="reserve_id">Reservation ID:</label>
      <input type="text" class="form-control" id="reserveID" placeholder="Enter Reservation ID" name="reserveID"   pattern="[A-Za-z]*[A-Za-z]*[0-9]*[0-9]" required>
    </div>
     <div class="form-group col-md-4">
      <label for="reserve_id">Room ID:</label>
      <input type="text" class="form-control" id="RID" placeholder="Room ID" name="RID" value="${THE_ROOM.RID}" disabled> 
    </div>
     <div class="form-group col-md-4">
      <label>Room Category</label>
    <select class="form-control" id="category" name="category">
   	  <option value=""></option>
      <option value="Single">Single</option>
      <option value="Double">Double</option>
      <option value="Family">Family</option>
      
    </select>
    </div>
  <div class="form-row"> 
    <div class="form-group col-md-4">
      <label for="guest_name">Guest Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" required>
    </div>
     <div class="form-group col-md-4">
      <label for="contact_no">Contact No:</label>
      <input type="tel" class="form-control" id="phone" placeholder="Enter contact no" name="phone"  pattern= "^\d{10}$" required >
    </div>
      <div class="form-group col-md-4">
      <label for="mail">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
    </div>
 <div class="form-row">
 <div class="form-group col-md-6">
      <label for="check_in">Check In:</label>
      <input type="date" class="form-control" id="checkIn" placeholder="YYYY-MM-DD" name="checkIn" required>
    </div>
     <div class="form-group col-md-6">
      <label for="check_out">Check Out:</label>
      <input type="date" class="form-control" id="checkOut" placeholder="YYYY-MM-DD" name="checkOut" required>
    </div>
    </div>
      <div class="form-row"> 
    <div class="form-group col-md-4">
     <label for="noOfDays">Number of Days:</label>
    <select class="form-control" id="days" name="days" >
   	  <option value="0">0</option>
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5">5</option>
      <option value="6">6</option>
      <option value="7">7</option>
      <option value="8">8</option>
      <option value="9">9</option>
      <option value="10">10</option>
    
      
      
    </select>
    </div>
      
    <div class="form-group  col-md-4">
      <label for="noOfAdults">Adults</label>
      <select class="form-control" id="adults" name="adults">
   	  <option value="0">0</option>
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>						
      <option value="4">4</option>
      <option value="5">5</option>
      <option value="6">6</option>
      <option value="7">7</option>
      <option value="8">8</option>
      <option value="9">9</option>
      <option value="10">10</option>
      <option value="11">11</option>
      <option value="12">12</option>
      <option value="13">13</option>
      <option value="14">14</option>
      <option value="15">15</option>
      <option value="16">16</option>
      <option value="17">17</option>
      <option value="18">18</option>
      <option value="19">19</option>
      <option value="20">20</option>
      
      
    </select>
    </div>
    <div class="form-group  col-md-4">
     <label for="noOfChildren">Children</label>
    <select class="form-control" id="children" name="children" >
   	  <option value="0">0</option>
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5">5</option>
      <option value="6">6</option>
      <option value="7">7</option>
      <option value="8">8</option>
      <option value="9">9</option>
      <option value="10">10</option>
      <option value="11">11</option>
      <option value="12">12</option>
      <option value="13">13</option>
      <option value="14">14</option>
      <option value="15">15</option>
      <option value="16">16</option>
      <option value="17">17</option>
      <option value="18">18</option>
      <option value="19">19</option>
      <option value="20">20</option>
      
      
    </select>
    </div>
    </div>
    
     <font color="#000066"><h5>  If you want to confirm your reservations please pay 500LKR to [96725646400 BOC] & enter bank payment slip number below field.</h5></font>
    
    
 <div class="form-row"> 
    <div class="form-group col-md-6">
    <label for="advancedPay">Advanced Payment(LKR):</label>
    <select class="form-control" id="advance" name="advance" >
   	  <option value="0"> </option>
      <option value="500">500</option>
      <option value="1000">1000</option>
      
      
   </select>
  </div>

  
      <div class="form-group col-md-6">
      <label for="bankSlip">Bank slip no:</label>
      <input type="text" class="form-control" id="slipNo"  placeholder="Enter bank slip no" name="slipNo" required>
    </div>
    </div>
   </div>  
  
    <center><button type="submit" class="btn">Submit</button></center><br>
    <center><button type="reset" class="btn">Reset</button></center>
    
    </div>
    </div>
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
document.getElementById("checkIn").setAttribute("min", today);


/////

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
   
</html>