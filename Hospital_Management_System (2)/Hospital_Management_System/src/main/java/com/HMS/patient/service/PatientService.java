package com.HMS.patient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.patient.Patient;
import com.HMS.patient.repository.PatientRepository;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    // Register a new patient
    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get a patient by ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    // Update patient details
    public Patient updatePatient(Long id, Patient patientDetails) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient != null) {
            patient.setName(patientDetails.getName());
            patient.setAge(patientDetails.getAge());
            patient.setGender(patientDetails.getGender());
            patient.setContactInfo(patientDetails.getContactInfo());
            patient.setMedicalHistory(patientDetails.getMedicalHistory());
            return patientRepository.save(patient);
        }
        return null;
    }
 // Check if a patient with given name and contactInfo exists
    public Patient authenticatePatient(String name, String contactInfo) {
        return patientRepository.findByNameAndContactInfo(name, contactInfo).orElse(null);
    }

}