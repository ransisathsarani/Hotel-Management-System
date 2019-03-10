<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "kfr";
	String userid = "root";
	String password = "root";
	//String studentID=request.getParameter("empid");
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Basic Needs - Kanneliya Forest Resort</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>







</head>


<body>
	`
	<!-- style="background-color:#4F4F4F" -->
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
				<li><a href="adminHome.jsp">Home</a></li>
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
						<li><a href="#">Interview and training sessions</a></li>
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
					data-toggle="dropdown" href="#">Resturaunt <span class="caret"></span></a>
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


	<div class="container">




		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Inquiries</a></li>
			<li><a data-toggle="tab" href="#menu1">Salary details</a></li>

		</ul>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">

				<br>
				
				</form>
				<h3>Inquiries</h3>
				<form method="GET" action="BasicNeedsServlet">
					<input type="hidden" name="command" value="ADD" />
					<div class="container-fluid bg-3 text-left"
						style="width: 100%; height: 80%">
						<!-- background-color:#6393B9; -->
						<div class="form-group">
							<br>
							<div class="form-group">
							<div>
								<label>Inquiry ID :</label> <input type="text"
									class="form-control" placeholder="Inquiry Id" name="inquiry"
									required>
									</div>

								<div class="form-group">
									<label>Employee ID :</label> <input type="text"
										class="form-control" placeholder="Enter employee Id"
										name="empid" required>
								</div>
							</div>
							<div class="form-group">
								<label>Date:</label> <input type="date" class="form-control"
									placeholder="Enter Date" name ="iDate" required>
							</div>

							<div class="form-group">
								<label>Complaints :</label> <input type="text"
									class="form-control" placeholder="Enter your complaints" name="complaint"
									required>
							</div>
							<div class="form-group">
								<label>Department:</label> <input type="text"
									class="form-control" placeholder="Enter Department"
									name="department" required>
							</div>
							

							
							<div>
								<center>
									<button type="reset" class="btn btn-default">Reset</button>
									<button type="submit" class="btn btn-default">Submit</button>
								</center>
								<br>
							</div>
						</div>
					</div>

				</form>
			</div>

			<div id="menu1" class="tab-pane fade">



				<form method="GET" action="SalaryDetailsServlet">
					<input type="hidden" name="command" value="ADD" />
					<div class="container-fluid bg-3 text-left"
						style="width: 100%; height: 100%">
						<!-- background-color:#6393B9; -->
						<div class="form-group">
							<br>
							<div align="center">
								<h3>Salary details</h3>
							</div>
							
							<br> <label>Employee ID :</label> 
							<input type="text"
									class="form-control" placeholder="enter emp id"
									name="empid" required>
									
						</div>
						<div class="form-group">
								<label>Basic Salary:</label> <input type="text"
									class="form-control" placeholder="salary"
									name="department" required>
							</div>
<div class="form-group">
								<label>Over Time Rates :</label> <input type="text"
									class="form-control" placeholder="Enter over time rates"
									name="otRates" required>
							</div>
							<div class="form-group">
								<label>Over Time Hours :</label> <input type="text"
									class="form-control" placeholder="Enter over time hours"
									name="otHours" required>
							</div>

<div class="form-group">
								<label>Bonus Payments:</label> <input type="text"
									class="form-control" placeholder="Enter Department"
									name="bonusPayment" required>
							</div>
							<div class="form-group">
								<label>Panalty Payment:</label> <input type="text"
									class="form-control" placeholder="Enter Department"
									name="panaltyPayment" required>
							</div>
						<div>
							<center>
								<button type="submit" class="btn btn-default">Add Salary Details</button>
							</center>
							<br>
						</div>

					</div>

				</form>

				<form method="GET" action="BasicNeedsServlet">
					<input type="hidden" name="command" value="LIST" />
					<div>
						<center>
							<button type="submit" class="btn btn-default">List
							 Salary Details</button>
						</center>
						<br>
					</div>

				</form>

			</div>

		</div>

	</div>



	<footer> </footer>
</body>
</html>