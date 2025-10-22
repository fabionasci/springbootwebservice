package com.curso.java.completo.springbootwebservice.controllers.exceptions;

import com.curso.java.completo.springbootwebservice.services.exceptions.DataBaseException;
import com.curso.java.completo.springbootwebservice.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(HttpServletRequest request, ResourceNotFoundException ex) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBaseException(HttpServletRequest request, DataBaseException ex) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError err = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
