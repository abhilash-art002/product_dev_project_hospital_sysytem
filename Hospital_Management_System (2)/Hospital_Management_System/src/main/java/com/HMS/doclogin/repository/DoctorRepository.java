package com.HMS.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.HMS.doclogin.entity.Doctor;
import com.HMS.doclogin.entity.DoctorData;

import java.util.List;
import java.util.Optional;


public interface DoctorRepository extends JpaRepository<Doctor, String> {
	 Optional<Doctor> findByEmail(String email);

	 Doctor findByName(String name);
    }




