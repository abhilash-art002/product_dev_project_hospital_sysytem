package com.HMS.event.repository;

import com.HMS.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByEndDateAfter(LocalDate currentDate);
    @Query("SELECT e FROM Event e WHERE e.startDate <= :currentDate AND e.endDate >= :currentDate OR e.startDate > :currentDate")
    List<Event> findActiveOrUpcomingEvents(@Param("currentDate") LocalDate currentDate);
}
