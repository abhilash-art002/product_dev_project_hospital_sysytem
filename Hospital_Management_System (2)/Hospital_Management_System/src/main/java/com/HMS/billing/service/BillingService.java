package com.HMS.billing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.billing.entity.Billing;
import com.HMS.billing.repository.BillingRepo;

@Service
public class BillingService {

    @Autowired
    private BillingRepo billingRepository;

    public Billing createBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public List<Billing> getAllBills() {
        return billingRepository.findAll();
    }

    public Billing getBillById(Long id) {
        return billingRepository.findById(id).orElse(null);
    }

    public void updateBillingStatus(Long id, Billing.BillingStatus status) {
        Billing billing = getBillById(id);
        if (billing != null) {
            billing.setStatus(status);
            billingRepository.save(billing);
        }
    }
}