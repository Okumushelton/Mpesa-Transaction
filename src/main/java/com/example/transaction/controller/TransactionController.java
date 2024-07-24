package com.example.transaction.controller;

import com.example.transaction.dtos.MpesaCheckoutResponse;
import com.example.transaction.model.Transaction;
import com.example.transaction.service.MpesaService;
import com.example.transaction.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("mobile-money")
public class TransactionController {

    Logger logger = LoggerFactory.getLogger(TransactionController.class);


    @Autowired
    private MpesaService mpesaService;

    @Autowired
    private TransactionService transactionService;

    //HTTP Request to get data from the database
    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return transactionService.getTransaction();
    }
    @GetMapping("transactions/{id}")
    public Transaction getTransaction(@PathVariable Long id){

        return transactionService.getSingleTransaction(id);
    }

    //Http request to send data to the database.
    @PostMapping("/transactions")
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        logger.info("::::: Called Create Transaction Method");
        return transactionService.saveTransaction(transaction);
    }


    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        logger.info("Called Create Transaction Method");
        Transaction savedTransaction = transactionService.saveTransaction(transaction);



        MpesaCheckoutResponse response = mpesaService.initiateCheckout(transaction.getPhone_Number(), transaction.getAmount());


//        savedTransaction.setStatus(response);
//        return transactionRepository.save(savedTransaction);

        return savedTransaction;
    }

////    endpoint to handle the callback from Safaricom
//    @PostMapping("/callback")
//    public void handleCallback(@RequestBody
//                                   TransactionCallbackResponse callbackResponse) {
//        //  update the transaction status based on callbackResponse
//    }

    @PutMapping("/transactions/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction){
        transaction.setId(id);
        return transactionService.updateTransaction(transaction);
    }

    @DeleteMapping("/transactions")
    public void deleteTransaction (@RequestParam Long id){
        transactionService.deleteTransaction(id);
    }

//Register url

}
