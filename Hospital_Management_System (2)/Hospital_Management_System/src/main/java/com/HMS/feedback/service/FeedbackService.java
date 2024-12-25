package com.HMS.feedback.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.feedback.entity.Feedback;
import com.HMS.feedback.repository.FeedbackRepository;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public List<Feedback> getFeedbackAfterDate(LocalDateTime date) {
        return feedbackRepository.findByDateAfter(date);
    }

    public List<Feedback> getFeedbackByPatientId(Long patientId) {
        return feedbackRepository.findByPatientId(patientId);
    }

    public Double getAverageRating() {
        return feedbackRepository.findAverageRating();
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    public Feedback updateFeedback(Long id, Feedback updatedFeedback) {
        return feedbackRepository.findById(id)
            .map(feedback -> {
                feedback.setPatientId(updatedFeedback.getPatientId());
                feedback.setComments(updatedFeedback.getComments());
                feedback.setRating(updatedFeedback.getRating());
                feedback.setDate(LocalDateTime.now()); // Update the date to current
                return feedbackRepository.save(feedback);
            })
            .orElseThrow(() -> new RuntimeException("Feedback not found"));
    }
}
