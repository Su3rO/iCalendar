package com.example.icalendar.service;

import com.example.icalendar.model.CalendarEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CalendarService {
    private final List<CalendarEvent> events = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<CalendarEvent> getEvents() {
        return Collections.unmodifiableList(events);
    }

    public CalendarEvent addEvent(CalendarEvent event) {
        event.setId(idGenerator.getAndIncrement());
        events.add(event);
        return event;
    }

    public CalendarEvent getEvent(Long id) {
        return events.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }
}
