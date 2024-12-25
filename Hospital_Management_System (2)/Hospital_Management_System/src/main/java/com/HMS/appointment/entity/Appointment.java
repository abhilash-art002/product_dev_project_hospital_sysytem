package com.HMS.appointment.entity;

import com.HMS.doclogin.entity.Doctor;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER) // Change to EAGER
    @JoinColumn(name = "doctor_email", referencedColumnName = "email")
    private Doctor doctor;

    private String patientName;

    public Appointment() {}

    public Appointment(LocalDateTime dateTime, Doctor doctor, String patientName) {
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patientName = patientName;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
