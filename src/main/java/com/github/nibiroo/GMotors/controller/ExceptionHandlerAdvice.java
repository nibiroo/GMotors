package com.github.nibiroo.GMotors.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<String> notFoundHandler(EntityNotFoundException ex) {
        log.info("Message was " + ex.getMessage());
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }

}
