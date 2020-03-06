package com.app.koachoo.controller;

import com.app.koachoo.exceptions.GoalsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler{

    @ExceptionHandler(GoalsNotFoundException.class)
    protected ResponseEntity<String> handleEntityNotFound(
            GoalsNotFoundException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
