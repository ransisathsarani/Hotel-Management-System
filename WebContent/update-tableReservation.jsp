<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>update Table Reservation</title>
<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background:#373a39">

	<div id="page">
		<div id="header">
			<div id="section" style="background-color: #274F75; width: 100%">
				<div>
					<a href="index.html"><img src="images/logo (3).png" alt="" /></a>
				</div>
				<div style="color: #ffffff; align: center">
					<h1>K F Rs</h1>
				</div>
				<span>www.KFR.lk <br />S <span>welcome <%=request.getAttribute("username")%><br>
						<a href="<%=request.getContextPath()%>/logoutServlet">Logout</a></span> <br />
					+9477 xxxxxxx
				</span>
			</div>
			<div style="background-color: #ffff66"></div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<div align="center">

		<form action="TableReservationControllerServlet" method="POST">

			<input type="hidden" name="command" value="UPDATE_POST" /> <input
				type="hidden" name="id" value="${TABLERESERVATION.id}" />

			<table style="background-color: white; width: 600px; height: 300px">
				<tbody>
					<tr>
						<td><label>Date :</label></td>
						<td><input type="text" name="date" id="date" 
						title="past dates cannot be input" required
							value="${TABLERESERVATION.date}" /></td>
					</tr>

					<tr>
						<td><label>MenuId :</label></td>
						<td><input type="text" name="menuId" required
							value="${TABLERESERVATION.menuId}" /></td>
					</tr>
					<tr>
						<td><label>name :</label></td>
						<td><input type="text" name="name"
							title="Numbers should not be included in this field"
							pattern="[a-zA-Z\s]+$" required
							value="${TABLERESERVATION.name}" /></td>
					</tr>

					

					<tr>
						<td><label>Contact No :</label></td>
						<td><input type="text" name="contactNo"
							title="Should not include Letters and must have 10 digits" pattern="^\d{10}$" 
							
							value="${TABLERESERVATION.contactNo}" /></td>
					</tr>

					<tr>
						<td><label>Email :</label></td>
						<td><input type="text" name="email" id="email"
						
							required value="${TABLERESERVATION.email}" /></td>
					</tr>
					<tr>
						<td><label>NoOfPeople:</label></td>
						<td><input type="text" name="noOfPeople" required
							value="${TABLERESERVATION.noOfPeople}" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>
		</form>

		<div style="clear: both;"></div>

		<p>
			<a href="TableReservationControllerServlet">Back to List</a>
		</p>
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