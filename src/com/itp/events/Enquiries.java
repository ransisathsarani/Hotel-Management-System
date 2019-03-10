package com.itp.events;

public class Enquiries {
	
	private int id;
	private String date;
	private String no_of_persons;
	private String name;
	private String email;
	private String contact_no;
	private String description;
	
	
	
	public Enquiries(String date, String no_of_persons, String name, String email, String contact_no,
			String description) {
		super();
		this.date = date;
		this.no_of_persons = no_of_persons;
		this.name = name;
		this.email = email;
		this.contact_no = contact_no;
		this.description = description;
	}



	public Enquiries(int id, String date, String no_of_persons, String name, String email, String contact_no,
			String description) {
		super();
		this.id = id;
		this.date = date;
		this.no_of_persons = no_of_persons;
		this.name = name;
		this.email = email;
		this.contact_no = contact_no;
		this.description = description;
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



	public String getNo_of_persons() {
		return no_of_persons;
	}



	public void setNo_of_persons(String no_of_persons) {
		this.no_of_persons = no_of_persons;
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



	public String getContact_no() {
		return contact_no;
	}



	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Enquiries [id=" + id + ", date=" + date + ", no_of_persons=" + no_of_persons + ", name=" + name
				+ ", email=" + email + ", contact_no=" + contact_no + ", description=" + description + "]";
	}
	

}
