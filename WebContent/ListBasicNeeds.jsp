<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Basic Needs - Kanneliya Forest Resort</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<meta charset="ISO-8859-1">

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

		<form method="GET" action="BasicNeedsServlet">
			<input type="hidden" name="command" value="BASICNEEDS_SEARCH">
			<button type="submit" class="btn btn-default">BACK</button>
		</form>
		<br>
		<form method="GET" action="BasicNeedsServlet">
			<input type="hidden" name="command" value="BASICNEEDS_REPORT">
			<button type="submit" class="btn btn-default">Get Basic Needs Details</button>
		</form>
		
		<form method="post" action="Genaratepdf">
		<button type="submit" name="save"> Generate_Report</button>
		</form>
		
		<table class="table table-striped">
			<thead>
				<tr>

					
					<th>Inquiry ID</th>
					
					<th>Employee ID</th>
					
					<th>Date</th>
					
					<th>Complaints</th>
					
					<th>Department</th>
				</tr>
			</thead>

			<c:forEach var="tempBasic" items="${BASICNEEDS_LIST}">

				<c:url var="tempLink" value="BasicNeedsServlet">
					<c:param name="command" value="LOAD" />
					<c:param name="basicNeedsId" value="${tempBasic.id}" />
				</c:url>

				<c:url var="deleteLink" value="BasicNeedsServlet">
					<c:param name="command" value="DELETE" />
					<c:param name="basicNeedsId" value="${tempBasic.id}" />
				</c:url>

				<tr>
					
					<td>${tempBasic.inquiry}</td>
					
					<td>${tempBasic.empid}</td>
					
					<td>${tempBasic.iDate}</td>
					
					<td>${tempBasic.complaint}</td>
					
					<td>${tempBasic.department}</td>
					

					<td><a href="${tempLink}">Update</a> <a href="${deleteLink}"
						onclick="if(!(confirm('Are you sure you want to delete this record?')))return false">
							Delete</a></td>
				</tr>

			</c:forEach>

		</table>
	</div>
</body>
</html>