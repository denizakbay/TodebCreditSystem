package com.todeb.creditsystem.exception;


public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message+" Customer Not Found !");

    }
}
