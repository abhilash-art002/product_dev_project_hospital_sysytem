package com.HMS.staff.controller;

import com.HMS.staff.Staff;
import com.HMS.staff.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Staff staff) {
        try {
            staffService.register(staff);
            return ResponseEntity.ok("{\"message\": \"Registration successful\"}");

        } catch (IllegalArgumentException e) {
            // Handle specific known errors (e.g., validation errors)
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            // Log and handle unexpected errors gracefully
            e.printStackTrace();
            return ResponseEntity.status(500).body("An unexpected error occurred during registration.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Staff staff) {
        try {
            Staff authenticatedStaff = staffService.login(staff.getEmail(), staff.getPassword());
            return ResponseEntity.ok("Login successful! Role: " + authenticatedStaff.getRole());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    }

