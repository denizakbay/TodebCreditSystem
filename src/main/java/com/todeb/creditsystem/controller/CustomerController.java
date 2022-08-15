package com.todeb.creditsystem.controller;

import com.todeb.creditsystem.model.CustomerDto;
import com.todeb.creditsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/customer")
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping( "/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable Integer id){
        CustomerDto customerDto = customerService.getById(id);
        return new ResponseEntity<>(customerDto,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto){
        CustomerDto savedCustomerDto = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(savedCustomerDto, HttpStatus.CREATED);
    }

    @DeleteMapping( "/{id}")
    public void deleteCustomer(@PathVariable Integer id){
       customerService.deleteCustomer(id);
    }

    @PutMapping("/update")
    public CustomerDto updateCustomer(@Valid @RequestParam Integer id, @Valid @RequestBody CustomerDto customerDto){
       return customerService.updateCustomer(id,customerDto);
    }

}



