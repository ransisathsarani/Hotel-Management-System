package com.resort.salaryhandling;

public class BasicNeeds {

	
	
	private int id;
	private int inquiry;
	private String empid;
	private String iDate;
	private String complaint;
	private String department;
	
	public BasicNeeds(int id, int inquiry, String empid, String iDate, String complaint, String department) {
		super();
		this.id = id;
		this.inquiry = inquiry;
		this.empid = empid;
		this.iDate = iDate;
		this.complaint = complaint;
		this.department = department;
	}

	public BasicNeeds(int inquiry, String empid, String iDate, String complaint, String department) {
		super();
		this.inquiry = inquiry;
		this.empid = empid;
		this.iDate = iDate;
		this.complaint = complaint;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInquiry() {
		return inquiry;
	}

	public void setInquiry(int inquiry) {
		this.inquiry = inquiry;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getiDate() {
		return iDate;
	}

	public void setiDate(String iDate) {
		this.iDate = iDate;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOtRates() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
