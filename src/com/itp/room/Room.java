package com.itp.room;

 

public class Room {

	 
	 private int id;
	 private String RID;
	 private String category;
	 private String price;
	 private String status;
	 
	 
 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Room(String RID, String category, String price,
			String status) {
		super();
		
		 
		this.RID = RID;
		this.category = category;
		this.price = price;
		this.status = status;
		 
	}
	
	public Room(int id,String RID, String category, String price,
			String status) {
		super();
		this.id = id;
		this.RID = RID;
		this.category = category;
		this.price = price;
		this.status = status;
		
	}
	
	
	
}
