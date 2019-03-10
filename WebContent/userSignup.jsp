<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guest registration | Kanneliya Forest Resort</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<style type="text/css">
    body
{
    padding: 10px;
    font-family: Arial;
    Font-size: 10pt;
}
span
{
    font-weight:bold;
}

.san{
    height: 26px;
    width: 250px;
    border: 1px solid #9E9E9E;
    padding: 5px;
    border-radius: 5px;
    margin: 10px;

</style>
<script type="text/javascript">

	function formValidate(){
		
		var fname = document.forms["userReg"]["fname"].value;
		var lname = document.forms["userReg"]["lname"].value;
		var address = document.form["userReg"]["address"].value;
		var txtPhone = document.form["userReg"]["txtPhone"].value;
		var email = document.form["userReg"]["email"].value;
		var sex = document.form["userReg"]["sex"].value;
		
		if(isAlphabatic(fname))
			if(isAlphabatic(lname))
				return true;
			else
				return true;
	}
	

$(window).load(function(){
	$(document).ready(function() {
	    $('#txtPhone').blur(function(e) {
	        if (validatePhone('txtPhone')) {
	            $('#spnPhoneStatus').html('Valid Mobil Number');
	            $('#spnPhoneStatus').css('color', 'green');
	        }
	        else {
	            $('#spnPhoneStatus').html('Invalid Mobile Number');
	            $('#spnPhoneStatus').css('color', 'red');
	        }
	    });
	    
	});
	 

	
	
}
	
	
	


</script>
 
</head>
<body style="background-color:#d9ffb3">
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
       
        <li><a href="MainHome.jsp">Home</a></li>
        <li><a href="aboutUs.jsp">About Us</a></li>
        <li><a href="reviews.jsp">Reviews</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
  
        
      </ul>
    </div>
  </div>
</nav>

<div style="background:url(images/register.jpg)repeat;width:100%">
<form name="userReg" method="GET" action="add-UR-process.jsp">
 <input type="hidden" name="command" value="ADD" />   
<div class="container-fluid bg-3 text-left" style="background-color:#d9ffb3;width:500px;height:600px">    
 <div class="form-group">
      <label>First name:</label>
      <input type="text" class="form-control" placeholder="Enter firstname" id="fname" name="fname" pattern="[A-Za-z]*[A-Za-z]"required>
    </div>
    <div class="form-group">
      <label>Last name:</label>
      <input type="text" class="form-control"  placeholder="Enter lastname" id="lname" name="lname" pattern="[A-Za-z]*[A-Za-z]" required>
    </div>
    <div class="form-group">
      <label>Address:</label>
      <input type="text" class="form-control"  placeholder="Enter address" id="address" name="address"  required>
    </div>
    <div class="form-group">
      <label>Phone number:</label>
      <input type="text" class="san"  placeholder="Enter phone number" id="txtPhone" name="phone" maxlength="10" required>
    <span id="spnPhoneStatus"></span>
    </div>
    <div class="form-group">
      <label>Email:</label>
      <input type="text" class="form-control"  placeholder="Enter email" id="email" name="email" required>
    </div>
     <div class="form-group">
      <label>Gender:</label>
      <div class="radio">
  		<label><input type="radio" name="sex" value="female" required>Female</label>
	 </div>
	 <div class="radio">
  		<label><input type="radio" name="sex" value="male" required>male</label>
	 </div>
    </div>
      <div class="form-group">
      <label>Password: </label>
      <input type="password" class="form-control"  placeholder="Enter password" id="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"required>
        </div>
        
    <center><button type="reset" class="btn btn-default">Reset</button>
    <button type="submit" class="btn btn-default" >Submit</button></center>
    
    
    </div>


</form>
</div>
<footer class="container-fluid text-center">
  <p>Footer</p>
</footer>

</body>
</html>