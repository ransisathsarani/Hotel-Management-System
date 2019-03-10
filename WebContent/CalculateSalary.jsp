<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculate Employee Salary - Kanneliya Forest Resort</title>
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

		<form method="GET" action="SalaryControllerServlet">
		
			<input type="hidden" name="command" value="EMP_SEARCH">
		
			<button type="submit" class="btn btn-default">BACK</button>
		</form>
		<br>
		
		<form method="GET" action="SalaryControllerServlet">

			<input type="hidden"  value="ADD_SALARY"><!--  name="command"-->


			<div class="container-fluid bg-3 text-left"
				style="width: 100%; height: 80%">
				<!-- background-color:#6393B9; -->
				<div class="form-group">
					<br>
					<div class="form-group">
						<label>Employee ID :</label> <input type="text"
							class="form-control" value="${THE_SALARY_INFO.empId}"
							name="employeeId" readonly>
					</div>
					<div class="form-group">
						<label>Employee Name :</label> <input type="text"
							class="form-control" value="${THE_SALARY_INFO.empName}"
							name="employeeName" readonly>
					</div>
					<div class="form-group">
						<label>Basic Salary :</label> <input type="text"
							class="form-control" value="${THE_SALARY_INFO.basicSalary}"
							name="basicSalary" id="basicSalary" readonly>
					</div>
					<div class="form-group">
						<label>OT Rate :</label> <input type="text" class="form-control"
							placeholder="Enter Amount" value="${THE_SALARY_INFO.otRate}"
							name="otRate" id="otRate" readonly>
					</div>
					<div class="form-group ">
						<label>OT Hours :</label> <input type="text" class="form-control"
							placeholder="Enter Hours" value="${THE_SALARY_INFO.otHours}"
							name="otHours" id="otHours" readonly>
					</div>
					<div class="form-group">
						<label>Bonus Payments :</label> <input type="text"
							class="form-control" placeholder="Enter Amount"
							value="${THE_SALARY_INFO.bonusPayment}" name="bonusAmount"
							id="bonusAmount" readonly>
					</div>
					<div class="form-group">
						<label>Penalty Payments :</label> <input type="text"
							class="form-control" placeholder="Enter Amount"
							value="${THE_SALARY_INFO.panaltyPayment}" name="panaltyAmount"
							id="panaltyAmount" readonly>
					</div>
					<div class="form-group">
						<label>Total Salary :</label> <input type="text"
							class="form-control" placeholder="Enter Amount"
							name="totalSalary" id="totalSalary" required>
					</div>

					<div align="center">

						<input type="button" name="button" class="btn btn-default"
							onclick="calculateSalary()" value="Calculate">
							<br>
							<br>
						<button type="submit" class="btn btn-default" name="command" value="PRINT" onclick="/CalculateSalary.jsp">PRINT PAYSLIP</button>
					</div>
					
					

					<br>
					<div align="center">
						<button type="submit" class="btn btn-default"name="command" value="ADD_SALARY">Add Salary</button>
					</div>

				</div>
			</div>

		</form>


		<script>
			function calculateSalary() {

				var otRate = 0;
				var otHours = 0;
				var bonusAmount = 0;
				var panaltyAmount = 0;

				var basicSalary = document.getElementById("basicSalary").value;

				otRate = document.getElementById("otRate").value;
				if (otRate == null || otRate == '') {
					otRate = 0;
				}

				otHours = document.getElementById("otHours").value;
				if (otHours == null || otHours == '') {
					otHours = 0;
				}

				bonusAmount = document.getElementById("bonusAmount").value;
				if (bonusAmount == null || bonusAmount == '') {
					bonusAmount = 0;
				}

				panaltyAmount = document.getElementById("panaltyAmount").value;
				if (panaltyAmount == null || panaltyAmount == '') {
					panaltyAmount = 0;
				}

				var totalAmount = (parseFloat(basicSalary)
						+ (parseFloat(otRate) * parseFloat(otHours)) + parseFloat(bonusAmount))
						- parseFloat(panaltyAmount);

				document.getElementById("totalSalary").value = totalAmount;
			}
		</script>






	</div>
</body>
</html>