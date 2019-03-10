package com.itp.clientAccPayment;

public class RestaurantPayments {

	private int id;
	private String date;
	private String reserveId;
	private String mID;
	private float total;
	
	public RestaurantPayments(int id,String date,String reserveId,String mID , float total)
		 {
		super();
		this.id = id;
		this.date = date;
		this.reserveId = reserveId;
		this.mID=mID ;
		this.total = total;
		
	}
	public RestaurantPayments(String date,String reserveId,String mID , float total)
		 {
		super();
		
		this.date = date;
		this.reserveId =reserveId ;		
		this.mID=mID ;
		this.total = total;
		
		
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

	public String getReserveId() {
		return reserveId;
	}
	public void setResreveId(String reserveId) {
		this.reserveId = reserveId;
	}
	public String getMID() {
		return mID;
	}
	public void setMID(String mID ) {
		this.mID = mID;
	}
	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
}