package com.itp.room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.itp.room.Room;
import com.itp.room.RoomDbUtil;

/**
 * Servlet implementation class RoomControllerServlet
 */
@WebServlet("/RoomControllerServlet")
public class RoomControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private RoomDbUtil roomDbUtil;
	@Resource(name="jdbc/kfr")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		

		try {
			roomDbUtil = new RoomDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}
	
    public RoomControllerServlet() {
        super();
        
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

try {
			
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing  rooms
			if(theCommand == null) {
				theCommand = "LIST_AVILABLE_ROOMS";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listRoom(request,response);
				break;
				
			case "ADD":
				addRoom(request,response);
				break;
				
			case "LOAD":
				loadRoom(request,response);
				break;
				
				
				
			case "UPDATE":
				updateRoom(request,response);
				break;
				
			case "DELETE" :
				deleteRoom(request,response);
				break;
				
			case "LIST_AVILABLE_ROOMS":
				list_available_rooms(request,response);
				break;
				
			
				
			default:
				listRoom(request,response);
				
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	
		
}
	
	
private void list_available_rooms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		List<Room> con = (ArrayList<Room>) roomDbUtil.getAvailableRoom();
		
		ArrayList<Room> availableRooms = null;
		ArrayList<Room> notAvailableRooms = null;
		
		/*int rooms = con.size();
		
		for(int i = 1;i<=rooms;i++) {
			
			
			
			if(con.get(i).getStatus().equals("Available")) {
				
				availableRooms.add(con.get(i));
				
			}
			else if(con.get(i).getStatus().equals("Not Available")) {
				notAvailableRooms.add(con.get(i));
			}
		}*/
		
		//add  rooms to the request
		request.setAttribute("AVAILABLE_ROOM_LIST", con);
		request.setAttribute("UNAVAILABLE_ROOM_LIST", notAvailableRooms);

		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/RoomCategories.jsp");
		dispatcher.forward(request, response);
		//System.out.println(con);
		
		
		
		}


private void deleteRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read room id from the form data
		String theRoomId = request.getParameter("roomId");
		
		// delete  room from database
		roomDbUtil.deleteRoom(theRoomId);
		
		//send them back to the list  rooms page
		listRoom(request,response);
}


private void updateRoom(HttpServletRequest request, HttpServletResponse response){

//read  room info from form data
String ids = request.getParameter("roomId");
int id = Integer.parseInt(ids);
String RID = request.getParameter("RID");
String category = request.getParameter("category");
String price = request.getParameter("price");
String status = request.getParameter("status");
 
//create a new  room object
Room theRoom = new Room(id, RID,category,price, status);


try {
	
	//perform update on database
	roomDbUtil.updateRoom(theRoom);
	
	//send them back to the "list rooms" page
	listRoom(request,response);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


}


private void loadRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {

//read room id from form data
String theRoomId = request.getParameter("roomId");

//get  room from database (db util)
Room theRoom = roomDbUtil.getRoom(theRoomId);

//place  room in the request atrribute
request.setAttribute("THE_ROOM", theRoom);

// send to jsp page: update- room-form.jsp
RequestDispatcher dispatcher = 
		request.getRequestDispatcher("/newReservation.jsp");
dispatcher.forward(request, response);

}


private void addRoom(HttpServletRequest request, HttpServletResponse response) throws Exception{

// read  room info from form data
String RID = request.getParameter("RID");
String category = request.getParameter("category");
String price = request.getParameter("price");
String status = request.getParameter("status");
 	

// create a new  room object
Room theRoom = new Room(RID,category,price,status);

// add the  room to the database
roomDbUtil.addRoom(theRoom);

//send back to main page ( room list)
listRoom(request,response);
}

private void listRoom(HttpServletRequest request, HttpServletResponse response) throws Exception{

// get  rooms from db util
List<Room> con = roomDbUtil.getRoom();

//add  rooms to the request
request.setAttribute("ROOM_LIST", con);

//send to JSP page
RequestDispatcher dispatcher = request.getRequestDispatcher("/list-room.jsp");
dispatcher.forward(request, response);
}
 
	


}



	 
	 
