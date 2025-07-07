package com.example.icalendar.controller;

import com.example.icalendar.model.CalendarEvent;
import com.example.icalendar.service.CalendarService;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Summary;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/events")
public class CalendarController {
    private final CalendarService service;

    public CalendarController(CalendarService service) {
        this.service = service;
    }

    @GetMapping
    public List<CalendarEvent> list() {
        return service.getEvents();
    }

    @PostMapping
    public ResponseEntity<CalendarEvent> create(
            @RequestParam String summary,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        CalendarEvent event = service.addEvent(new CalendarEvent(null, summary, start, end));
        return ResponseEntity.created(URI.create("/events/" + event.getId())).body(event);
    }

    @GetMapping("/{id}/ical")
    public ResponseEntity<byte[]> getIcs(@PathVariable Long id) throws IOException {
        CalendarEvent event = service.getEvent(id);
        if (event == null) {
            return ResponseEntity.notFound().build();
        }

        VEvent vEvent = new VEvent();
        vEvent.getProperties().add(new Summary(event.getSummary()));
        vEvent.getProperties().add(new DtStart(event.getStart()));
        vEvent.getProperties().add(new DtEnd(event.getEnd()));

        Calendar calendar = new Calendar();
        calendar.getComponents().add(vEvent);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        calendar.write(out);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text", "calendar"));
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=event-" + id + ".ics");

        return ResponseEntity.ok().headers(headers).body(out.toByteArray());
    }
}
