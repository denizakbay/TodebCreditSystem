package com.todeb.creditsystem.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@Slf4j
public class RandomUtils {


    private static Random createSecureRandom() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException nae) {
            log.warn("Couldn't create strong secure random generator; reason: {}.", nae.getMessage());
            return new SecureRandom();
        }
    }


    public static int nextInt(int bound){
        return createSecureRandom().nextInt(bound);
    }

}
