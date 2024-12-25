package com.HMS.staff.service;

import com.HMS.staff.Staff;
import com.HMS.staff.repository.StaffRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

	 @Autowired
	    private StaffRepository staffRepository;

	// Register method to save a new staff member
	    public Staff register(Staff staff) {
	        return staffRepository.save(staff);
	    }

	    // Simplified login method
	    public Staff login(String email, String password) {
	        Optional<Staff> staffOptional = staffRepository.findByEmailAndPassword(email, password);
	        if (staffOptional.isPresent()) {
	            System.out.println("User found: " + staffOptional.get().getName());
	            return staffOptional.get();
	        } else {
	            System.out.println("Invalid login credentials.");
	            throw new IllegalArgumentException("Invalid email or password.");
	        }
	    }

}
