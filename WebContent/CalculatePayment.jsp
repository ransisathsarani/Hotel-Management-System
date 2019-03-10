<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Payment - Kanneliya Forest Resort</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">

<script>
	function calculateAmount() {
		var tempAmount = document.getElementById("remainingAmount").value;
		var paidAmount = document.getElementById("paidAmount").value;
		var remainingAmount = tempAmount - paidAmount;
		document.getElementById("remaining").value = remainingAmount;
	}
</script>



</head>
<body>
	.

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
	<!-- End of the navigation -->

	<div class="container">

		<form method="GET" action="VendorPaymentControllerServlet">
			<input type="hidden" name="command" value="VENDOR_SEARCH">
			<button type="submit" class="btn btn-default">BACK</button>
		</form>

		
		<form method="GET" action="VendorPaymentControllerServlet">
			<input type="hidden" name="command" value="ADDINFO" />






			<div class="container-fluid bg-3 text-left"
				style="width: 100%; height: 80%">
				<!-- background-color:#6393B9; -->
				<div class="form-group">
					<br>
					<div class="form-group">
						<label>Vendor ID :</label> <input type="text" class="form-control"
							value="${THE_VENDORPAYMENT_INFO.vendorId}" name="vendorId"
							readonly>
					</div>
					<div class="form-group">
						<label>Remaining Amount:</label> <input type="text"
							class="form-control"
							value="${THE_VENDORPAYMENT_INFO.remainingAmount}"
							name="remainingAmount" readonly>
					</div>
					<div class="form-group">
						<label>Date:</label> <input type="date" class="form-control"
							name="iDate" id="date" required>
					</div>
					<div class="form-group">
						<label>Paid Amount:</label> <input type="text"
							class="form-control" placeholder="Enter Amount" name="paidAmount"
							required>
					</div>







					<div align="center">

						<button type="reset" class="btn btn-default">Reset</button>
						<button type="submit" class="btn btn-default">Submit</button>
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
</body>
</html>