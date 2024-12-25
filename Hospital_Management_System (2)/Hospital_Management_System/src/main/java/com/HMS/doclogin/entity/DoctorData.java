package com.HMS.doclogin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DoctorData {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;  // Primary key for the doctor_data table

	    @ManyToOne
	    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
	    private Doctor doctor; // Foreign key referencing the doctor table

	    private Integer age;
	    private String qualification;
	    private String category;

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Doctor getDoctor() {
	        return doctor;
	    }

	    public void setDoctor(Doctor doctor) {
	        this.doctor = doctor;
	    }

	    public Integer getAge() {
	        return age;
	    }

	    public void setAge(Integer age) {
	        this.age = age;
	    }

	    public String getQualification() {
	        return qualification;
	    }

	    public void setQualification(String qualification) {
	        this.qualification = qualification;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    // Constructor without doctor (useful when doctor is set separately)
	    public DoctorData(Long id, Integer age, String qualification, String category) {
	        this.id = id;
	        this.age = age;
	        this.qualification = qualification;
	        this.category = category;
	    }

	    // Default constructor
	    public DoctorData() {
	    }
}
