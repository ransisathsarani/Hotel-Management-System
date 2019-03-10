package com.itp.handleApp;

public class Application {
	
	private int id;
	private String name;
	private String address;
	private String nic;
	private String contact;
	private String mail;
	private String gender;
	private String edu_qualifi;
	private String job_exp;
	
	
	
	public Application(int id, String name, String address, String nic, String contact, String mail, String gender,
			String edu_qualifi, String job_exp) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.nic = nic;
		this.contact = contact;
		this.mail = mail;
		this.gender = gender;
		this.edu_qualifi = edu_qualifi;
		this.job_exp = job_exp;
		
		
		
	}



	public Application(String name, String address, String nic, String contact, String mail, String gender,
			String edu_qualifi, String job_exp) {
		super();
		this.name = name;
		this.address = address;
		this.nic = nic;
		this.contact = contact;
		this.mail = mail;
		this.gender = gender;
		this.edu_qualifi = edu_qualifi;
		this.job_exp = job_exp;
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



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getEdu_qualifi() {
		return edu_qualifi;
	}



	public void setEdu_qualifi(String edu_qualifi) {
		this.edu_qualifi = edu_qualifi;
	}



	public String getJob_exp() {
		return job_exp;
	}



	public void setJob_exp(String job_exp) {
		this.job_exp = job_exp;
	}
	

}
