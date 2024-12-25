package com.HMS.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.payment.entity.Payment;
import com.HMS.payment.entity.TransactionDetails;
import com.HMS.payment.repository.PaymentRepo;

import jakarta.persistence.criteria.Order;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepository;

    // Save a payment
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payments by patient ID
    public List<Payment> getPaymentsByPatientId(String patientId) {
        return paymentRepository.findByPatientId(patientId);
    }

    // Update a payment status
    public Payment updatePaymentStatus(Long paymentId, String status) {
        Optional<Payment> paymentOpt = paymentRepository.findById(paymentId);
        if (paymentOpt.isPresent()) {
            Payment payment = paymentOpt.get();
            payment.setStatus(status);
            return paymentRepository.save(payment);
        }
        return null; // or throw an exception if preferred
    }
}