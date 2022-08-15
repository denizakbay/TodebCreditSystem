package com.todeb.creditsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {


    @Column(unique = true)
    @NotBlank(message = "Identity Number can not be null!")
    @Pattern(regexp = "^[1-9]\\d{9}[02468]$", message = "Identity Number is not valid!")
    private String identityNumber;

    @NotBlank(message = "First Name can not be null!")
    private String firstName;

    @NotBlank(message = "Last Name can not be null!")
    private String lastName;

    //TODO: add validation for monthly income
    //TODO: change type of monthly income to BigDecimal
    private BigDecimal monthlyIncome;

    @NotBlank(message = "Phone can not be null!")
    private String phone;
}
