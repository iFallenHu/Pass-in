package com.techsolucoes.passin.services;

import com.techsolucoes.passin.domain.attendee.Attendee;
import com.techsolucoes.passin.domain.checkin.CheckIn;
import com.techsolucoes.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import com.techsolucoes.passin.repositories.CheckinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CheckInService {

    private final CheckinRepository checkinRepository;

    public void registerCheckIn(Attendee attendee) {
        this.verifyCheckInExists(attendee.getId());
        CheckIn newCheckIn = new CheckIn();
        newCheckIn.setAttendee(attendee);
        newCheckIn.setCreatedAt(LocalDateTime.now());
        this.checkinRepository.save(newCheckIn);
    }

    private void verifyCheckInExists(String attendeeId){
        Optional<CheckIn> isCheckedIn =this.getCheckIn(attendeeId);
        if(isCheckedIn.isPresent())throw new CheckInAlreadyExistsException("Attendee already checked in");{

        }
    }

    public Optional <CheckIn> getCheckIn(String attendeeId) {
        return this.checkinRepository.findByAttendeeId(attendeeId);
    }
}