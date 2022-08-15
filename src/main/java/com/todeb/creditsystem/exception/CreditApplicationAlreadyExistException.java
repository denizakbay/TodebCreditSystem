package com.todeb.creditsystem.exception;


public class CreditApplicationAlreadyExistException extends RuntimeException{
    public CreditApplicationAlreadyExistException(String message) {
        super(message+" identity number credit application already exist!");
    }
}