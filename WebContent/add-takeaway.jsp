<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add TakeAway order - Kanneliya Forest Resort</title>
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
				<li><a href="#">Home</a></li>
				<li><a class="#">Catering</a></li>
				<li><a href="#">Table Reservation</a></li>
				<li class="active"><a href="#">Take away</a></li>
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
	<!--  <div style="background: url(images/catering_2.jpg) repeat; width: 100%;background-color:red"> -->
	<div style="background-color:#ffbf80">
		<div class="col-sm-6">
			<form action="TakeAwayControllerServlet" method="GET">
				<input type="hidden" name="command" value="ADD" />
				<div class="container-fluid bg-3 text-left"
					style="background-color: #1f2021; width: 450px; height: 600px">
					<div class="form-group">
						<label>Date:</label> <input type="date" class="form-control"
							placeholder="Enter date" id="date" name="date"
							title="must be a future datea" required>
					</div>
					<div class="form-group">
						<label>Name:</label> <input type="text" class="form-control"
							placeholder="Enter name" name="name"
							title="Numbers should not be included in this field"
							pattern="[a-zA-Z\s]+$" required>
					</div>
					<div class="form-group">
						<label>Number of packets:</label> <input type="number"
							class="form-control" placeholder="Enter number of packets"
							name="numberOfPackets" title="only numbers" required>
					</div>
					<div class="form-group">
						<label>Contact number:</label> <input type="tel"
							class="form-control" placeholder="Enter contact number"
							name="contactNumber" id="contactNumber"
							title="Should not include Letters and must have 10 digits"
							pattern="^\d{10}$" required>
					</div>
					<div class="form-group">
						<label>email:</label> <input type="email" class="form-control"
							placeholder="Enter email" name="email"
							title="must include a @sign " required>
					</div>
					<div class="form-group">
						<label>Menu ID:</label> <input type="text" class="form-control"
							placeholder="Enter menu Id" name="menuID"
							title="enter a menu Id from the menu" required>
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
			<img src="images/men.jpg" class="img-responsive"
				style="width: 400px; height: 600px">
		</div>

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