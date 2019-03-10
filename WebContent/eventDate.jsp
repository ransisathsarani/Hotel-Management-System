<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select the event date | Kanneliya Forest Resort</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
     
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="#">Home</a></li>
        <li><a href="#">Wedding packages</a></li>
        <li class="active"><a href="#">Other events</a></li>
        <li><a href="#">Entertainment facilities</a></li>
        
        
      </ul>
       <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Register with us</a></li>
      </ul>
      
    </div>
  </div>
</nav>

<div style="background:url(images/table_deco.jpg)repeat;width:100%;height:600px">
<br><br><br><br><br><br>
<form>
<div class="container-fluid bg-3 text-left" style="background-color:#ffc299;width:500px;height:150px">    
 <div class="form-group">
      <label>Enter date:</label>
      <input type="date" class="form-control" placeholder="Enter date" name="date">
    </div>
    <div>
    
    <center><button type="reset" class="btn btn-default">Reset</button>
    <button type="submit" class="btn btn-default">Submit</button></center>
    
    
    </div>
   
</div>
</form>

</div>
<footer class="container-fluid text-center">
  <p>Footer</p>
</footer>
</body>
</html>