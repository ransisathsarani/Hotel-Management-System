<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>update TakeAway</title>
<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->

</head>
<body style="background:#373a39"  >

	<div id="page">
		<div id="header">
			<div id="section" style="background-color: #274F75; width: 100%">
				<div>
					<a href="index.html"><img src="images/logo (3).png" alt="" /></a>
				</div>
				<div style="color: #ffffff; align: center">
					<h1>K F Rs</h1>
				</div>
				<span>www.KFR.lk <br /> <span>welcome <%=request.getAttribute("username")%><br>
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

		<form action="CateringControllerServlet" method="GET">

			<input type="hidden" name="command" value="UPDATE" /> <input
				type="hidden" name="cateringId" value="${THE_CATERING.id}" />

			<table style="background-color: #d1d1e0; width: 600px; height: 300px">
				<tbody>
					<tr>
						<td><label>Date:</label></td>
						<td><input type="date" name="date" required id="date" title="past dates cannot be input"
							value="${THE_CATERING.date}" /></td>
					</tr>

					<tr>
						<td><label>Name:</label></td>
						<td><input type="text" name="name" required title="Numbers should not be included in this field" pattern="[a-zA-Z\s]+$"
							value="${THE_CATERING.name}" /></td>
					</tr>
					<tr>
						<td><label>Number Of Packets:</label></td>
						<td><input type="number" name="numberOfPeople" title="only numbers" required
							value="${THE_CATERING.numberOfPeople}" /></td>
					</tr>

					<tr>
						<td><label>Contact Number:</label></td>
						<td><input type="tel" name="contactNumber" title="Should not include Letters" pattern="^\d{10}$" required
							value="${THE_CATERING.contactNumber}" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="email" name="email" required
							value="${THE_CATERING.email}" /></td>
					</tr>
					<tr>
						<td><label>MenuID:</label></td>
						<td><input type="text" name="menuID" required
							value="${THE_CATERING.menuID}" /></td>
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