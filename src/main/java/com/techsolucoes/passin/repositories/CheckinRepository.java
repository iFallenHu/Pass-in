package com.techsolucoes.passin.repositories;

import com.techsolucoes.passin.domain.checkin.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckinRepository extends JpaRepository<CheckIn, Integer> {
    Optional<CheckIn> findByAttendeeId(String attendeeId);
}
