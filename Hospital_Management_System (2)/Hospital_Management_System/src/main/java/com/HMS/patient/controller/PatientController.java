package com.HMS.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.HMS.patient.Patient;
import com.HMS.patient.service.PatientService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    // Register a new patient
    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        Patient registeredPatient = patientService.registerPatient(patient);
        return ResponseEntity.ok(registeredPatient);
    }

    // Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Get a patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        return ResponseEntity.ok(patient);
    }

    // Update patient details
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        Patient updatedPatient = patientService.updatePatient(id, patientDetails);
        return ResponseEntity.ok(updatedPatient);
    }
 // Login endpoint to authenticate a patient
    @PostMapping("/login")
    public ResponseEntity<Patient> login(@RequestBody Map<String, String> loginData) {
        String name = loginData.get("name");
        String contactInfo = loginData.get("contactInfo");
        
        Patient authenticatedPatient = patientService.authenticatePatient(name, contactInfo);
        
        if (authenticatedPatient != null) {
            return ResponseEntity.ok(authenticatedPatient); // Login successful
        } else {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
    }

}
