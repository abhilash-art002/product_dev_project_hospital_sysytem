package com.HMS.payment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HMS.payment.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
	
	  // Custom query method to find payments by patient ID
    List<Payment> findByPatientId(String patientId);
}

