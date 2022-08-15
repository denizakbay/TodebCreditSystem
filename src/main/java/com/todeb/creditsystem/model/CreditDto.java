package com.todeb.creditsystem.model;

import com.todeb.creditsystem.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditDto {

    private boolean status;
    private Float creditLimit;
    private Customer customer;
}
