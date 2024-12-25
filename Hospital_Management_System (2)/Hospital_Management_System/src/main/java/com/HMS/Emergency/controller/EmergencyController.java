package com.HMS.Emergency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.HMS.Emergency.entity.EmergencyEntity;
import com.HMS.Emergency.service.EmergencyService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmergencyController {

    private final EmergencyService emergencyService;

    @Autowired
    public EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    @PostMapping("/request")
    public ResponseEntity<EmergencyEntity> createEmergencyRequest(@RequestBody EmergencyEntity emergencyRequest) {
        try {
            EmergencyEntity createdRequest = emergencyService.createEmergencyRequest(emergencyRequest);
            return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/requests")
    public ResponseEntity<List<EmergencyEntity>> getAllEmergencyRequests() {
        try {
            List<EmergencyEntity> requests = emergencyService.getAllEmergencyRequests();
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/request/{id}")
    public ResponseEntity<EmergencyEntity> getEmergencyRequestById(@PathVariable Long id) {
        EmergencyEntity request = emergencyService.getEmergencyRequestById(id);
        return request != null ? new ResponseEntity<>(request, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/request/{id}/status")
    public ResponseEntity<EmergencyEntity> updateEmergencyStatus(@PathVariable Long id, @RequestParam String status) {
        EmergencyEntity updatedRequest = emergencyService.updateEmergencyStatus(id, status);
        return updatedRequest != null ? new ResponseEntity<>(updatedRequest, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/request/{id}")
    public ResponseEntity<Void> deleteEmergencyRequest(@PathVariable Long id) {
        boolean deleted = emergencyService.deleteEmergencyRequest(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
