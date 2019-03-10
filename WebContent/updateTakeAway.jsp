<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>update TakeAway</title>
<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background:#373a39" >

	<div id="page">
		<div id="header">
			<div id="section" style="background-color: #274F75; width: 100%">
				<div>
					<a href="index.html"><img src="images/logo (3).png" alt="" /></a>
				</div>
				<div style="color: #ffffff; align: center">
					<h1>Update details | KFR</h1>
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

		<form action="TakeAwayControllerServlet" method="GET">

			<input type="hidden" name="command" value="UPDATE" /> <input
				type="hidden" name="takeAwayId" value="${THE_TAKEAWAY.id}" />

			<table style="background-color: #d1d1e0; width: 600px; height: 300px">
				<tbody>
					<tr>
						<td><label>Date:</label></td>
						<td><input type="text" name="date" id="date" title="must be a future datea" required
							value="${THE_TAKEAWAY.date}" /></td>
					</tr>

					<tr>
						<td><label>Name:</label></td>
						<td><input type="text" name="name"
							title="Numbers should not be included in this field" required
							pattern="[a-zA-Z\s]+$" value="${THE_TAKEAWAY.name}" /></td>
					</tr>
					<tr>
						<td><label>Number Of Packets:</label></td>
						<td><input type="number" name="numberOfPackets" required
							value="${THE_TAKEAWAY.numberOfPackets}" /></td>
					</tr>

					<tr>
						<td><label>Contact Number:</label></td>
						<td><input type="number" name="contactNumber" required
							title="Should not include Letters" pattern="^\d{10}$"
							value="${THE_TAKEAWAY.contactNumber}" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="email" name="email"
							title="must include a @sign " required
							value="${THE_TAKEAWAY.email}" /></td>
					</tr>
					<tr>
						<td><label>MenuID:</label></td>
						<td><input type="text" name="menuID" required
							value="${THE_TAKEAWAY.menuID}" /></td>
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
			<a href="TakeAwayControllerServlet">Back to List</a>
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