<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add A Table Reservation - KFR</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body bgcolor="#1A5276">

	<nav class="navbar navbar-inverse">
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
				<li><a href="#">Home</a></li>
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
	<!--  	<div style="background: url(images/catering_2.jpg) repeat; width: 100%;background-color:#373a39">  -->
	<div style="background-color: #373a39">
		<div class="col-sm-6">
			<form action="TableReservationControllerServlet" method="POST">
				<input type="hidden" name="command" value="ADD_POST" />
				<div class="container-fluid bg-3 text-left"
					style="background-color: #1f2021; width: 450px; height: 600px">
					
					<div class="form-group">
						<label>Menu Id </label> <input type="text" class="form-control"
							placeholder="Enter menu id" name="menuId"
							title="Enter menu id from menu" required>
					</div>
					<div>
						<label>Name</label> <input type="text" class="form-control"
							placeholder="Enter name" name="name"
							title="Numbers should not be included in this field"
							pattern="[a-zA-Z\s]+$" required>
					</div>

					<div class="form-group">
						<label>date </label> <input type="date" class="form-control"
							placeholder="Ennter date" id="date" name="date"
							title="past dates cannot be input" required>
					</div>
					<div class="form-group">
						<label>email </label> <input type="email" class="form-control"
							placeholder="Enter contact number" name="email"
							title="Must include a '@'sign " required>
					</div>
					<div class="form-group">
						<label>Contact number:</label> <input type="tel"
							class="form-control" placeholder="Enter contact number"
							name="contactNumber" id="contactNumber"
							title="Should not include Letters and must have 10 digits"
							pattern="^\d{10}$" required>
					</div>
					<div class="form-group">
						<label>Number Of People</label> <input type="number"
							class="form-control" placeholder="Enter number of people"
							name="noOfPeople" title="How many people will be there?" required>
					</div>

					<div class="form-group">
						<label>Table ID :</label>
						<div class="dropdown">
							<select name="tableId" >
								<c:forEach items="${dinnerTableList}" var="dinnerTableList">
									<option value="${dinnerTableList.getTableID()}">${dinnerTableList.getTableID()}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div>

						<center>
							<button type="reset" class="btn btn-default">Reset</button>
							<button type="submit" class="btn btn-default">Submit</button>
						</center>

					</div>
				</div>

			</form>
		</div>



		<div class="col-sm-6">
			<img src="Images/men.jpg" class="img-responsive"
				style="width: 400px; height: 600px">

		</div>

		<script>
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth() + 1; //January is 0!
			var yyyy = today.getFullYear();
			if (dd < 10) {
				dd = '0' + dd
			}
			if (mm < 10) {
				mm = '0' + mm
			}

			today = yyyy + '-' + mm + '-' + dd;
			document.getElementById("date").setAttribute("min", today);
		</script>
</body>
</html>