package com.todeb.creditsystem.exception;

public class IdentityNumberAlreadyExistException extends RuntimeException {
    public IdentityNumberAlreadyExistException(String identityNumber) {
        super(identityNumber + " identity number already exist !");
    }

}