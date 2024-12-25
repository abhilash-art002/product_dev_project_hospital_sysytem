package com.HMS.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HMS.billing.entity.Billing;
import com.HMS.billing.service.BillingService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/bill")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/billing")
    public Billing createBilling(@RequestBody Billing billing) {
        return billingService.createBilling(billing);
    }

    @GetMapping
    public List<Billing> getAllBills() {
        return billingService.getAllBills();
    }

    @GetMapping("/{id}")
    public Billing getBillById(@PathVariable Long id) {
        return billingService.getBillById(id);
    }

    @PutMapping("/{id}/status")
    public void updateBillingStatus(@PathVariable Long id, @RequestParam Billing.BillingStatus status) {
        billingService.updateBillingStatus(id, status);
    }
}
