package com.itp.restaurant;

public class TakeAway {

	private int id;
	private String date;
	private String name;
	private String numberOfPackets;
	private String contactNumber;
	private String email;
	private String menuID;
	
	
	

	public TakeAway(String date, String name, String numberOfPackets, String contactNumber, String email,
			String menuID) {
		super();
		this.date = date;
		this.name = name;
		this.numberOfPackets = numberOfPackets;
		this.contactNumber = contactNumber;
		this.email = email;
		this.menuID = menuID;
	}


	public TakeAway(int id, String date, String name, String numberOfPackets, String contactNumber, String email,
			String menuID) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
		this.numberOfPackets = numberOfPackets;
		this.contactNumber = contactNumber;
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


	public String getNumberOfPackets() {
		return numberOfPackets;
	}


	public void setNumberOfPackets(String numberOfPackets) {
		this.numberOfPackets = numberOfPackets;
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
