package com.HMS.appointment.service;

import com.HMS.appointment.entity.Appointment;
import com.HMS.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> getAppointmentsByDoctorName(String doctorName) {
        return appointmentRepository.findAppointmentsByDoctorName(doctorName);
    }

    public List<Appointment> getAppointmentsByPatientName(String patientName) {
        return appointmentRepository.findAppointmentsByPatientName(patientName);
    }

    public List<Appointment> getAppointmentsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return appointmentRepository.findAppointmentsByDateRange(startDate, endDate);
    }

    public long getAppointmentCountByDoctorName(String doctorName) {
        return appointmentRepository.countAppointmentsByDoctorName(doctorName);
    }

    public List<Appointment> getUpcomingAppointmentsForDoctor(String doctorName, LocalDateTime currentDate) {
        return appointmentRepository.findUpcomingAppointmentsForDoctor(doctorName, currentDate);
    }

    public List<Appointment> getAllAppointmentsSortedByDate() {
        return appointmentRepository.findAllAppointmentsSortedByDate();
    }

    public List<Appointment> getAppointmentsByDoctorAndDateRange(String doctorName, LocalDateTime startDate, LocalDateTime endDate) {
        return appointmentRepository.findAppointmentsByDoctorAndDateRange(doctorName, startDate, endDate);
    }
    public List<Appointment> getAppointmentsByDoctor(String doctorName) {
        return appointmentRepository.findByDoctorName(doctorName);
    }
}
