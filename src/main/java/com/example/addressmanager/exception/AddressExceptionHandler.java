package com.example.addressmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddressExceptionHandler {

    @ExceptionHandler(AddressException.class)
    public ResponseEntity<Object> handleNoAddressFoundException(NoAddressFoundException noAddressFoundException) {

        AddressException addressException = new AddressException(noAddressFoundException.getMessage(), noAddressFoundException.getCause(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(addressException, HttpStatus.NOT_FOUND);
    }
}