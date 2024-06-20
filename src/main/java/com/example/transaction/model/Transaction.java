package com.example.transaction.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table (name = "transactions_tbl")

// This Model Creates Database Entities

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private String phone_Number;
    @Column(nullable = false)
    private double amount;
    @Column(name = "status")
    private String mpesa_Request_Status;
    // Getters and Setters

    //Create Timestamps in the DataBase
    @CreationTimestamp()
    @Column(name = "created_At", nullable = false, updatable = false)
    private Date createdA;
    @UpdateTimestamp
    @Column(name = "updated_At", nullable = false, updatable = false)
    private Date updatedAt;
}
