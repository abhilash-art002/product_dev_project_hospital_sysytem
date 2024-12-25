package com.HMS.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HMS.staff.Staff;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByEmail(String email);

    Optional<Staff> findByEmailAndPassword(String email, String password);
}
