package com.todeb.creditsystem.domain;

import com.todeb.creditsystem.enums.CreditStatus;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private CreditStatus status;

    private BigDecimal creditLimit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}
