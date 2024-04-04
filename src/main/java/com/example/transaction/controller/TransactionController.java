package com.example.transaction.controller;

import com.example.transaction.model.Transaction;
import com.example.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService eService;

    //HHTP Request to get data from the database
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
