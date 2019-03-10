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
<title>Manage Vendors - Kanneliya Forest Resort</title>
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
			<li class="active"><a data-toggle="tab" href="#home">Add
					Payment</a></li>
			<li><a data-toggle="tab" href="#menu1">Calculate Payment</a></li>

		</ul>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">

				<br>
				<div align="right">
				<form method="GET" action="VendorPaymentControllerServlet">
					<input type="hidden" name="command" value="LIST_VENDOR">
					<button type="submit" class="btn btn-default">Get Vendor
						List</button>
				</form>
				</div>
				
				
				
				<h3>Add Payment</h3>
				<form method="GET" action="VendorPaymentControllerServlet">
					<input type="hidden" name="command" value="ADD" />
					<div class="container-fluid bg-3 text-left"
						style="width: 100%; height: 80%">
						<!-- background-color:#6393B9; -->
						<div class="form-group">
							<br>
							<div class="form-group">
								<label>Invoice ID :</label> <input type="text"
									class="form-control" placeholder="Enter Name" name="invoice"
									required>
							</div>
							<div class="form-group">
								<label>Date:</label> <input type="date" class="form-control"
									placeholder="Enter Date" name="iDate" id="date" required>
							</div>

							<div class="form-group">
								<label>Vendor :</label> <input type="text" class="form-control"
									placeholder="Enter Name" name="vendor" required>
							</div>
							<div class="form-group">
								<label>Vendor ID:</label> <input type="text"
									class="form-control" placeholder="Enter ID (V####)"
									name="vendorId" required>
							</div>
												
							<div class="form-row">
							<div class="form-group">
								<label for="department">Department:</label> 
								<Select class="form-control" id="department" name="department">
								<option value="Restaurent">Restaurent</option>
								<option value="Accomodation">Accomodation</option>
								<option value="Kitchen">Kitchen</option>
								</Select>
					
							</div>
							</div>
							
							<div class="form-group">
								<label>Stock ID:</label> <input type="text" class="form-control"
									placeholder="Enter ID (SI####)" name="stockId" required>
							</div>
							<div class="form-group">
								<label>Amount:</label>
								<center>
									<input type="text" class="form-control"
										placeholder="Enter Amount" name="amount" required>
								</center>
							</div>

							<div class="form-group">
								<label>Paid Amount:</label>
								<center>
									<input type="text" class="form-control"
										placeholder="Enter Amount" name="paidAmount" required>
								</center>
							</div>


							<div class="form-group">
								<label>Payment Type:</label>
								<div class="radio">
									<label><input type="radio" name="paymentType"
										value="cash">Cash</label>
								</div>
								<div class="radio">
									<label><input type="radio" name="paymentType"
										value="cheque">Cheque</label>
								</div>
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
					document.getElementById("date").setAttribute("max", today);
				</script>
			</div>

			<div id="menu1" class="tab-pane fade">



				<form method="GET" action="VendorPaymentControllerServlet">
					<input type="hidden" name="command" value="LOAD_PAYMENT" />
					<div class="container-fluid bg-3 text-left"
						style="width: 100%; height: 100%">
						<!-- background-color:#6393B9; -->
						<div class="form-group">
							<br>
							<div align="center">
								<h3>Search Vendor</h3>
							</div>
							<br> <label>Vender ID :</label> <input type="text"
								class="form-control" placeholder="V####" name="vendorPaymentId">
						</div>


						<div>
							<center>
								<button type="submit" class="btn btn-default">Search</button>
							</center>
							<br>
						</div>

					</div>

				</form>

				<form method="GET" action="VendorPaymentControllerServlet">
					<input type="hidden" name="command" value="LISTINFO" />
					<div>
						<center>
							<button type="submit" class="btn btn-default">List
								Vendor Payments</button>
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