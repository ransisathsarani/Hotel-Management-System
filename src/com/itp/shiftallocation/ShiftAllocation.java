package com.itp.shiftallocation;

public class ShiftAllocation {

	
		private int id;
		private String empid ;
		private String s_time; 
		
		private String dept ;
		
		

		

		

		

		public ShiftAllocation(String empid, String s_time,  String dept) {
			super();
			this.empid = empid;
			this.s_time = s_time;
			
			this.dept = dept;
		}

		public ShiftAllocation(int id, String empid, String s_time, String dept) {
			super();
			this.id = id;
			this.empid = empid;
			this.s_time = s_time;
			
			this.dept = dept;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getempid() {
			return empid;
		}

		public void setempid(String empid) {
			this.empid = empid;
		}

		
		

		public String gets_time() {
			return s_time;
		}

		public void sets_time(String s_time) {
			this.s_time = s_time;
		}

		public String getdept() {
			return dept;
		}

		public void setdept(String dept) {
			this.dept = dept;
		}


		
		
	}

