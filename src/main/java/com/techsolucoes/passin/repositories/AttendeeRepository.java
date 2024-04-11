package com.techsolucoes.passin.repositories;

import com.sun.java.accessibility.util.EventID;
import com.techsolucoes.passin.domain.attendee.Attendee;
import com.techsolucoes.passin.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, String> {

    List<Attendee> findByEventId(String eventId);

    Optional<Attendee> findByEventIdAndEmail(String eventId, String email);


}
