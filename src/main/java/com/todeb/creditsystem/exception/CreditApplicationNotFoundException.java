package com.todeb.creditsystem.exception;

public class CreditApplicationNotFoundException extends RuntimeException {
    public CreditApplicationNotFoundException(String identityNumber) {
        super(identityNumber+ " credit application not found exception !");
    }
}
