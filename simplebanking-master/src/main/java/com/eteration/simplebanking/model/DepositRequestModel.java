package com.eteration.simplebanking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepositRequestModel {

    private String accountNumber;
    private Double transactionAmount;

}
