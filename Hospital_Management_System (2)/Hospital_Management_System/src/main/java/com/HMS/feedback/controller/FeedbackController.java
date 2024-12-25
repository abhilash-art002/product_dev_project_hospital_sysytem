package com.HMS.feedback.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMS.feedback.entity.Feedback;
import com.HMS.feedback.service.FeedbackService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/add")
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @GetMapping("/all")
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }
    
    @GetMapping("/test")
    public String test() {
        return "Prescription endpoint is working!";
    }
 // Custom query: Get feedback after a specific date
    @GetMapping("/date/{date}")
    public List<Feedback> getFeedbackAfterDate(@PathVariable String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date);
        return feedbackService.getFeedbackAfterDate(dateTime);
    }

    // Custom query: Get feedback by patient ID
    @GetMapping("/patient/{patientId}")
    public List<Feedback> getFeedbackByPatientId(@PathVariable Long patientId) {
        return feedbackService.getFeedbackByPatientId(patientId);
    }

    // Custom query: Get average rating
    @GetMapping("/average-rating")
    public Double getAverageRating() {
        return feedbackService.getAverageRating();
    }

    // Update feedback
    @PutMapping("/update/{id}")
    public Feedback updateFeedback(@PathVariable Long id, @RequestBody Feedback updatedFeedback) {
        return feedbackService.updateFeedback(id, updatedFeedback);
    }

    // Delete feedback
    @DeleteMapping("/delete/{id}")
    public void deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }

}
