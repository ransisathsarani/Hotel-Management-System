<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Vendor Payment - Kanneliya Forest Resort</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<meta charset="ISO-8859-1">

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
					<li><a href="index.jsp">Home</a></li>
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
		<br>
		
		<table class="table table-striped">
			<thead>
				<tr>

					<th>Invoice ID</th>
					<th>Invoice Date</th>
					<th>Vendor</th>
					<th>Vendor ID</th>
					<th>Department</th>
					<th>Stock ID</th>
					<th>Amount</th>
					<!--<th>Paid Amount</th>  -->
					<th>Payment Type</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="tempVendor" items="${VENDORPAYMENT_LIST}">

				<c:url var="tempLink" value="VendorPaymentControllerServlet">
					<c:param name="command" value="LOAD" />
					<c:param name="vendorPaymentId" value="${tempVendor.id}" />
				</c:url>

				<c:url var="deleteLink" value="VendorPaymentControllerServlet">
					<c:param name="command" value="DELETE" />
					<c:param name="vendorPaymentId" value="${tempVendor.id}" />
				</c:url>

				<tr>
					<td>${tempVendor.invoice}</td>
					<td>${tempVendor.iDate}</td>
					<td>${tempVendor.vendor}</td>
					<td>${tempVendor.vendorId}</td>
					<td>${tempVendor.department}</td>
					<td>${tempVendor.stockId}</td>
					<td>${tempVendor.amount}</td>
				<!-- <td>${tempVendor.paidAmount}</td> -->
					<td>${tempVendor.paymentType}</td>

					<td><a href="${tempLink}">Update</a> <a href="${deleteLink}"
						onclick="if(!(confirm('Are you sure you want to delete this record?')))return false">
							Delete</a></td>
				</tr>

			</c:forEach>

		</table>
	</div>
</body>
</html>