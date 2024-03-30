package com.example.transaction.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@Setter
@ToString
@Entity
@Table (name = "transactions_tbl")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private String phone_Number;
    @Column(nullable = false)
    private double amount;
    @Column(name = "mpesa_Request_Status")
    private String mpesa_Request_Status;
    @Column(name = "mpesa_Response")
    private String mpesa_Response;
    // Getters and Setters
}
