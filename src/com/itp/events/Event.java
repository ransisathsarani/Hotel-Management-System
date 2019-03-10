package com.itp.events;

public class Event {
	
	private int id;
	private String date;
	private String type;
	private String nic;
	private String client_first_name;
	private String client_last_name;
	private String address;
	private String post_code;
	private String tel_no;
	private String mobile_no;
	private String email;
	private int no_of_people;
	private String special_requests;
	private double resort_charges;
	private double accumulative_tax;
	private double total;
	private double prepayment;
	private String payment_status;
	private String payment_date;
	private String appetizer;
	private String soup;
	private String rice1;
	private String rice2;
	private String noodles;
	private String fish;
	private String chicken;
	private String vegetable1;
	private String vegetable2;
	private String vegetable3;
	private String dessert1;
	private String dessert2;
	
	
	public Event(int id, String date, String type, String nic, String client_first_name, String client_last_name,
			String address, String post_code, String tel_no, String mobile_no, String email, int no_of_people,
			String special_requests) {
		super();
		this.id = id;
		this.date = date;
		this.type = type;
		this.nic = nic;
		this.client_first_name = client_first_name;
		this.client_last_name = client_last_name;
		this.address = address;
		this.post_code = post_code;
		this.tel_no = tel_no;
		this.mobile_no = mobile_no;
		this.email = email;
		this.no_of_people = no_of_people;
		this.special_requests = special_requests;
	}


	public Event(String date, String type, String nic, String client_first_name, String client_last_name,
			String address, String post_code, String tel_no, String mobile_no, String email, int no_of_people,
			String special_requests) {
		super();
		this.date = date;
		this.type = type;
		this.nic = nic;
		this.client_first_name = client_first_name;
		this.client_last_name = client_last_name;
		this.address = address;
		this.post_code = post_code;
		this.tel_no = tel_no;
		this.mobile_no = mobile_no;
		this.email = email;
		this.no_of_people = no_of_people;
		this.special_requests = special_requests;
	}

	
	public Event(int id, int no_of_people, double resort_charges, double accumulative_tax, double total, double prepayment, String payment_status, String payment_date) {
		super();
		this.id = id;
		this.no_of_people = no_of_people;
		this.resort_charges = resort_charges;
		this.accumulative_tax = accumulative_tax;
		this.total = total;
		this.prepayment = prepayment;
		this.payment_status = payment_status;
		this.payment_date = payment_date;
	}


	public Event(int id, String appetizer, String soup, String rice1, String rice2, String noodles, String fish,
			String chicken, String vegetable1, String vegetable2, String vegetable3, String dessert1, String dessert2) {
		super();
		this.id = id;
		this.appetizer = appetizer;
		this.soup = soup;
		this.rice1 = rice1;
		this.rice2 = rice2;
		this.noodles = noodles;
		this.fish = fish;
		this.chicken = chicken;
		this.vegetable1 = vegetable1;
		this.vegetable2 = vegetable2;
		this.vegetable3 = vegetable3;
		this.dessert1 = dessert1;
		this.dessert2 = dessert2;
	}


	public Event(int id, String date) {
		super();
		this.id = id;
		this.date = date;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public String getClient_first_name() {
		return client_first_name;
	}


	public void setClient_first_name(String client_first_name) {
		this.client_first_name = client_first_name;
	}


	public String getClient_last_name() {
		return client_last_name;
	}


	public void setClient_last_name(String client_last_name) {
		this.client_last_name = client_last_name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPost_code() {
		return post_code;
	}


	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}


	public String getTel_no() {
		return tel_no;
	}


	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}


	public String getMobile_no() {
		return mobile_no;
	}


	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getNo_of_people() {
		return no_of_people;
	}


	public void setNo_of_people(int no_of_people) {
		this.no_of_people = no_of_people;
	}


	public String getSpecial_requests() {
		return special_requests;
	}


	public void setSpecial_requests(String special_requests) {
		this.special_requests = special_requests;
	}


	public double getResort_charges() {
		return resort_charges;
	}


	public void setResort_charges(double resort_charges) {
		this.resort_charges = resort_charges;
	}


	public double getAccumulative_tax() {
		return accumulative_tax;
	}


	public void setAccumulative_tax(double accumulative_tax) {
		this.accumulative_tax = accumulative_tax;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public double getPrepayment() {
		return prepayment;
	}


	public void setPrepayment(double prepayment) {
		this.prepayment = prepayment;
	}

	public String getPayment_status() {
		return payment_status;
	}


	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getPayment_date() {
		return payment_date;
	}


	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public String getAppetizer() {
		return appetizer;
	}


	public void setAppetizer(String appetizer) {
		this.appetizer = appetizer;
	}


	public String getSoup() {
		return soup;
	}


	public void setSoup(String soup) {
		this.soup = soup;
	}


	public String getRice1() {
		return rice1;
	}


	public void setRice1(String rice1) {
		this.rice1 = rice1;
	}


	public String getRice2() {
		return rice2;
	}


	public void setRice2(String rice2) {
		this.rice2 = rice2;
	}


	public String getNoodles() {
		return noodles;
	}


	public void setNoodles(String noodles) {
		this.noodles = noodles;
	}


	public String getFish() {
		return fish;
	}


	public void setFish(String fish) {
		this.fish = fish;
	}


	public String getChicken() {
		return chicken;
	}


	public void setChicken(String chicken) {
		this.chicken = chicken;
	}


	public String getVegetable1() {
		return vegetable1;
	}


	public void setVegetable1(String vegetable1) {
		this.vegetable1 = vegetable1;
	}


	public String getVegetable2() {
		return vegetable2;
	}


	public void setVegetable2(String vegetable2) {
		this.vegetable2 = vegetable2;
	}


	public String getVegetable3() {
		return vegetable3;
	}


	public void setVegetable3(String vegetable3) {
		this.vegetable3 = vegetable3;
	}


	public String getDessert1() {
		return dessert1;
	}


	public void setDessert1(String dessert1) {
		this.dessert1 = dessert1;
	}


	public String getDessert2() {
		return dessert2;
	}


	public void setDessert2(String dessert2) {
		this.dessert2 = dessert2;
	}


	@Override
	public String toString() {
		return "Event [id=" + id + ", date=" + date + ", type=" + type + ", nic=" + nic + ", client_first_name="
				+ client_first_name + ", client_last_name=" + client_last_name + ", address=" + address + ", post_code="
				+ post_code + ", tel_no=" + tel_no + ", mobile_no=" + mobile_no + ", email=" + email + ", no_of_people="
				+ no_of_people + ", special_requests=" + special_requests + ", resort_charges=" + resort_charges
				+ ", accumulative_tax=" + accumulative_tax + ", total=" + total + ", prepayment=" + prepayment
				+ ", payment_status=" + payment_status + ", payment_date=" + payment_date + ", appetizer=" + appetizer
				+ ", soup=" + soup + ", rice1=" + rice1 + ", rice2=" + rice2 + ", noodles=" + noodles + ", fish=" + fish
				+ ", chicken=" + chicken + ", vegetable1=" + vegetable1 + ", vegetable2=" + vegetable2 + ", vegetable3="
				+ vegetable3 + ", dessert1=" + dessert1 + ", dessert2=" + dessert2 + "]";
	}



	
	
	

}