<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html>

<head>
	<title>List Inventory | kanneliya Forest Resort</title>
	<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
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
        <li><a href="index.jsp">Home</a></li>
        <li class="active"><a href="#">Stock maintenance</a></li>
        <li><a href="OrderControllerServlet">Order handling</a></li>
        <li><a href="#">Staff</a></li>
        
        
        
      
      
        </ul>
      
    </div>
  </div>
</nav>
<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#ffff66;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>

      <div style="color:black;align:center"><h3>List Inventory - Kanneliya Forest Resort</h3></div>
      

      <br />
      </div>
      <div style="background-color:#ffff66">

    </div>
    </div>
    </div>
    
   <div align="center">
		
		<!-- new button: add level2 -->
		
		<input type="button" value="Add inventory"
			onclick="window.location.href='add-inventory.jsp'; return false;"
			class="add-subject-button"/>
		<div class="container">
		<div class="col-xs-6 col-sm-4">
<form class="form-inline" method="post" action="searchInventory.jsp">
<select class="form-control"  name="description">
     <option >Search by description....</option>
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
<button type="submit" name="save" class="btn btn-primary">Search</button>
</form>
</div>
<div class="col-xs-6 col-sm-4">
<form class="form-inline" method="post" action="searchInventoryDate.jsp">
<input type="date" name="date" class="form-control" placeholder="Search by date...">
<button type="submit" name="save" class="btn btn-primary">Search</button>
</form>
</div>
<div class="col-xs-6 col-sm-4">
<form class="form-inline" method="post" action="inventryReport">
<button type="submit" name="save" class="btn btn-primary">Generate current inventory report</button>
</form>
</div>
</div>
</div>

<div class="container-fluid bg-3">

<h3>List of Inventories - Kanneliya Forest Resort</h3>

  <table class="table table-striped">
    <thead>
      <tr class="">
        <th>Date</th>
        <th>Description</th>
        <th>Vendor</th>
        <th>Invoice number</th>
        <th>Recieved quantity</th>
        <th>Weekly consump.</th>
        <th>Current stock</th>
       
      
      </tr>
    </thead>

	 
			
  



</div>
				
				<c:forEach var="tempIn" items="${INVENTORY_LIST}">

					<!-- set up a link for each record -->
					<c:url var="tempLink" value="InventoryControllerServlet" >
						<c:param name="command" value="LOAD" />
						<c:param name="inventoryId" value="${tempIn.id}" />
					</c:url>
					
					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="InventoryControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="inventoryId" value="${tempIn.id}" />					
					</c:url>

					<tr>
						<td> ${tempIn.date} </td>
						<td> ${tempIn.description} </td>
						<td> ${tempIn.vendor}</td>
						<td> ${tempIn.invoiceNum} </td>
						<td> ${tempIn.recieved} </td>
						<td> ${tempIn.weekCon} </td>
						<td>${tempIn.current}</td>
						
						
						<td> 
						<a href="${tempLink}">Update</a>
						<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this record?')))return false">
							Delete</a> 
						</td>
					</tr>
				</c:forEach>
			
			</table>
			</div>

   
    
    
		
		
		  
</body>


</html>