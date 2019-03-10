package com.itp.restaurant;

public class TableReservation {

	private int id;
	private String menuId;
	private String name;
	private String date;
	private String email;
	private String contactNo;
	private String noOfPeople;
	private int tableID;
	

	
	
	public TableReservation(int id, String menuId, String name, String email, String date, String contactNo,
			String noOfPeople,int tableID) {
		super();
		this.id = id;
		
		this.menuId = menuId;
		this.name = name;
		this.email = email;
		this.date = date;
		this.contactNo = contactNo;
		this.noOfPeople = noOfPeople;
		this.tableID = tableID;
		
	}


	public TableReservation(int Id, String menuId, String name, String email, String date, String contactNo,
			String noOfPeople) {
		super();
		this.id = Id;
		this.menuId = menuId;
		this.name = name;
		this.email = email;
		this.date = date;
		this.contactNo = contactNo;
		this.noOfPeople = noOfPeople;
	}
	
	public TableReservation( String menuId, String name, String email, String date, String contactNo,
			String noOfPeople,int tableId) {
		super();
		this.tableID = tableId;
		this.menuId = menuId;
		this.name = name;
		this.email = email;
		this.date = date;
		this.contactNo = contactNo;
		this.noOfPeople = noOfPeople;
	}
	
	


	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getTableId() {
		return tableID;
	}


	public void setTableId(int tableId) {
		this.tableID = tableId;
	}


	public String getMenuId() {
		return menuId;
	}


	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getNoOfPeople() {
		return noOfPeople;
	}


	public void setNoOfPeople(String noOfPeople) {
		this.noOfPeople = noOfPeople;
	}



	
	
	
	
	
	
	
	
}
