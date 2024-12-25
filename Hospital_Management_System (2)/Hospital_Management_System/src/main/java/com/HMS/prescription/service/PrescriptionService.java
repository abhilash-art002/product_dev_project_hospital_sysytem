package com.HMS.prescription.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HMS.prescription.entity.Prescription;
import com.HMS.prescription.repository.PrescriptionRepo;


@Service
public class PrescriptionService {
    private final PrescriptionRepo prescriptionRepo;

    public PrescriptionService(PrescriptionRepo prescriptionRepo) {
        this.prescriptionRepo = prescriptionRepo;
    }

    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepo.save(prescription);
    }

    public List<Prescription> getPrescriptionsByPatientId(Long patientId) {
        return prescriptionRepo.findByPatientId(patientId);
    }
}
