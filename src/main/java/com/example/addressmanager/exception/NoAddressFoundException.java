package com.example.addressmanager.exception;

public class NoAddressFoundException extends RuntimeException {

    public NoAddressFoundException(String message) {
        super(message);
    }

    public NoAddressFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}