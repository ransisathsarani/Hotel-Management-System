<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html lang="en">
<head>
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="StyleSheet4.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title> Room Categories</title>
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
       <li><a href="MainHome.jsp">Home</a></li>
         <li><a href="CheckAvailability.jsp">Check Availability</a></li>

        <li><a href="Offers.jsp">Offers</a></li>
        <li class="active"><a href="RoomCategories.jsp">Room Categories</a></li>
      </ul>
    </div>
  </div>
</nav>
 

<div class="main">

    <h1>KANNELIYA FOREST RESORT</h1>
    <hr>

    <h2>ROOMS</h2>

    <div id="myBtnContainer">
        <button class="btn active" onclick="filterSelection('all')"> Show all</button>
        <button class="btn" onclick="filterSelection('single')"> Single Bed Rooms</button>
        <button class="btn" onclick="filterSelection('double')"> Double Bed Rooms</button>
        <button class="btn" onclick="filterSelection('family')"> Family Bed Rooms</button>

    </div>

    
    <div class="row">
    	<c:forEach var="tempRoom" items="${AVAILABLE_ROOM_LIST}">


<!-- set up a link for each record -->
					<c:url var="tempLink" value="RoomControllerServlet" >
						<c:param name="command" value="LOAD" />
						<c:param name="roomId" value="${tempRoom.id}" />
					</c:url>
			<div class="column single">
	            <div class="content">
	                <img src="images/singleRoom.jpg" alt="single" style="width:100%">
	                <h4>${tempRoom.RID}</h4>
	                <ul>
	                <li>${tempRoom.category} </li>
	                <li> ${tempRoom.price}</li>
	                <li> ${tempRoom.status}</li>
	                </ul>
	                <h4><b>Price for One Night: LKR 1500</b></h4>
	                  <a href="${tempLink}"><button type="submit" class="btn" onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button></a>
	            </div>
	        </div>
		</c:forEach>
        <div class="column single">
        
        	
            <div class="content">
                <img src="images/singleRoom.jpg" alt="single" style="width:100%">
                <h4>Single Bed Room-S001</h4>
                <ul>
                <li>Forest View</li>
                <li>Private bathroom</li>
                <li>Good breakfast included</li>
                </ul>
                <h4><b>Price for One Night: LKR 1500</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
        <div class="column single">
            <div class="content">
                <img src="images/singleRoom.jpg" alt="single" style="width:100%">
                <h4>Single Bed Room-S002</h4>
                 <ul>
               
                <li>Free WiFi</li>
                <li>Forest View</li>
                <li>Private bathroom</li>
                <li>Good breakfast included</li> 
                </ul>
                <h4><b>Price for One Night: LKR 1500</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
        <div class="column single">
            <div class="content">
                <img src="images/singleRoom.jpg" alt="single" style="width:100%">
                <h4>Single Bed Room-S003</h4>
                 <ul>
                 
                <li>Free WiFi</li>
                <li>Forest View</li>
                <li>Private bathroom</li>
                <li>Good breakfast included</li> 
                </ul>
                <h4><b>Price for One Night: LKR 100</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
          <div class="column single">
            <div class="content">
                <img src="images/singleRoom.jpg" alt="single" style="width:100%">
                <h4>Single Bed Room-S004</h4>
                 <ul>
                 
                <li>Free WiFi</li>
                <li>Forest View</li>
                <li>Private bathroom</li>
                <li>Good breakfast included</li> 
                </ul>
                <h4><b>Price for One Night: LKR 1500</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
         <div class="column single">
            <div class="content">
                <img src="images/singleRoom.jpg" alt="single" style="width:100%">
                <h4>Single Bed Room-S005</h4>
                <ul>
                <li>Forest View</li>
                <li>Private bathroom</li>
                <li>Good breakfast included</li>
                </ul>
                <h4><b>Price for One Night: LKR 1500</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>

		 <div class="column single">
            <div class="content">
                <img src="images/singleRoom.jpg" alt="single" style="width:100%">
                <h4>Single Bed Room-S006</h4>
                <ul>
                <li>Forest View</li>
                <li>Private bathroom</li>
                <li>Good breakfast included</li>
                </ul>
                <h4><b>Price for One Night: LKR 1500</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
        <div class="column double">
            <div class="content">
                <img src="images/doubleRoom.jpg" alt="double" style="width:100%">
                <h4>Double Bed Room-D001</h4>
                 <ul>
              	 
                <li>Free WiFi</li>
                <li>Forest View</li>
                <li>Private bathroom</li>
                <li>Good breakfast included</li> 
                </ul>
                <h4><b>Price for One Night: LKR 3000</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
        <div class="column double">
            <div class="content">
                <img src="images/doubleRoom.jpg" alt="double" style="width:100%">
                <h4>Double Bed Room-D002</h4>
                 <ul>
                
                <li>Free WiFi</li>
                <li>Forest View</li>
                <li>Private bathroom</li>
                <li>Good breakfast included</li> 
                </ul>
                <h4><b>Price for One Night: LKR 3000</b></h4>
                <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
        <div class="column double">
            <div class="content">
                <img src="images/doubleRoom.jpg" alt="double" style="width:100%">
                <h4>Double Bed Room-D003</h4>
                 <ul>
                 
                <li>Free WiFi</li>
                <li>Forest View</li>
                <li>Private bathroom</li>
                <li>Good breakfast included</li> 
                </ul>
                <h4><b>Price for One Night: LKR 3000</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
           <div class="column double">
            <div class="content">
                <img src="images/doubleRoom.jpg" alt="double" style="width:100%">
                <h4>Double Bed Room-D004</h4>
                 <ul>
                
                <li>Free WiFi</li>
                <li>Forest View</li>
                <li>Private bathroom</li>
                <li>Good breakfast included</li> 
                </ul>
                <h4><b>Price for One Night: LKR 3000</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
		  <div class="column double">
            <div class="content">
                <img src="images/doubleRoom.jpg" alt="double" style="width:100%">
                <h4>Double Bed Room-D005</h4>
                 <ul>
                
                <li>Free WiFi</li>
                <li>Forest View</li>
                <li>Private bathroom</li>
                <li>Good breakfast included</li> 
                </ul>
                <h4><b>Price for One Night: LKR 3000</b></h4>
                <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
          <div class="column double">
            <div class="content">
                <img src="images/doubleRoom.jpg" alt="double" style="width:100%">
                <h4>Double Bed Room-D006</h4>
                 <ul>
                
                <li>Free WiFi</li>
                <li>Forest View</li>
                <li>Private bathroom</li>
                <li>Good breakfast included</li> 
                </ul>
                <h4><b>Price for One Night: LKR 3000</b></h4>
                <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
        <div class="column family">
            <div class="content">
                <img src="images/FamilyRoom.jpg" alt="family" style="width:100%">
                <h4>Family Room-F001</h4>
                 <ul>
                <li>Forest View</li>
                <li>Free WiFi</li>
                <li>Private bathroom</li>
                <li>TV and Telephone</li>
                <li>Good breakfast included</li>
                </ul>
                <h4><b>Price for One Night: LKR 7000</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
        <div class="column family">
            <div class="content">
                <img src="images/FamilyRoom.jpg" alt="family" style="width:100%">
                <h4>Family Room-F002</h4>
                 <ul>
                <li>Forest View</li>
                <li>Free WiFi</li>
                <li>Private bathroom</li>
                <li>TV and Telephone</li>
                <li>Good breakfast included</li>
                </ul>
                <h4><b>Price for One Night: LKR 7000</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
        <div class="column family">
            <div class="content">
                <img src="images/FamilyRoom.jpg" alt="family" style="width:100%">
                <h4>Family Room-F003</h4>
                 <ul>
                <li>Forest View</li>
                <li>Free WiFi</li>
                <li>Private bathroom</li>
                <li>TV and Telephone</li>
                <li>Good breakfast included</li>
                </ul>
                <h4><b>Price for One Night: LKR 7000</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
         <div class="column family">
            <div class="content">
                <img src="images/FamilyRoom.jpg" alt="family" style="width:100%">
                <h4>Family Room-F004</h4>
                 <ul>
                <li>Forest View</li>
                <li>Free WiFi</li>
                <li>Private bathroom</li>
                <li>TV and Telephone</li>
                <li>Good breakfast included</li>
                </ul>
                <h4><b>Price for One Night: LKR 7000</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
         <div class="column family">
            <div class="content">
                <img src="images/FamilyRoom.jpg" alt="family" style="width:100%">
                <h4>Family Room-F005</h4>
                 <ul>
                <li>Forest View</li>
                <li>Free WiFi</li>
                <li>Private bathroom</li>
                <li>TV and Telephone</li>
                <li>Good breakfast included</li>
                </ul>
                <h4><b>Price for One Night: LKR 7000</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
         <div class="column family">
            <div class="content">
                <img src="images/FamilyRoom.jpg" alt="family" style="width:100%">
                <h4>Family Room-F006</h4>
                 <ul>
                <li>Forest View</li>
                <li>Free WiFi</li>
                <li>Private bathroom</li>
                <li>TV and Telephone</li>
                <li>Good breakfast included</li>
                </ul>
                <h4><b>Price for One Night: LKR 7000</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
         <div class="column family">
            <div class="content">
                <img src="images/FamilyRoom.jpg" alt="family" style="width:100%">
                <h4>Family Room-F007</h4>
                 <ul>
                <li>Forest View</li>
                <li>Free WiFi</li>
                <li>Private bathroom</li>
                <li>TV and Telephone</li>
                <li>Good breakfast included</li>
                </ul>
                <h4><b>Price for One Night: LKR 7000</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
         <div class="column family">
            <div class="content">
                <img src="images/FamilyRoom.jpg" alt="family" style="width:100%">
                <h4>Family Room-F008</h4>
                 <ul>
                <li>Forest View</li>
                <li>Free WiFi</li>
                <li>Private bathroom</li>
                <li>TV and Telephone</li>
                <li>Good breakfast included</li>
                </ul>
                <h4><b>Price for One Night: LKR 7000</b></h4>
                  <button type="submit" class="btn"onclick="window.location.href='newReservation.jsp'" >BOOK NOW</button>
            </div>
        </div>
        <!-- END GRID -->
    </div>

    <!-- END MAIN -->
</div>

<script>
    filterSelection("all")
    function filterSelection(c) {
        var x, i;
        x = document.getElementsByClassName("column");
        if (c == "all") c = "";
        for (i = 0; i < x.length; i++) {
            w3RemoveClass(x[i], "show");
            if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "show");
        }
    }

    function w3AddClass(element, name) {
        var i, arr1, arr2;
        arr1 = element.className.split(" ");
        arr2 = name.split(" ");
        for (i = 0; i < arr2.length; i++) {
            if (arr1.indexOf(arr2[i]) == -1) {element.className += " " + arr2[i];}
        }
    }

    function w3RemoveClass(element, name) {
        var i, arr1, arr2;
        arr1 = element.className.split(" ");
        arr2 = name.split(" ");
        for (i = 0; i < arr2.length; i++) {
            while (arr1.indexOf(arr2[i]) > -1) {
                arr1.splice(arr1.indexOf(arr2[i]), 1);
            }
        }
        element.className = arr1.join(" ");
    }


    // Add active class to the current button (highlight it)
    var btnContainer = document.getElementById("myBtnContainer");
    var btns = btnContainer.getElementsByClassName("btn");
    for (var i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", function(){
            var current = document.getElementsByClassName("active");
            current[0].className = current[0].className.replace(" active", "");
            this.className += " active";
        });
    }
</script>

</body>
 <footer style="float:left;width: 100%;background-color: #333333;color: white;text-align: center;padding-top: 5px;padding-bottom: 5px;margin-top: 10px" />Copyright 2018 @KANNELIYA FOREST RESORT.All rights reserved</footer>
</html>