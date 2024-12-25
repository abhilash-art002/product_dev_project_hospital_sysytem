package com.HMS.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HMS.inventory.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long>{
  
}
