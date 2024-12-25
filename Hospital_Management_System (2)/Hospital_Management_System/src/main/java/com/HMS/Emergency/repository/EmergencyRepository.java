package com.HMS.Emergency.repository;

import com.HMS.Emergency.entity.EmergencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyRepository extends JpaRepository<EmergencyEntity, Long> {
    // JpaRepository provides basic CRUD operations, so no additional code is needed here.
}
