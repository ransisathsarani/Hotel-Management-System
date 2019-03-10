package com.resort.salaryhandling;

public class SalaryDetails {
	private int id;
	private String empid;
	private String salary;
	private String otRates;
	private String otHours;
	private String bonusPayment;
	private String panaltyPayment;

	
	
	
	public SalaryDetails(String empid, String salary, String otRates, String otHours, String bonusPayment,
			String panaltyPayment) {
		super();
		this.empid = empid;
		this.salary = salary;
		this.otRates = otRates;
		this.otHours = otHours;
		this.bonusPayment = bonusPayment;
		this.panaltyPayment = panaltyPayment;
	}

	public SalaryDetails(int id, String empid, String salary, String otRates, String otHours, String bonusPayment,
			String panaltyPayment) {
		super();
		this.id = id;
		this.empid = empid;
		this.salary = salary;
		this.otRates = otRates;
		this.otHours = otHours;
		this.bonusPayment = bonusPayment;
		this.panaltyPayment = panaltyPayment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getOtRates() {
		return otRates;
	}

	public void setOtRates(String otRates) {
		this.otRates = otRates;
	}

	public String getOtHours() {
		return otHours;
	}

	public void setOtHours(String otHours) {
		this.otHours = otHours;
	}

	public String getBonusPayment() {
		return bonusPayment;
	}

	public void setBonusPayment(String bonusPayment) {
		this.bonusPayment = bonusPayment;
	}

	public String getPanaltyPayment() {
		return panaltyPayment;
	}

	public void setPanaltyPayment(String panaltyPayment) {
		this.panaltyPayment = panaltyPayment;
	}

	

}
