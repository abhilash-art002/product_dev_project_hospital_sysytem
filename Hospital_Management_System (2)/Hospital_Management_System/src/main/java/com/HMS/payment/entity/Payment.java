package com.HMS.payment.entity;

import java.time.LocalDate;

import com.HMS.billing.entity.Billing;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String patientId;
	    private String serviceType;
	    private Double amount;
	    private String status; 
	    private String paymentDate;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getPatientId() {
			return patientId;
		}
		public void setPatientId(String patientId) {
			this.patientId = patientId;
		}
		public String getServiceType() {
			return serviceType;
		}
		public void setServiceType(String serviceType) {
			this.serviceType = serviceType;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getPaymentDate() {
			return paymentDate;
		}
		public void setPaymentDate(String paymentDate) {
			this.paymentDate = paymentDate;
		}
		public Payment() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Payment(Long id, String patientId, String serviceType, Double amount, String status,
				String paymentDate) {
			super();
			this.id = id;
			this.patientId = patientId;
			this.serviceType = serviceType;
			this.amount = amount;
			this.status = status;
			this.paymentDate = paymentDate;
		}
		@Override
		public String toString() {
			return "Payment [id=" + id + ", patientId=" + patientId + ", serviceType=" + serviceType + ", amount="
					+ amount + ", status=" + status + ", paymentDate=" + paymentDate + "]";
		}
			
}
