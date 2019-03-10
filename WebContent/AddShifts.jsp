<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Shifts Allocation - Kanneliya Forest Resort</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
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
				<li><a href="i.jsp">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Inventory <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Tracking consumption</a></li>
						<li><a href="#">Add Order</a></li>
						<li class="active"><a href="#">Stock Maintenance</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Accommodation <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Booking handling</a></li>
						<li><a href="#">check availability</a></li>
						<li><a href="#">Offers Handling</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Career and Staff <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Shifts and schedules</a></li>
						<li><a href="#">Salary </a></li>
						<li><a href="#">Basic needs</a></li>
						<li><a href="#">Vacancies handling</a></li>
						<li><a href="#">Applicant handling</a></li>
	-					<li><a href="#">Interview and training sessions</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Event Planning <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Wedding packages booking</a></li>
						<li><a href="#">Other events planning</a></li>
						<li><a href="#">Entertainment</a></li>

					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Restaurant <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Catering Handling</a></li>
						<li><a href="#">Table reservations </a></li>
						<li><a href="#">Take away</a></li>
						<li><a href="#">Menu handling</a></li>

					</ul></li>


			</ul>

		</div>
	</div>
	</nav>


	<div style="background:url(images/hotel_staff_1.jpg)repeat;width:100%">
		<form method="GET" action="ShiftAllocationServlet">
			<center>
				<legend>Shifts Allocation</legend>
			</center>
			<input type="hidden" name="command" value="ADD" />
			<div class="container-fluid bg-3 text-left"
				style="background-color: #ffc299; width: 500px; height: 800px">
				<div class="form-group">
					<label>Employee ID:</label> <input type="text" class="form-control"
						placeholder="Enter employee ID" name="empid" required>
				</div>

				<div class="form-group">
					<label>Shift Time:</label> <input type="text" class="form-control"
						placeholder="Enter time" name="s_time" required>
				</div>
				
				<div class="form-group">
					<label>Department ID:</label> <input type="text"
						class="form-control" placeholder="Enter departnment ID" name="dept" required>
				</div>




				<center>
					<button type="reset" class="btn btn-default">Reset</button>

					<button type="submit" class="btn btn-default">Submit</button>
				</center>


			</div>
			</form>
	</div>

	
	</div>
	<footer class="container-fluid text-center">
	<p>Footer</p>
	</footer>
</body>
</html>