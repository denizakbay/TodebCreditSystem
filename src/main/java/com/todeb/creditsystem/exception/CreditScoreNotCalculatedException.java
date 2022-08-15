package com.todeb.creditsystem.exception;


public class CreditScoreNotCalculatedException extends RuntimeException{
    public CreditScoreNotCalculatedException() {
        super(" Credit Score could not be calculated  !");
    }
}