package com.example.airport.exception;

public class AircraftValidationException extends RuntimeException {
    public AircraftValidationException(String message) {
        super(message);
    }
}