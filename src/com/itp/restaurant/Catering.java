package com.itp.restaurant;



public class Catering {
	
	
	private int id;
	private String name;
	private String contactNumber;
	private String date;
	private String numberOfPeople;
	private String email;
	private String menuID;

	
	
	
	


	public Catering(String name, String contactNumber, String date, String numberOfPeople, String email,
			String menuID) {
		super();
		this.name = name;
		this.contactNumber = contactNumber;
		this.date = date;
		this.numberOfPeople = numberOfPeople;
		this.email = email;
		this.menuID = menuID;

	}


	public Catering(int id, String name, String contactNumber, String date, String numberOfPeople, String email,
			String menuID) {
		super();
		this.id = id;
		this.name = name;
		this.contactNumber = contactNumber;
		this.date = date;
		this.numberOfPeople = numberOfPeople;
		this.email = email;
		this.menuID = menuID;
		
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getNumberOfPeople() {
		return numberOfPeople;
	}


	public void setNumberOfPeople(String numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMenuID() {
		return menuID;
	}


	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}


	
	
	
	
	

}

