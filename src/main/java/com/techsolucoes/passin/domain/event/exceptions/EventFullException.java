package com.techsolucoes.passin.domain.event.exceptions;

public class EventFullException extends RuntimeException {
    public EventFullException(String message) {
        super(message);
    }
}
