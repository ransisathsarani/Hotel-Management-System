package com.itp.handleApp;

public class Handle {
	
	private int id;
	private String name;
	private String address;
	private String nic;
	private String contact;
	private String mail;
	private String intDate;
	private String intVenue;
	private String tDate;
	private String tVenue;
	
	
	public Handle(int id, String name, String address, String nic, String contact, String mail, String intDate,
			String intVenue, String tDate, String tVenue) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.nic = nic;
		this.contact = contact;
		this.mail = mail;
		this.intDate = intDate;
		this.intVenue = intVenue;
		this.tDate = tDate;
		this.tVenue = tVenue;
	}




	public Handle(String name, String address, String nic, String contact, String mail, String intDate,
			String intVenue, String tDate, String tVenue) {
		super();
		this.name = name;
		this.address = address;
		this.nic = nic;
		this.contact = contact;
		this.mail = mail;
		this.intDate = intDate;
		this.intVenue = intVenue;
		this.tDate = tDate;
		this.tVenue = tVenue;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getNic() {
		return nic;
	}




	public void setNic(String nic) {
		this.nic = nic;
	}




	public String getContact() {
		return contact;
	}




	public void setContact(String contact) {
		this.contact = contact;
	}




	public String getmail() {
		return mail;
	}




	public void setmail(String mail) {
		this.mail = mail;
	}




	public String getIntDate() {
		return intDate;
	}




	public void setIntDate(String intDate) {
		this.intDate = intDate;
	}




	public String getIntVenue() {
		return intVenue;
	}




	public void setIntVenue(String intVenue) {
		this.intVenue = intVenue;
	}




	public String gettDate() {
		return tDate;
	}




	public void settDate(String tDate) {
		this.tDate = tDate;
	}




	public String gettVenue() {
		return tVenue;
	}




	public void settVenue(String tVenue) {
		this.tVenue = tVenue;
	}




	/*@Override
	public String toString() {
		return "Handle [id=" + id + ", name=" + name + ", address=" + address + ", nic=" + nic + ", contact=" + contact
				+ ", mail=" + mail + ", intDate=" + intDate + ", intVenue=" + intVenue + ", tDate=" + tDate
				+ ", tVenue=" + tVenue + "]";
	}*/
	
	
	



}
