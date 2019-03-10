package com.itp.bills;

public class Bills {

	private int id;
	private String month;
	private float water;
	private float tel_1;
	private float tel_2;
	private float electricity;
	private float satellite;
	private float total;
	private String pay_day;
	public Bills(int id, String month, float water, float tel_1, float tel_2, float electricity, float satellite,
			float total, String pay_day) {
		super();
		this.id = id;
		this.month = month;
		this.water = water;
		this.tel_1 = tel_1;
		this.tel_2 = tel_2;
		this.electricity = electricity;
		this.satellite = satellite;
		this.total = total;
		this.pay_day = pay_day;
	}
	public Bills(String month, float water, float tel_1, float tel_2, float electricity, float satellite, float total,
			String pay_day) {
		super();
		this.month = month;
		this.water = water;
		this.tel_1 = tel_1;
		this.tel_2 = tel_2;
		this.electricity = electricity;
		this.satellite = satellite;
		this.total = total;
		this.pay_day = pay_day;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public float getWater() {
		return water;
	}
	public void setWater(float water) {
		this.water = water;
	}
	public float getTel_1() {
		return tel_1;
	}
	public void setTel_1(float tel_1) {
		this.tel_1 = tel_1;
	}
	public float getTel_2() {
		return tel_2;
	}
	public void setTel_2(float tel_2) {
		this.tel_2 = tel_2;
	}
	public float getElectricity() {
		return electricity;
	}
	public void setElectricity(float electricity) {
		this.electricity = electricity;
	}
	public float getSatellite() {
		return satellite;
	}
	public void setSatellite(float satellite) {
		this.satellite = satellite;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getPay_day() {
		return pay_day;
	}
	public void setPay_day(String pay_day) {
		this.pay_day = pay_day;
	}
	
	
	
}
