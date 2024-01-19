package com.eteration.simplebanking.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;

// This class is a place holder you can change the complete implementation
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "PUBLIC", name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String accountNumber;
    @Column(name = "OWNER",nullable = true)
    private String owner;
    @Column(name = "BALANCE",nullable = true)
    private Double balance;

    @JsonManagedReference
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;

}