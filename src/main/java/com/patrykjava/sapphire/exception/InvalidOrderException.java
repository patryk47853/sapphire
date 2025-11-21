package com.patrykjava.sapphire.exception;

public class InvalidOrderException extends OrderValidationException {
    public InvalidOrderException(String message) {
        super(message);
    }
}