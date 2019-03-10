package com.itp.Inventory;

public class Inventory {

	
	private int id;
	private String date;
	private String description;
	private String vendor;
	private String invoiceNum;
	private float recieved;
	private float weekCon;
	private float current;
	public Inventory(int id, String date, String description, String vendor, String invoiceNum, float recieved,
			float weekCon, float current) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
		this.vendor = vendor;
		this.invoiceNum = invoiceNum;
		this.recieved = recieved;
		this.weekCon = weekCon;
		this.current = current;
	}
	public Inventory(String date, String description, String vendor, String invoiceNum, float recieved, float weekCon,
			float current) {
		super();
		this.date = date;
		this.description = description;
		this.vendor = vendor;
		this.invoiceNum = invoiceNum;
		this.recieved = recieved;
		this.weekCon = weekCon;
		this.current = current;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getInvoiceNum() {
		return invoiceNum;
	}
	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	public float getRecieved() {
		return recieved;
	}
	public void setRecieved(float recieved) {
		this.recieved = recieved;
	}
	public float getWeekCon() {
		return weekCon;
	}
	public void setWeekCon(float weekCon) {
		this.weekCon = weekCon;
	}
	public float getCurrent() {
		return current;
	}
	public void setCurrent(float current) {
		this.current = current;
	}
	
	
	
	
	
}
