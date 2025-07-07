package com.example.icalendar.model;

import java.time.LocalDateTime;

public class CalendarEvent {
    private Long id;
    private String summary;
    private LocalDateTime start;
    private LocalDateTime end;

    public CalendarEvent() {}

    public CalendarEvent(Long id, String summary, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.summary = summary;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
