package com.HMS.doclogin.controller;

import com.HMS.doclogin.entity.Doctor;
import com.HMS.doclogin.entity.DoctorData;
import com.HMS.doclogin.entity.DoctorSchedule;
import com.HMS.doclogin.requests.LoginRequest;
import com.HMS.doclogin.service.DoctorService;

import java.util.List;
import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2/doctors")
public class DoctorController {

	@Autowired
    DoctorService doctorService;

    
	@PostMapping("/addUser")
	  public Doctor adduser(@RequestBody Doctor doctor) {
			
			return doctorService.addUser(doctor);
		  
	  }
		
	@PostMapping("/loginUser")
	public ResponseEntity<Map<String, Object>> loginUser(@RequestBody LoginRequest loginRequest) {
	    boolean isValid = doctorService.LoginUser(loginRequest);
	    
	    Map<String, Object> response = new HashMap<>();
	    if (isValid) {
	        response.put("status", "success");
	        response.put("message", "Login successful");
	        response.put("doctorEmail", loginRequest.getEmail());
	        return ResponseEntity.ok(response);
	    } else {
	        response.put("status", "fail");
	        response.put("message", "Invalid email or password");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	    }
	}

		@PostMapping("/{email}/addDoctorData")
	    public ResponseEntity<DoctorData> addDoctorData(@PathVariable String email, @RequestBody DoctorData doctorData) {
	        DoctorData savedDoctorData = doctorService.addDoctorData(email, doctorData);
	        return new ResponseEntity<>(savedDoctorData, HttpStatus.CREATED);
	    }

	    @GetMapping("/{email}/getDoctorData")
	    public ResponseEntity<DoctorData> getDoctorData(@PathVariable String email) {
	        Optional<DoctorData> doctorData = doctorService.getDoctorDataByEmail(email);
	        return doctorData.map(ResponseEntity::ok)
	                         .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	    @PostMapping("/{email}/addSchedule")
	    public ResponseEntity<String> addDoctorSchedules(@PathVariable String email, @RequestBody List<DoctorSchedule> doctorSchedules) {
	        doctorService.addDoctorSchedules(email, doctorSchedules);  // This now matches the service method
	        return ResponseEntity.ok("Schedules added successfully.");
	    }


	    @GetMapping("/{email}/schedules")
	    public ResponseEntity<List<DoctorSchedule>> getDoctorSchedules(@PathVariable String email) {
	        List<DoctorSchedule> schedules = doctorService.getDoctorSchedules(email);
	        return schedules.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
	                                   : ResponseEntity.ok(schedules);
	    }
	    @PutMapping("/schedules/{id}")
	    public ResponseEntity<DoctorSchedule> updateDoctorSchedule(@PathVariable Long id, @RequestBody DoctorSchedule updatedSchedule) {
	        DoctorSchedule schedule = doctorService.updateDoctorSchedule(id, updatedSchedule);
	        return ResponseEntity.ok(schedule);
	    }

	    @DeleteMapping("/schedules/{id}")
	    public ResponseEntity<String> deleteDoctorSchedule(@PathVariable Long id) {
	        doctorService.deleteDoctorSchedule(id);
	        return ResponseEntity.ok("Schedule deleted successfully.");
	    }
	    
	    //new
	 // New endpoint to fetch doctors by category
	    @GetMapping("/category/{category}")
	    public ResponseEntity<List<Doctor>> getDoctorsByCategory(@PathVariable String category) {
	        List<Doctor> doctors = doctorService.getDoctorsByCategory(category);
	        return doctors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(doctors);
	    }
	    //new2
	    @GetMapping
	    public ResponseEntity<List<Doctor>> getAllDoctors() {
	        List<Doctor> doctors = doctorService.getAllDoctors();  // Add this method to your service layer
	        return doctors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(doctors);
	    }


	   
}
