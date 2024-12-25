package com.HMS.payment.entity;

public class TransactionDetails {
			
		private String orderId;
		private String currency;
		private String amount;
		public TransactionDetails(String orderId, String currency, String amount) {
			super();
			this.orderId = orderId;
			this.currency = currency;
			this.amount = amount;
		}
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public TransactionDetails() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}
