package com.techsolucoes.passin.controllers;

import com.techsolucoes.passin.dto.attendee.AttendeeIdDTO;
import com.techsolucoes.passin.dto.attendee.AttendeeRequestDTO;
import com.techsolucoes.passin.dto.attendee.AttendeesListResponseDTO;
import com.techsolucoes.passin.dto.event.EventIdDTO;
import com.techsolucoes.passin.dto.event.EventRequestDTO;
import com.techsolucoes.passin.dto.event.EventResponseDTO;
import com.techsolucoes.passin.services.AttendeeService;
import com.techsolucoes.passin.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final AttendeeService attendeeService;

    @GetMapping("/{eventId}")
    public ResponseEntity<EventResponseDTO> getEvent(@PathVariable String eventId) {
        EventResponseDTO event = this.eventService.getEventDetails(eventId);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<EventIdDTO> createEvent(@RequestBody EventRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        EventIdDTO eventIdDTO = this.eventService.createEvent(body);

        var uri = uriComponentsBuilder.path("/events/{eventId}").buildAndExpand(eventIdDTO.eventId()).toUri();

        return ResponseEntity.created(uri).body(eventIdDTO);
    }

    @PostMapping("/{eventId}/attendees")
    public ResponseEntity<AttendeeIdDTO> registerParticipant(@PathVariable String eventId, @RequestBody AttendeeRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        AttendeeIdDTO attendeeIdDTO = this.eventService.registerAttendeeOnEvent(eventId, body);

        var uri = uriComponentsBuilder.path("/attendees/{attendId}/badge").buildAndExpand(attendeeIdDTO.attendeeId()).toUri();

        return ResponseEntity.created(uri).body(attendeeIdDTO);
    }





    @GetMapping("/attendees/{eventId}")
    public ResponseEntity<AttendeesListResponseDTO> getEventAttendees(@PathVariable String eventId) {
        AttendeesListResponseDTO attendeeListResponse = this.attendeeService.getEventsAttendee(eventId);
        return ResponseEntity.ok(attendeeListResponse);

    }
}
