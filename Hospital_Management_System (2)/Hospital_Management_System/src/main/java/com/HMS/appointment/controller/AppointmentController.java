package com.HMS.appointment.controller;

import com.HMS.appointment.entity.Appointment;
import com.HMS.appointment.service.AppointmentService;
import com.HMS.doclogin.entity.Doctor;
import com.HMS.doclogin.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorRepository doctorRepository;  // Inject the Doctor repository to fetch doctor by name

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Optional<Appointment> getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        // Fetch the doctor by name (we assume name is unique in this case)
        Doctor doctor = doctorRepository.findByName(appointment.getDoctor().getName());
        if (doctor == null) {
            throw new RuntimeException("Doctor not found with name: " + appointment.getDoctor().getName());
        }

        // Set the doctor for the appointment using the fetched doctor object
        appointment.setDoctor(doctor);

        return appointmentService.saveAppointment(appointment);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointmentDetails) {
        Appointment appointment = appointmentService.getAppointmentById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Fetch doctor by name
        Doctor doctor = doctorRepository.findByName(appointmentDetails.getDoctor().getName());
        if (doctor == null) {
            throw new RuntimeException("Doctor not found with name: " + appointmentDetails.getDoctor().getName());
        }

        // Update appointment details
        appointment.setDateTime(appointmentDetails.getDateTime());
        appointment.setDoctor(doctor);
        appointment.setPatientName(appointmentDetails.getPatientName());

        return appointmentService.saveAppointment(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }

    
 // Get appointments by doctor name
    @GetMapping("/doctor/{doctorName}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctor(@PathVariable String doctorName) {
        List<Appointment> appointments = appointmentService.getAppointmentsByDoctor(doctorName);
        if (appointments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointments);
    }

    // Custom endpoint to find all appointments for a specific patient by their name
    @GetMapping("/patient/{patientName}")
    public List<Appointment> getAppointmentsByPatientName(@PathVariable String patientName) {
        return appointmentService.getAppointmentsByPatientName(patientName);
    }

    // Custom endpoint to find appointments within a date range
    @GetMapping("/date-range")
    public List<Appointment> getAppointmentsByDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return appointmentService.getAppointmentsByDateRange(startDate, endDate);
    }

    // Custom endpoint to count the number of appointments for a specific doctor
    @GetMapping("/doctor/{doctorName}/count")
    public long countAppointmentsByDoctorName(@PathVariable String doctorName) {
        return appointmentService.getAppointmentCountByDoctorName(doctorName);
    }

    // Custom endpoint to find upcoming appointments for a doctor
    @GetMapping("/doctor/{doctorName}/upcoming")
    public List<Appointment> getUpcomingAppointmentsForDoctor(@PathVariable String doctorName, @RequestParam LocalDateTime currentDate) {
        return appointmentService.getUpcomingAppointmentsForDoctor(doctorName, currentDate);
    }

    // Custom endpoint to get all appointments sorted by date
    @GetMapping("/sorted")
    public List<Appointment> getAllAppointmentsSortedByDate() {
        return appointmentService.getAllAppointmentsSortedByDate();
    }

    // Custom endpoint to find appointments for a doctor within a date range
    @GetMapping("/doctor/{doctorName}/date-range")
    public List<Appointment> getAppointmentsByDoctorAndDateRange(@PathVariable String doctorName,
                                                                @RequestParam LocalDateTime startDate,
                                                                @RequestParam LocalDateTime endDate) {
        return appointmentService.getAppointmentsByDoctorAndDateRange(doctorName, startDate, endDate);
    }
}
