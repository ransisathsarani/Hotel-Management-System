<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Inventory  - Kanneliya Forest Resort</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<script>
function CalcCurrentStock(){
	var recieved = document.getElementById("recieved").value;
	recieved= parseInt(recieved);
	var weekCon = document.getElementById("weekCon").value;
	weekCon= parseInt(weekCon);
	
	

	
	var current = 0;
	current = parseInt(current);
	 
	if(weekCon == 0){
		current = recieved;
	}
	else{
		current = recieved - weekCon;
		}
 	document.getElementById("current").value = current ;
 	if (current < 3){
 		window.alert("Almost out of stock!!!")
 	}
 	
}



$(function() {
	  var currentYear = (new Date).getFullYear();
	  var currentMonth = (new Date).getMonth();
	  var currentDay = (new Date).getDate();

	  $("#fromdate").datepicker({
	    minDate: new Date((currentYear - 1), 12, 1),
	    dateFormat: 'dd/mm/yy',
	    maxDate: new Date(currentYear, currentMonth, currentDay)
	  });
});


</script>
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
        <li><a href="index.jsp">Home</a></li>
        <li class="active"><a href="#">Stock maintenance</a></li>
        <li><a href="OrderControllerServlet">Order handling</a></li>
        <li><a href="#">Staff</a></li>
        
        
        
      
      
        </ul>
      
    </div>
  </div>
</nav>

<div style="background:url(images/inventory_back.JPG);width:100%">
<form method="GET" action="InventoryControllerServlet"> 
<input type="hidden" name="command" value="ADD" />  

<div class="container-fluid bg-3 text-left" style="background-color:#e5ffcc;width:500px;height:800px">    
 <div class="form-group">
      <label>Date:</label>
      <input type="text" class="form-control" placeholder="Enter date" id="fromdate" name="date" required>
    </div>
    <div class="form-group">
      <label>Description:</label>
     <select class="form-control"  name="description">
     <option >Enter description</option>
   	  <option value="Rice05">Rice05 - Rice 5Kg</option>
      <option value="Rice10">Rice10 - Rice 10Kg</option>
      <option value="Car">car - Carrot(KGs)</option>
      <option value="cucum">cucum - Cucumber(KGs)</option>	
      <option value="leek">leek - Leek(KGs)</option>
      <option value="r_bell">r_bell - Red Bell Pepper(Kgs)</option>	
      <option value="g_bell">g_bell - Green Bell Pepper(Kgs)</option>
      <option value="y_bell">y_bell - Yellow Bell Pepper(Kgs)</option>								
      <option value="coco">coco - Coconut</option>
      <option value="cook_oil">cook_oil - Cooking oil</option>
      <option value="coco_oil">coco_oil - Coconut oil</option>
      <option value="salt">salt - Salt(500g)</option>
      <option value="soya_s">soya_s - Soya Sauce(2L)</option>
      <option value="oister_s">oister_s - Oister Sauce(2L)</option>
      <option value="chili_s">chili_s - Chili Sauce(2L)</option>
      <option value="mayo">mayo - Mayonaese(2L)</option>
      <option value="fries">fries - french fries(2Kg)</option>
         
    </select>
    </div>
    
    <div class="form-group">
      <label>Vendor:</label>
      <select class="form-control"  name="vendor">
     <option value="Ariyarathne_sons">Ariyarathna & Sons</option>
   	  <option value="Sinhagiri_stores">Sinhagiri stores</option>
   	  <option value="Laksha_Seafood">Laksha Seafood suppliers - Galle</option>
   	  <option value="Crisbo">Crisbo chicken</option>
   	  </select>
    </div>
    <div class="form-group">
      <label>Invoice number:</label>
      <input type="text" class="form-control"  placeholder="Enter invoice number" name="invoiceNum" pattern="[A-Za-z]*[A-Za-z]*[0-9]*[0-9]" required>
    </div>
    <div class="form-group">
      <label>Recieved quantity:</label>
      <input type="text" class="form-control" id="recieved" placeholder="Enter recieved" name="recieved" required>
    </div>
     <div class="form-group">
      <label>Weekly consumption:</label>
      <input type="text" class="form-control" id="weekCon" placeholder="Enter weekly consumption" name="weekCon" required>
    </div>
     <div class="form-group">
    <button type="button" class="btn btn-default" style="background-color: #e7e7e7;" onClick="CalcCurrentStock()" >Current stock</button>
   	</div>
   	<div class="form-group">
   	<label>Current stock :</label>
        <input style="width:250px"type="text" class="form-control" placeholder="Press Current stock to load" id="current" name="current" >
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