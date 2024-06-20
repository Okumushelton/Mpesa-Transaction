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

    @Autowired
    private TransactionService transactionService;

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
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        String response = transactionService.initiateCheckout(transaction.getPhoneNumber(), transaction.getAmount());
        savedTransaction.setStatus(response);
        return transactionRepository.save(savedTransaction);
    }

//    endpoint to handle the callback from Safaricom
    @PostMapping("/callback")
    public void handleCallback(@RequestBody TransactionCallbackResponse callbackResponse) {
        //  update the transaction status based on callbackResponse
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
