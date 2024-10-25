package com.example.addressmanager.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AddressException extends RuntimeException {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus status;

    public AddressException(String message, Throwable throwable, HttpStatus status) {
        this.message = message;
        this.throwable = throwable;
        this.status = status;
    }

}