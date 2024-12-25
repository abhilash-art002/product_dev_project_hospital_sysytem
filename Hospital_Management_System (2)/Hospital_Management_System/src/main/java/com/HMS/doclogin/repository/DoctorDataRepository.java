package com.HMS.doclogin.repository;

import com.HMS.doclogin.entity.DoctorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorDataRepository extends JpaRepository<DoctorData, Long> {
    Optional<DoctorData> findByDoctorEmail(String email);
    List<DoctorData> findByCategory(String category);  // Method to find by category

}
