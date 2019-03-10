 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Update Reservation</title>
 <link rel="stylesheet" type="text/css" href="StyleSheet1.css" />
</head>
<body>

 <div class="bg"></div>
 
    <div class="container">
		<h3>Update Reservation</h3>
		
		<form action="ReservationControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			
			<input type="hidden" name="newReservationId" value="${THE_NEW_RESERVATION.id}" />
			
				
    <table style="background-color:#ffff66;width:600px;height:300px">
       
		<tr>
						<td><label>Check-In:</label></td>
						<td><input type="date" name="checkIn" 
									value="${THE_NEW_RESERVATION.checkIn}"/></td>
					</tr>
    
    
        <tr>
						<td><label>Check-Out:</label></td>
						<td><input type="date" name="checkOut" 
									value="${THE_NEW_RESERVATION.checkOut}"/></td>
					</tr>
        <tr>
						<td><label>Adults:</label></td>
						<td><input type="text" name="adults" 
									value="${THE_NEW_RESERVATION.adults}"/></td>
					</tr>
       <tr>
						<td><label>Children:</label></td>
						<td><input type="text" name="children" 
									value="${THE_NEW_RESERVATION.children}"/></td>
					</tr>
        <tr>
						<td><label>Single Rooms:</label></td>
						<td><input type="text" name="sRoom" 
									value="${THE_NEW_RESERVATION.sRoom}"/></td>
					</tr>
					<tr>
						<td><label>Double Rooms:</label></td>
						<td><input type="text" name="dRoom" 
									value="${THE_NEW_RESERVATION.dRoom}"/></td>
					</tr>
					<tr>
						<td><label>Family Rooms:</label></td>
						<td><input type="text" name="fRoom" 
									value="${THE_NEW_RESERVATION.fRoom}"/></td>
					</tr>
        <tr>
						<td><label>Advance:</label></td>
						<td><input type="text" name="advance" 
									value="${THE_NEW_RESERVATION.advance}"/></td>
					</tr>
       
        
        
        
        <tr>
            <td></td>
        </tr>
        <tr>
            <td></td>
        </tr>
        <tr><td></td><td align="center"><input type="submit" value="submit"/></td></tr>
       
    </table>
		 </form>
		<div style="clear: both;"></div>
		
		<p>
			<a href="ReservationControllerServlet">Back to List</a>
		</p>
		
	</div>


</body>
</html>