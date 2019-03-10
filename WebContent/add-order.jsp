 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Order - Kanneliya Forest Resort</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<script>
function calcTotal(){
	var quantity = document.getElementById("quantity").value;
	quantity= parseInt(quantity);
	var unit = document.getElementById("unit").value;
	unit= parseInt(unit);
	

	
	var total = 0;
	total = parseInt(total);
	 
	total = (quantity * unit);
 	document.getElementById("total").value = total ;
	
 	


}
$(function() {
var date = new Date();
var currentMonth = date.getMonth();
var currentDate = date.getDate();
var currentYear = date.getFullYear();
$('#datepicker').datepicker({
maxDate: new Date(currentYear, currentMonth, currentDate)
});
});
</script>
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
        <li><a href="InventoryControllerServlet">Stock maintenance</a></li>
        <li class="active"><a href="#">Order handling</a></li>
        <li><a href="#">Staff</a></li>
        
        
        
      
      
        </ul>
      
    </div>
  </div>
</nav>

<div style="background:url(images/order.png)repeat;width:100%">
<form method="GET" action="OrderControllerServlet">
 <input type="hidden" name="command" value="ADD" />   

<div class="container-fluid bg-3 text-left" style="background-color:white;width:500px;height:800px">    
 <div class="form-group">
      <label>Date:</label>
      <input type="text" class="form-control" placeholder="Enter date" id="datepicker" name="date" required>
      
    </div>
    <div class="form-group">
      <label>staff ID:</label>
       <select class="form-control"  name="staffid">
       <option value="S002">S002</option>
       <option value="S003">S003</option>
       </select>
    </div>
    <div class="form-group">
      <label>Department:</label>
     <select class="form-control"  name="department">
       <option value="kitchen">Kitchen</option>
       <option value="accommodation">Accommodation</option>
       </select>
    </div>
   
    <div class="form-group">
   

      <label>Description (Kitchen and Accommodation):</label>
      <select class="form-control"  name="description" >
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
        <div class="dropdown-divider"></div>
      <option value="soap20pack">Soap - 20 pieces </option>
      <option value="bedSpread">Linen bed Spread</option>
      <option value="toothpaste20pack">Toothpaste - 20 pieces</option>
      <option value="airfreshner">Air freshner</option>
    </select>
    </div>
     
    
    
     <div class="form-group">
      <label>Quantity:</label>
      <input type="text" class="form-control"  placeholder="Enter quantity" id="quantity"name="quantity" required>
    </div>
     
     <div class="form-group">
      <label>Unit cost:</label>
      <input type="text" class="form-control"  placeholder="Enter unit cost" id="unit" name="unit" required>
    </div>
     <div class="form-group">
    <button type="button" class="btn btn-default" style="background-color: #e7e7e7;" onClick="calcTotal()" >CALCULATE TOTAL</button></td>
    </div>
    <div class="form-group">
      <label>Total cost:</label>
      <input type="text" class="form-control"  placeholder="Press calculate to load total" id="total" name="total" required>
    </div>
    <div class="form-group">
      <label>Type:</label>
      <div class="radio">
  		<label><input type="radio" name="type" value="expense" required>Expense</label>
	 </div>
	 <div class="radio">
  		<label><input type="radio" name="type" value="liability" required>Liability</label>
	 </div>
    </div>
    <div>
    
    <center><button type="reset" class="btn btn-default">Reset</button>
    <button type="submit" class="btn btn-default" onClick="check_date()">Submit</button></center>
    
    
    </div>
</div>


</form>
</div>

<footer class="container-fluid text-center">
  <p>Footer</p>
</footer>
</body>
</html>