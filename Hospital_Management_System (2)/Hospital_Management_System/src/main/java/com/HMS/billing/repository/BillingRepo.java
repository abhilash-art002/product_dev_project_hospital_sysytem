package com.HMS.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HMS.billing.entity.Billing;

public interface BillingRepo extends JpaRepository<Billing, Long> {}
