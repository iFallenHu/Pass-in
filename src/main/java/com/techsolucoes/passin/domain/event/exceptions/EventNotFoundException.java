package com.techsolucoes.passin.domain.event.exceptions;

public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(String message) {
        super(message);
    }
}
