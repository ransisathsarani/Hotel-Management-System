<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html>

<head>
	<title>List orders | kanneliya Forest Resort</title>
	<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
         
<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#99ccff;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>

      <div style="color:black;align:center"><h3>List orders - Kanneliya Forest Resort</h3></div>
      
      

      <br />
       </div>
      <div style="background-color:#ffff66">

    </div>
    </div>
  
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
        <li  class="active"><a href="#">Order handling</a></li>
        <li><a href="#">Staff</a></li>
        
        
        
      
      
        </ul>
      
    </div>
  </div>
</nav>
  </div>  
   <div align="center">
		
		<!-- new button: add level2 -->
		
		<input type="button" value="Add order"
			onclick="window.location.href='add-order.jsp'; return false;"
			class="add-subject-button"/>
		<div class="container">
		<div class="col-xs-6 col-sm-3">
<form class="form-inline" method="post" action="seachOrder.jsp">
<input type="date" name="date" class="form-control" placeholder="Search by date...">
<button type="submit" name="save" class="btn btn-primary">Search</button>

</form>
</div>
<div class="col-xs-6 col-sm-3">
<form class="form-inline" method="post" action="searchorderDept.jsp">
<input type="text" name="department" class="form-control" placeholder="Search by department...">
<button type="submit" name="save" class="btn btn-primary">Search</button>

</form>
</div>
<div class="col-xs-6 col-sm-3">
<form class="form-inline" method="post" action="orderKitReport">

<button type="submit" name="save" class="btn btn-primary">Kitchen report</button>

</form>
</div>
<div class="col-xs-6 col-sm-3">
<form class="form-inline" method="post" action="orderReportAcc">

<button type="submit" name="save" class="btn btn-primary">Accommodation report</button>

</form>
</div>


</div>

<div class="container-fluid bg-3">

<h3>List of Orders - All the departments</h3>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Date</th>
        <th>Staff ID</th>
        <th>Department</th>
        <th>Description</th>
        <th>Quantity</th>
       <th>Unit price</th>
        <th>Total price</th>
         <th>Type</th>
        <th>Action</th>
      
      </tr>
    </thead>

	 
			
  



</div>
				
				<c:forEach var="temporder" items="${ORDER_LIST}">

					<!-- set up a link for each record -->
					<c:url var="tempLink" value="OrderControllerServlet" >
						<c:param name="command" value="LOAD" />
						<c:param name="orderId" value="${temporder.id}" />
					</c:url>
					
					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="OrderControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="orderId" value="${temporder.id}" />					
					</c:url>

					<tr>
						<td> ${temporder.date} </td>
						<td> ${temporder.staffid} </td>
						<td> ${temporder.department}</td>
						<td> ${temporder.description} </td>
						<td> ${temporder.quantity} </td>
						
						<td> ${temporder.unit} </td>
						<td> ${temporder.total} </td>
						<td> ${temporder.type} </td>
						
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