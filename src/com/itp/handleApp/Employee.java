package com.itp.handleApp;

public class Employee {
		
		
		private int id;
		private String empid;
		private String name;
		private String nic;
		private String contact;
		private String mail;
		private String gender;
		private String job_title;
		private String salary;
		private String department;
		private String appointmentDate;
		private String address;
		
		
		
		public Employee(int id, String empid, String name, String nic, String contact, String mail, String gender,
				String job_title, String salary, String department,String appointmentDate,String address) {
			super();
			this.id = id;
			this.empid = empid;
			this.name = name;
			this.nic = nic;
			this.contact = contact;
			this.mail = mail;
			this.gender = gender;
			this.job_title = job_title;
			this.salary = salary;
			this.department = department;
			this.appointmentDate = appointmentDate;
			this.address = address;
		}


		
		


		public Employee(String empid, String name, String nic, String contact, String mail, String gender,
				String job_title, String salary, String department, String appointmentDate, String address) {
			super();
			this.empid = empid;
			this.name = name;
			this.nic = nic;
			this.contact = contact;
			this.mail = mail;
			this.gender = gender;
			this.job_title = job_title;
			this.salary = salary;
			this.department = department;
			this.appointmentDate = appointmentDate;
			this.address = address;
		}






		public Employee(int id, String empid, String name, String job_title, String salary, String department) {
			super();
			this.id = id;
			this.empid = empid;
			this.name = name;
			this.job_title = job_title;
			this.salary = salary;
			this.department = department;
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


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getNic() {
			return nic;
		}


		public void setNic(String nic) {
			this.nic = nic;
		}


		public String getContact() {
			return contact;
		}


		public void setContact(String contact) {
			this.contact = contact;
		}


		public String getMail() {
			return mail;
		}


		public void setMail(String mail) {
			this.mail = mail;
		}


		public String getGender() {
			return gender;
		}


		public void setGender(String gender) {
			this.gender = gender;
		}


		public String getJob_title() {
			return job_title;
		}


		public void setJob_title(String job_title) {
			this.job_title = job_title;
		}


		public String getSalary() {
			return salary;
		}


		public void setSalary(String salary) {
			this.salary = salary;
		}


		public String getDepartment() {
			return department;
		}


		public void setDepartment(String department) {
			this.department = department;
		}


		public String getAppointmentDate() {
			return appointmentDate;
		}


		public void setAppointmentDate(String appointmentDate) {
			this.appointmentDate = appointmentDate;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}
		
		

	}

