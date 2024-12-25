package com.HMS.Emergency.service;

import com.HMS.Emergency.entity.EmergencyEntity;
import com.HMS.Emergency.repository.EmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmergencyService {

    private final EmergencyRepository emergencyRepository;

    @Autowired
    public EmergencyService(EmergencyRepository emergencyRepository) {
        this.emergencyRepository = emergencyRepository;
    }

    public EmergencyEntity createEmergencyRequest(EmergencyEntity emergencyRequest) {
        return emergencyRepository.save(emergencyRequest);
    }

    public List<EmergencyEntity> getAllEmergencyRequests() {
        return emergencyRepository.findAll();
    }

    public EmergencyEntity getEmergencyRequestById(Long id) {
        return emergencyRepository.findById(id).orElse(null);
    }

    public EmergencyEntity updateEmergencyStatus(Long id, String status) {
        Optional<EmergencyEntity> optionalRequest = emergencyRepository.findById(id);
        if (optionalRequest.isPresent()) {
            EmergencyEntity request = optionalRequest.get();
            request.setStatus(status);
            return emergencyRepository.save(request);
        }
        return null;
    }

    public boolean deleteEmergencyRequest(Long id) {
        if (emergencyRepository.existsById(id)) {
            emergencyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
