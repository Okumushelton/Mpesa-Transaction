package com.example.transaction.controller;

import com.example.transaction.model.Transaction;
import com.example.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService eService;

    //HTTP Request to get data from the database
    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return eService.getTransaction();
    }
    @GetMapping("transactions/{id}")
    public Transaction getTransaction(@PathVariable Long id){

        return eService.getSingleTransaction(id);
    }

    //Http request to send data to the database.
    @PostMapping("/transactions")
    public Transaction saveTransaction(@RequestBody Transaction transaction) {

        return eService.saveTransaction(transaction);
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestParam String phoneNumber, @RequestParam Double amount) {
        Transaction transaction = transactionService.createTransaction(phoneNumber, amount);
        // Call Daraja API to initiate transaction
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @PostMapping("/callback")
    public ResponseEntity<String> handleCallback(@RequestBody CallbackRequest callbackRequest) {
        // Process callback and update transaction status
        return new ResponseEntity<>("Callback received", HttpStatus.OK);
    }

    @PutMapping("/transactions/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction){
        transaction.setId(id);
        return eService.updateTransaction(transaction);
    }

    @DeleteMapping("/transactions")
    public void deleteTransaction (@RequestParam Long id){
        eService.deleteTransaction(id);
    }


}
