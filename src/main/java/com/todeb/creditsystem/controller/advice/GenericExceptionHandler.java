package com.todeb.creditsystem.controller.advice;

import com.todeb.creditsystem.exception.*;
import com.todeb.creditsystem.model.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
@Slf4j
public class GenericExceptionHandler {


    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(CustomerNotFoundException exception) {
        log.warn(exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(
                "CustomerNotFoundException",
                Collections.singletonList(exception.getMessage())
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdentityNumberAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handle(IdentityNumberAlreadyExistException exception) {
        log.warn(exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(
                "IdentityNumberAlreadyExistException",
                Collections.singletonList(exception.getMessage())
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(CreditApplicationAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handle(CreditApplicationAlreadyExistException exception) {
        log.warn(exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(
                "CreditApplicationAlreadyExistException",
                Collections.singletonList(exception.getMessage())
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CreditApplicationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(CreditApplicationNotFoundException exception) {
        log.warn(exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(
                "CreditApplicationNotFoundException",
                Collections.singletonList(exception.getMessage())
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(NotFoundException exception) {
        log.warn(exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(
                "NotFoundException",
                Collections.singletonList(exception.getMessage())
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientCreditScoreException.class)
    public ResponseEntity<ErrorResponse> handle(InsufficientCreditScoreException exception) {
        log.warn(exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(
                "InsufficientCreditScoreException",
                Collections.singletonList(exception.getMessage())
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }



}
