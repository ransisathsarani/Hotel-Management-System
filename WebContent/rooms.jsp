<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <html lang="en">
<head>
    <title>Add new Room</title>

   
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="StyleSheet1.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

 

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
        <li><a href="index.jsp">Home</a></li>
        <li class="active"><a href="rooms.jsp">Rooms</a></li>
       	<li><a href="Offers.jsp">Offers</a></li>
        <li><a href="RoomCategories.jsp">Room Categories</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
  
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Register with us</a></li>
      </ul>
    </div>
  </div>
</nav>

 


<div class="bg">
<form action="RoomControllerServlet" method="GET">
	<input type="hidden" name="command" value="ADD">
	<div class="container-fluid bg-3 text-left" style="background-color:#ffe6cc;width:500px;height:600px">   


        <h1>Add Rooms</h1>
        
 		<div class="form-group">
			<label>Room ID</label>
			<input type="text" class="form-control" name="RID" required>
		</div>
       
		<div class="form-group">
    <label>Room Category</label>
    <select class="form-control" id="category" name="category">
   	  <option value=""></option>
      <option value="Single">Single</option>
      <option value="Double">Double</option>
      <option value="Family">Family</option>
      
    </select>
  </div>						 
	
		 <div class="form-group">
    <label>Price(LKR)</label>
    <select class="form-control" id="price" name="price">						
				<option  value=""></option>
                <option  value="1000">1000</option>
                <option  value="1500">1500</option>
                <option  value="2000">2000</option>
                <option  value="2500">2500</option>
                <option  value="3000">3000</option>
                <option  value="3500">3500</option>
                <option  value="4000">4000</option>
                <option  value="4500">4500</option>
                <option  value="5000">5000</option>
                <option  value="5500">5500</option>
                <option  value="6000">6000</option>
                <option  value="6500">6500</option>
                <option  value="7000">7000</option>
                <option  value="7500">7500</option>
                <option  value="8000">8000</option>
                <option  value="8500">8500</option>
                <option  value="9000">9000</option>
                <option  value="9500">9500</option>
                <option  value="10000">10000</option> 
     </select>
    </div>
        
        	
		 <div class="form-group">
    <label>Status</label>
    <select class="form-control" id="status" name="status">						
				<option value=""></option>
                <option value="Available">Available</option>
                <option value="Not Available">Not Available</option>
               
     </select>
    </div>
       
	 
										
              
	 
				
    <div class="form-group">
       <center><button type="submit" class="btn"onclick="window.location.href='list-rooms.jsp'">Add</button></center>

    </div>
    </div>
    </form>
    </div>
   </body>
   <br><br>
 <footer style="float:left;width: 100%;background-color: #333333;color: white;text-align: center;padding-top: 5px;padding-bottom: 5px;margin-top: 10px" />Copyright 2018 @KANNELIYA FOREST RESORT.All rights reserved</footer>
</html>