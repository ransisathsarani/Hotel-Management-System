<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Catering Order - Kanneliya Forest Resort</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

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
<!--  -->
	<div style="background-color:#373a39">
		<div class="container">
			<div class="row">

				<div class="col-md-7">
					<br> <br> <br>
					<form action="CateringControllerServlet" method="GET">
						<input type="hidden" name="command" value="ADD" />
						<div class="container-fluid bg-3 text-left"
							style="background-color:#1f2021; padding: 20px; border-radius: 10px">
							<div class="form-group">
								<label>Name:</label> <input type="text" class="form-control"
									placeholder="Enter name" name="name"
									title="Numbers should not be included in this field"
									pattern="[a-zA-Z\s]+$" required>
							</div>

							<div class="form-group">
								<label>Contact number:</label> <input type="tel"
									class="form-control" placeholder="Enter contact number"
									name="contactNumber" id="contactNumber"
									title="Should not include Letters and must have 10 digits"
									pattern="^\d{10}$" required>
							</div>

							<div>
								<label>Date:</label> <input type="date" class="form-control"
									placeholder="Enter date" name="date" id="date"
									title="past dates cannot be input" required>
							</div>
							<br>
							<div class="form-group">
								<label>Number of people:</label> <input type="number"
									class="form-control" placeholder="Ennter number"
									name="numberOfPeople" title="How many caterings?" required>
							</div>

							<div class="form-group">
								<label>email:</label> <input type="email" class="form-control"
									placeholder="Enter email" name="email"
									title="Must include a '@' " required>
							</div>
							<div class="form-group">
								<label>Menu ID:</label> <input type="text" class="form-control"
									placeholder="Enter menu id" name="menuID"
									title="You can see the Menu details and menu_ID's in right side"
									required>
							</div>
                          
							<div>
								<center>
									<button type="reset" class="btn btn-default">Reset</button>
									<button type="submit" class="btn btn-default">Submit</button>
								</center>
							</div>
						</div>
					</form>
					<!-- End of add form -->
				</div>

				<div class="col-md-5" style="padding: 10px; border-radius: 10px">
					<img src="images/men.jpg" class="img-responsive"
						style="width: 100%; height: 600px">
				</div>

			</div>
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