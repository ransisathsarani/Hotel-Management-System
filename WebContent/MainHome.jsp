 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home - Kanneliya Forest Resort</title>
<link rel="stylesheet" href="home.css">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
  .modal-header, h4, .close {
      background-color: #cc9900;
      color:#ffdf80 !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #cc9900;
  }
  </style>
</head>
<body style="background-color:black">
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
       <li><a href="adminLogin.jsp">Admin Login</a></li>
        <li class="active"><a href="#">Home</a></li>
        <li><a href="aboutUs.jsp">About Us</a></li>
        <li><a href="reviews.jsp">Reviews</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
    
        
        <li><a href="userSignup.jsp"><span class="glyphicon glyphicon-log-in"></span> Register with us</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="modal fade bannerformmodal" tabindex="-1" role="dialog" aria-labelledby="bannerformmodal" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Admin Login</h4>
        </div>
        <div class="modal-body">
          
          </div>    
      </div>
    </div>
  </div>
</div>
 

<div id="homeCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="homeCarousel" data-slide-to="0" class="active"></li>
      <li data-target="homeCarousel" data-slide-to="1"></li>
      <li data-target="homeCarousel" data-slide-to="2"></li>
      
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox" style="width:1300px;margin:25px">
      <div class="item active">
        <img src="images/main_entrance.JPG" alt="Image1" style="width:1400px;height:500px">
        <div class="carousel-caption">
          <h3>Welcome to Kanneliya Forest Resort</h3>
         
        </div>      
      </div>

      <div class="item">
        <img src="images/tunnel.JPG" alt="Image2" style="width:1400px;height:500px">
        <div class="carousel-caption">
          
          
        </div>      
      </div>
      <div class="item">
        <img src="images/back_1.JPG" alt="Image2" style="width:1400px;height:500px">
        <div class="carousel-caption">
          
          
        </div>      
      </div>
      
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
  
<div class="container text-center">    
  <h3 style="color:white">What We Do</h3><br>
  <div class="row">
    <div class="col-sm-3">
      <img src="images/cottage_1.jpg" class="img-responsive" style="width:300px;height:200px" alt="Image">
      <a href="CheckAvailability.jsp"><h3>Lodging</h3></a>
    </div>
    <div class="col-sm-3"> 
      <img src="images/seafood.Jpeg" class="img-responsive" style="width:300px;height:200px" alt="Image">
      <a href="#"><h3>Food and beverages</h3></a>   
    </div>
    <div class="col-sm-3">
      <img src="images/wedding.png" class="img-responsive" style="width:300px;height:200px" alt="Image">
      <a href="add-enquiries-form.jsp"><h3>Events</h3></a> 
    </div>
    <div class="col-sm-3">
      <img src="images/career.jpg" class="img-responsive" style="width:300px;height:200px" alt="Image">
      <a href="#"><h3>Career</h3></a> 
    </div>
  </div>
</div><br>

<footer class="container-fluid text-center">
  <p>Footer</p>
</footer>

</body>
</html>