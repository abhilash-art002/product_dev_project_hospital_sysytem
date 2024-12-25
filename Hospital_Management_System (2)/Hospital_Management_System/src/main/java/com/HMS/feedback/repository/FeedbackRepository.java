package com.HMS.feedback.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.HMS.feedback.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    // Custom query to retrieve feedback after a specified date
    List<Feedback> findByDateAfter(LocalDateTime date);

    // Custom query to retrieve feedback by patient ID
    List<Feedback> findByPatientId(Long patientId);

    // Custom query to calculate the average rating
    @Query("SELECT AVG(f.rating) FROM Feedback f")
    Double findAverageRating();
}
