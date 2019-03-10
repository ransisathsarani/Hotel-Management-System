package com.itp.clientAccPayment;

public class Accommodation_payments {

	private int id;
	private String reserveId;
	private String date ;
	private String RID;
	private String category;
	private float days;
	private float advance;
	private float restaurant;
	private float total;
	
	public Accommodation_payments(int id, String reserveId,String date, String RID, String category, float days, float advance,
			float restaurant, float total) {
		super();
		this.id = id;
		this.reserveId = reserveId;
		this.date = date;
		this.RID = RID;
		this.category = category;
		this.days = days;
		this.advance = advance;
		this.restaurant = restaurant;
		this.total = total;
	}
	public Accommodation_payments(String reserveId,String date, String RID, String category, float days, float advance,
	float restaurant, float total) {
		super();
		this.reserveId = reserveId;
		this.date = date;
		this.RID=RID;
		this.category = category;
		this.days = days;
		this.advance = advance;
		this.restaurant = restaurant;
		this.total = total;
	}
	public Accommodation_payments( String reserveId,String RID, String category, float days, float advance ) {
		// TODO Auto-generated constructor stub
		super();
		this.reserveId=reserveId;
		this.RID=RID;
		this.category = category;
		this.days = days;
		this.advance = advance;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getReserveId() {
		return reserveId;
	}
	public void setReserveId(String reserveId) {
		reserveId = reserveId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRID() {
		return RID;
	}
	public void setRID(String RID) {
		RID = RID;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getDays() {
		return days;
	}
	public float getAdvance() {
		return advance;
	}
	public void setAdvance(float advance) {
		this.advance = advance;
	}
	public float getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(float restaurant) {
		this.restaurant = restaurant;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}



}