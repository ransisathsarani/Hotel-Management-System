package com.kanneliya.newReservation;

public class NewReservation {

	 
	 private int id;
	 private String reserveID;
	 private String RID;
	 private String category;
	 private String name;
	 private String phone;
	 private String email;
	 private String checkIn;
	 private String checkOut;
	 private String days;
	 private String adults;
	 private String children;
	 private String advance;
	 private String slipNo;
	 
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getReserveID() {
		return reserveID;
	}
	public void setReserveID(String reserveID) {
		this.reserveID = reserveID;
	}
	
	public String getRID() {
		return RID;
	}
	public void setRID(String rID) {
		RID = rID;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getAdults() {
		return adults;
	}
	public void setAdults(String adults) {
		this.adults = adults;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
	}
	 
	 
	public String getAdvance() {

		return advance;
	}
	public void setAdvance(String advance) {
		this.advance = advance;
	}
	public String getSlipNo() {
		return slipNo;
	}
	public void setSlipNo(String slipNo) {
		this.slipNo = slipNo;
	}
	
	 
	public NewReservation(String reserveID,String RID, String category,String name, String phone, String email,String checkIn, String checkOut,String days, String adults,
			String children,String advance,String slipNo) {
		
		
		this.reserveID = reserveID;
		this.RID = RID;
		this.category = category;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.days = days;
		this.adults = adults;
		this.children = children;
		this.advance = advance;
		this.slipNo = slipNo;
		
	}
	
	public NewReservation(int id,String reserveID,String RID,String category,String name,String phone, String email, String checkIn, String checkOut,String days,String adults,
			String children,String advance,String slipNo) {
		
		this.id = id;
		this.reserveID = reserveID;
		this.RID = RID;
		this.category = category;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.days = days;
		this.adults = adults;
		this.children = children;
		this.advance = advance;
		this.slipNo = slipNo;
		
	}
	
	
	
}
