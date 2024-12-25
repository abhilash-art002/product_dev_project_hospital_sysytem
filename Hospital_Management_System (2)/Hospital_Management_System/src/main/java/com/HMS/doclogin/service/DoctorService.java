package com.HMS.doclogin.service;

import com.HMS.doclogin.entity.Doctor;
import com.HMS.doclogin.entity.DoctorData;
import com.HMS.doclogin.entity.DoctorSchedule;
import com.HMS.doclogin.repository.DoctorDataRepository;
import com.HMS.doclogin.repository.DoctorRepository;
import com.HMS.doclogin.repository.DoctorScheduleRepository;
import com.HMS.doclogin.requests.LoginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {
 
	@Autowired
    DoctorRepository doctorRepository;

    @Autowired
    private DoctorDataRepository doctorDataRepository;
     
	
	public Doctor addUser(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	public Boolean LoginUser(LoginRequest loginRequest) {
		
		Optional<Doctor> doctor = doctorRepository.findByEmail(loginRequest.getEmail());

		 if (!doctor.isPresent()) {
		        return false;
		    }

		    Doctor doctor1 = doctor.get();
		    if (!doctor1.getPassword().equals(loginRequest.getPassword())) {
		        return false;
		    }

		    return true;
		
	}
	public DoctorData addDoctorData(String email, DoctorData doctorData) {
        Doctor doctor = doctorRepository.findById(email)
                .orElseThrow(() -> new RuntimeException("Doctor not found with email: " + email));
        doctorData.setDoctor(doctor);
        return doctorDataRepository.save(doctorData);
    }

    public Optional<DoctorData> getDoctorDataByEmail(String email) {
        return doctorDataRepository.findByDoctorEmail(email);
    }
//    Add Scheduling Methods in //
    
    @Autowired
    private DoctorScheduleRepository doctorScheduleRepository;
   
   
    public void addDoctorSchedules( String email, List<DoctorSchedule> doctorSchedules) {
        Optional<Doctor> doctorOptional = doctorRepository.findByEmail(email);
        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            for (DoctorSchedule schedule : doctorSchedules) {
                schedule.setDoctor(doctor);
                doctorScheduleRepository.save(schedule);
            }
        } else {
            throw new RuntimeException("Doctor not found with email: " + email);
        }
    }


    public List<DoctorSchedule> getDoctorSchedules(String email) {
        return doctorScheduleRepository.findByDoctorEmail(email);
    }

    public DoctorSchedule updateDoctorSchedule(Long id, DoctorSchedule updatedSchedule) {
        Optional<DoctorSchedule> existingSchedule = doctorScheduleRepository.findById(id);
        if (existingSchedule.isPresent()) {
            DoctorSchedule schedule = existingSchedule.get();
            schedule.setDayOfWeek(updatedSchedule.getDayOfWeek());
            schedule.setStartTime(updatedSchedule.getStartTime());
            schedule.setEndTime(updatedSchedule.getEndTime());
            return doctorScheduleRepository.save(schedule);
        } else {
            throw new RuntimeException("Schedule not found with id: " + id);
        }
    }

    public void deleteDoctorSchedule(Long id) {
        if (!doctorScheduleRepository.existsById(id)) {
            throw new RuntimeException("Schedule not found with id: " + id);
        }
        doctorScheduleRepository.deleteById(id);
    }
    
    
    //new
 /// New method to find doctors by category
    public List<Doctor> getDoctorsByCategory(String category) {
        List<DoctorData> doctorDataList = doctorDataRepository.findByCategory(category);  // Find DoctorData by category
        return doctorDataList.stream()
                             .map(doctorData -> doctorData.getDoctor())  // Extract associated Doctor
                             .collect(Collectors.toList());
    }
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();  // Fetch all doctors from the database
    }
 
   


   
}