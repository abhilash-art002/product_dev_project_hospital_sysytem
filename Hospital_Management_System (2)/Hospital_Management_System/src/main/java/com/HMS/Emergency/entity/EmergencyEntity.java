package com.HMS.Emergency.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EmergencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;

    private String patientContact;

    private String emergencyType; 

    private String status; 

    private LocalDateTime requestTime;

    private String notes; 

    public EmergencyEntity() {
    }

    public EmergencyEntity(String patientName, String patientContact, String emergencyType, String status, LocalDateTime requestTime, String notes) {
        this.patientName = patientName;
        this.patientContact = patientContact;
        this.emergencyType = emergencyType;
        this.status = status;
        this.requestTime = requestTime;
        this.notes = notes;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}