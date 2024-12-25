package com.HMS.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HMS.inventory.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long>{

}
