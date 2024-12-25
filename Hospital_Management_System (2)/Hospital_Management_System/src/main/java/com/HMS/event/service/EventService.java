package com.HMS.event.service;

import com.HMS.event.entity.Event;
import com.HMS.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getUpcomingEvents() {
        return eventRepository.findByEndDateAfter(LocalDate.now());
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
    
    public Event updateEvent(Long eventId, Event updatedEvent) {
        if (eventRepository.existsById(eventId)) {
            updatedEvent.setId(eventId);
            return eventRepository.save(updatedEvent);
        }
        return null;
    }
    public List<Event> getActiveOrUpcomingEvents() {
        return eventRepository.findActiveOrUpcomingEvents(LocalDate.now());
    }

}
