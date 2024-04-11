package com.techsolucoes.passin.domain.event.exceptions;

public class AttendeeNotFoundException extends RuntimeException {
    public AttendeeNotFoundException(String message) {
        super(message);
    }
}
