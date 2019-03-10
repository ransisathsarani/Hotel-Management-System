
package com.resort.ishandling;

public class VendorPayment {
	
	 	private int id;
	 	private String invoice;
	 	private String iDate;
	 	private String vendor;
	 	private String vendorId;
	 	private String department;
	 	private String stockId;
	 	private float amount;
	 	private float paidAmount;
	 	private String paymentType;
	 	private float remainingAmount;
	 	
		
		
		public VendorPayment(String vendorId, float remainingAmount) {
			super();
			this.vendorId = vendorId;
			this.remainingAmount = remainingAmount;
		}
		
		
		public VendorPayment(String iDate, String vendorId, float paidAmount) {
			super();
			this.iDate = iDate;
			this.vendorId = vendorId;
			this.paidAmount = paidAmount;
		}


		public VendorPayment(String iDate, String vendorId, float paidAmount, float remainingAmount) {
			super();
			this.iDate = iDate;
			this.vendorId = vendorId;
			this.paidAmount = paidAmount;
			this.remainingAmount = remainingAmount;
		}


		public VendorPayment(int id, String invoice, String iDate, String vendor, String vendorId, String department,
				String stockId, float amount, float paidAmount, String paymentType) {
			super();
			this.id = id;
			this.invoice = invoice;
			this.iDate = iDate;
			this.vendor = vendor;
			this.vendorId = vendorId;
			this.department = department;
			this.stockId = stockId;
			this.amount = amount;
			this.paidAmount = paidAmount;
			this.paymentType = paymentType;
		}
		public VendorPayment(String invoice, String iDate, String vendor, String vendorId, String department,
				String stockId, float amount, float paidAmount, String paymentType) {
			super();
			this.invoice = invoice;
			this.iDate = iDate;
			this.vendor = vendor;
			this.vendorId = vendorId;
			this.department = department;
			this.stockId = stockId;
			this.amount = amount;
			this.paidAmount = paidAmount;
			this.paymentType = paymentType;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getInvoice() {
			return invoice;
		}
		public void setInvoice(String invoice) {
			this.invoice = invoice;
		}
		public String getiDate() {
			return iDate;
		}
		public void setiDate(String iDate) {
			this.iDate = iDate;
		}
		public String getVendor() {
			return vendor;
		}
		public void setVendor(String vendor) {
			this.vendor = vendor;
		}
		public String getVendorId() {
			return vendorId;
		}
		public void setVendorId(String vendorId) {
			this.vendorId = vendorId;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getStockId() {
			return stockId;
		}
		public void setStockId(String stockId) {
			this.stockId = stockId;
		}
		public float getAmount() {
			return amount;
		}
		public void setAmount(float amount) {
			this.amount = amount;
		}
		public float getPaidAmount() {
			return paidAmount;
		}
		public void setPaidAmount(float paidAmount) {
			this.paidAmount = paidAmount;
		}
		public String getPaymentType() {
			return paymentType;
		}
		public void setPaymentType(String paymentType) {
			this.paymentType = paymentType;
		}

		public float getRemainingAmount() {
			return remainingAmount;
		}

		public void setRemainingAmount(float remainingAmount) {
			this.remainingAmount = remainingAmount;
		}

}
