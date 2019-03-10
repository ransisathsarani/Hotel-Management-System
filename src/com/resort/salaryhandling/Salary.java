package com.resort.salaryhandling;

public class Salary {

	private int id;
	private String empId;
	private String empName;
	private double basicSalary;
	private double otRate;
	private int otHours;
	private double bonusPayment;
	private double panaltyPayment;
	private double totalSalary;
	
	private String action;
	
	public Salary(String empId, String empName, double basicSalary, double otRate, int otHours, double bonusPayment,
			double panaltyPayment) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.basicSalary = basicSalary;
		this.otRate = otRate;
		this.otHours = otHours;
		this.bonusPayment = bonusPayment;
		this.panaltyPayment = panaltyPayment;
	}
	
	
	
	public Salary(String empId, double totalSalary) {
		super();
		this.empId = empId;
		this.totalSalary = totalSalary;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getOtRate() {
		return otRate;
	}
	public void setOtRate(double otRate) {
		this.otRate = otRate;
	}
	public int getOtHours() {
		return otHours;
	}
	public void setOtHours(int otHours) {
		this.otHours = otHours;
	}
	public double getBonusPayment() {
		return bonusPayment;
	}
	public void setBonusPayment(double bonusPayment) {
		this.bonusPayment = bonusPayment;
	}
	public double getPanaltyPayment() {
		return panaltyPayment;
	}
	public void setPanaltyPayment(double panaltyPayment) {
		this.panaltyPayment = panaltyPayment;
	}
	public double getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}



	
	
	
	//test
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
}
