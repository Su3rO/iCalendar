package com.example.icalendar.service;

import com.example.icalendar.model.CalendarEvent;
import com.example.icalendar.repository.CalendarEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {
    private final CalendarEventRepository repository;

    public CalendarService(CalendarEventRepository repository) {
        this.repository = repository;
    }

    public List<CalendarEvent> getEvents() {
        return repository.findAll();
    }

    public CalendarEvent addEvent(CalendarEvent event) {
        return repository.save(event);
    }

    public CalendarEvent getEvent(Long id) {
        return repository.findById(id).orElse(null);
    }
}
