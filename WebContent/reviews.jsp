<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reviews - Kanneliya Forest Resort</title>
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
      <a class="navbar-brand" href="adminlogin.jsp"><span class="glyphicon glyphicon-log-in"></span>Admin Login</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="#">Home</a></li>
        <li><a href="aboutUs.jsp">About Us</a></li>
        <li class="active"><a href="#">Reviews</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Register with us</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>Kanneliya Forest Resort</h4>
      <ul class="nav nav-pills nav-stacked">
        <li><a href="MainHome.jsp">Home</a></li>
        <li class="acive"><a href="#">Reviews</a></li>
        
      </ul><br>
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search Blog..">
        <span class="input-group-btn">
          <button class="btn btn-default" type="button">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </span>
      </div>
    </div>

    <div class="col-sm-9">
      <h4><small>Recent comments from clients</small></h4>
      <hr>
      <h2>Nice and Calm Place</h2>
      <h5><span class="glyphicon glyphicon-time"></span> Post by Dinesh D, April 26, 2018.</h5>
      <h5><span class="label label-danger">Holiday</span> <span class="label label-primary">Food</span></h5><br>
      <p>

I have been their two times. One of the very calm location. situated very close to Kanneliya Rain Forest. You can visit the Kanneliya Rain Forest. Hinidumma Kalvaari Church, Duwli Ella Waterfall Neluwa.
 Foods are very delicious and reasonable. Clean & lovely stream flows near the hotel. Safe to have a bath.</p>
      
     
      <hr>
      <h2>"Great place to stay and visi surrounding places"</h2>
      <h5><span class="glyphicon glyphicon-time"></span> Post by February 25, 2017.</h5>
      <h5><span class="label label-success">Travel</span></h5><br>
      <p></p>
      
      <h4>Leave a Comment:</h4>
      <form role="form">
        <div class="form-group">
          <textarea class="form-control" rows="3" required></textarea>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
      </form>
      <br><br>
      
    
      
      <div class="row">
        <div class="col-sm-2 text-center">
         
        </div>
       
        
       
      </div>
    </div>
  </div>
</div>

</body>
</html>