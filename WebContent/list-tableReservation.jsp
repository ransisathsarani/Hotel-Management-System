<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Kanneliya Forest Resort | list Caterings</title>
<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>



<body style="background:#373a39" >
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
				<li><a href="#">Table Reservation</a></li>
				<li><a href="#">Take away</a></li>
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
	<h2 style="color:white;padding-left:100px">List Table Reservation- Kanneliya Forest Resort</h2>
	<br>
	<div align="center">
		<!-- <input type="button" value="Add "
			onclick="window.location.href='add-catering-form.jsp'; return false;"
			class="add-subject-button" />  -->
			<br><br>
		<div style="background-color: #ffff66; width: 1000px; align: center">
			<table class="table table-striped">

				<tr>
					<th>tableId</th>
					<th>menuId</th>
					<th>name</th>
					<th>email</th>
					<th>date</th>
					<th>contactNo</th>
					<th>noOfPeople</th>
				</tr>

				<c:forEach var="tempTableReservation" items="${TABLERESERVATION_LIST}">

					<!-- set up a link for each record -->
					<c:url var="tempLink" value="TableReservationControllerServlet">
						<c:param name="command" value="UPDATE_GET" />
						<c:param name="tableReservationId" value="${tempTableReservation.getId()}" />
					</c:url>

					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="TableReservationControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="tableReservationId" value="${tempTableReservation.getId()}" />
					</c:url>

					<tr>
						<td>${tempTableReservation.getTableId()}</td>
						<td>${tempTableReservation.getMenuId()}</td>
						<td>${tempTableReservation.getName()}</td>
						<td>${tempTableReservation.getEmail()}</td>
						<td>${tempTableReservation.getDate()}</td>
						<td>${tempTableReservation.getContactNo()}</td>
						<td>${tempTableReservation.getNoOfPeople()}</td>

						<td><a href="${tempLink}">Update</a> <a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this record?')))return false">
								Delete</a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
</body>
</html>