package com.techsolucoes.passin.repositories;

import com.techsolucoes.passin.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository  extends JpaRepository<Event, String> {

}
