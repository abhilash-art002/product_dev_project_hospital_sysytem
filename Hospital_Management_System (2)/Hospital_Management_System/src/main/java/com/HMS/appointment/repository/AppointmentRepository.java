package com.HMS.appointment.repository;

import com.HMS.appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	// Find appointments by doctor name
    List<Appointment> findByDoctorName(String doctorName);

    // Custom query to find all appointments for a doctor by their name
    @Query("SELECT a FROM Appointment a WHERE a.doctor.name = :doctorName")
    List<Appointment> findAppointmentsByDoctorName(String doctorName);

    // Custom query to find all appointments for a specific patient
    @Query("SELECT a FROM Appointment a WHERE a.patientName = :patientName")
    List<Appointment> findAppointmentsByPatientName(String patientName);

    // Custom query to find all appointments within a date range
    @Query("SELECT a FROM Appointment a WHERE a.dateTime BETWEEN :startDate AND :endDate")
    List<Appointment> findAppointmentsByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    // Custom query to count the number of appointments for a specific doctor by their name
    @Query("SELECT COUNT(a) FROM Appointment a WHERE a.doctor.name = :doctorName")
    long countAppointmentsByDoctorName(String doctorName);

    // Custom query to find all upcoming appointments for a specific doctor
    @Query("SELECT a FROM Appointment a WHERE a.doctor.name = :doctorName AND a.dateTime > :currentDate")
    List<Appointment> findUpcomingAppointmentsForDoctor(String doctorName, LocalDateTime currentDate);

    // Custom query to get all appointments sorted by date
    @Query("SELECT a FROM Appointment a ORDER BY a.dateTime")
    List<Appointment> findAllAppointmentsSortedByDate();

    // Custom query to find appointments by doctor name and within a date range
    @Query("SELECT a FROM Appointment a WHERE a.doctor.name = :doctorName AND a.dateTime BETWEEN :startDate AND :endDate")
    List<Appointment> findAppointmentsByDoctorAndDateRange(String doctorName, LocalDateTime startDate, LocalDateTime endDate);
}
