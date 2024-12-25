package com.HMS.payment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HMS.payment.entity.Payment;
import com.HMS.payment.entity.TransactionDetails;
import com.HMS.payment.service.PaymentService;

import jakarta.persistence.criteria.Order;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Create a new payment
    @PostMapping("/create")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    // Get all payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get payments by patient ID
    @GetMapping("/patient/{patientId}")
    public List<Payment> getPaymentsByPatientId(@PathVariable String patientId) {
        return paymentService.getPaymentsByPatientId(patientId);
    }

    // Update payment status
    @PutMapping("/updateStatus/{paymentId}")
    public Payment updatePaymentStatus(@PathVariable Long paymentId, @RequestParam String status) {
        return paymentService.updatePaymentStatus(paymentId, status);
    }
}
