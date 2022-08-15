package com.todeb.creditsystem.controller;


import com.todeb.creditsystem.domain.CreditApplication;
import com.todeb.creditsystem.enums.CreditStatus;
import com.todeb.creditsystem.service.CreditApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/credit-application")
public class CreditApplicationController {

    private final CreditApplicationService creditService;

    @GetMapping
    public ResponseEntity<List<CreditApplication>> getAllCreditApplication() {
        return new ResponseEntity<>(creditService.getAllCreditApplications(),HttpStatus.OK);
    }
    @GetMapping("/{identityNumber}")
    public ResponseEntity<CreditApplication> getCreditApplication(@Valid @PathVariable String identityNumber) {
        return new ResponseEntity<>(creditService.getCreditApplication(identityNumber),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> createCredit(@Valid @RequestParam String identityNumber){
        CreditStatus creditStatus = creditService.creditApplication(identityNumber);
        String message = "Your credit application is "+creditStatus.toString() +" !";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
