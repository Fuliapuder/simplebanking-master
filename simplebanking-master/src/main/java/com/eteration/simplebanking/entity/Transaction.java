package com.eteration.simplebanking.entity;

import com.eteration.simplebanking.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

// This class is a placeholder you can change the complete implementation
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "PUBLIC", name = "transaction")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type")
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String transactionId;

    @JsonBackReference // transaction listesi çekildiğinde içindeki accountu alırken accountun içindeki transaction listi içiçe sonsuz şekilde çekmemesi için
    @JoinColumn(name = "ACCOUNT_NUMBER", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private TransactionType type;

    @Column(name = "TRANSACTION_DATE")
    private Date transactionDate;

    @Column(name = "AMOUNT",nullable = true)
    private Double amount;

}