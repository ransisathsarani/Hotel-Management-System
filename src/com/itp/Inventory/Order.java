package com.itp.Inventory;

public class Order {

	private int id;
	private String date;
	private String staffid;
	private String department;
	private String description;
	private float quantity;
	private float unit;
	private float total;
	private String type;
	
	public Order() {}

	

	public Order(int id, String date, String staffid, String department, String description, float quantity, float unit,
			float total, String type) {
		super();
		this.id = id;
		this.date = date;
		this.staffid = staffid;
		this.department = department;
		this.description = description;
		this.quantity = quantity;
		this.unit = unit;
		this.total = total;
		this.type = type;
	}

	public Order(String date, String staffid, String department, String description, float quantity, float unit,
			float total, String type) {
		super();
		this.date = date;
		this.staffid = staffid;
		this.department = department;
		this.description = description;
		this.quantity = quantity;
		this.unit = unit;
		this.total = total;
		this.type = type;
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

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getUnit() {
		return unit;
	}

	public void setUnit(float unit) {
		this.unit = unit;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
