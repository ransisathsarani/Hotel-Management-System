%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Kanneliya Forest Resort | list Caterings</title>
<link rel="stylesheet" type="text/css" href="style_1.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>



<body style="background: #373a39">
	<nav class="navbar-inverse" style="padding:-20px">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">Home</a></li>
				<li class="active"><a href="#">Catering</a></li>
				<li><a href="add-tableReservation.jsp">Table Reservation</a></li>
				<li><a href="add-takeaway.jsp">Take away</a></li>
				<li><a href="#">Menus</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Register with us</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">
		<br>
		<h2 style="color: white">List Catering orders - Kanneliya Forest
			Resort</h2>
		<div class="row">


			<div align="center">



				<form class="form-inline" method="post" action="Generate_PDF_Dynamic1"> 
					<button type="submit" name="save" >Generate Report</button> 
				</form>


				<br>
				<!-- new button: add level2 -->
				<br> <input type="button" value="Add "
					onclick="window.location.href='add-catering.jsp'; return false;"
					class="btn btn-primary" /> <br>

			</div>
			<br>
			<div style="background-color: #ffff66; width: 1000px; align: center">
				<table class="table table-striped">

					<tr>
						<th>name</th>
						<th>contactNumber</th>
						<th>date</th>
						<th>numberOfPeople</th>
						<th>email</th>
						<th>menuID</th>
						<th>Action</th>
					</tr>

					<c:forEach var="tempCatering" items="${CATERING_LIST}">

						<!-- set up a link for each record -->
						<c:url var="tempLink" value="CateringControllerServlet">
							<c:param name="command" value="LOAD" />
							<c:param name="cateringId" value="${tempCatering.id}" />
						</c:url>

						<!-- set up a link to delete a record -->
						<c:url var="deleteLink" value="CateringControllerServlet">
							<c:param name="command" value="DELETE" />
							<c:param name="cateringId" value="${tempCatering.id}" />
						</c:url>

						<tr>
							<td>${tempCatering.name}</td>
							<td>${tempCatering.contactNumber}</td>
							<td>${tempCatering.date}</td>
							<td>${tempCatering.numberOfPeople}</td>
							<td>${tempCatering.email}</td>
							<td>${tempCatering.menuID}</td>

							<td><a href="${tempLink}">Update</a> <a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this record?')))return false">
									Delete</a></td>
						</tr>
					</c:forEach>

				</table>
			</div>

		</div>

	</div>
</body>
</html>