package com.github.fporto.santanderdevweek2023.controller.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handle(IllegalArgumentException iae) {
        return ResponseEntity.unprocessableEntity().body(iae.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handle(NoSuchElementException nse) {
        return ResponseEntity.notFound().build();
    }
}
