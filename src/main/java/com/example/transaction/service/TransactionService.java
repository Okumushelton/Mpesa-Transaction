package com.example.transaction.service;

import com.example.transaction.model.Transaction;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface TransactionService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String initiateCheckout(String phoneNumber, Double amount) {
        // URL and payload for Safaricom API
        String url = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";

        // Making the API call
        String response = restTemplate.postForObject(url, requestPayload, String.class);
        return response;
    }





    List<Transaction> getTransaction();

    Transaction saveTransaction (Transaction transaction);

    Transaction getSingleTransaction(Long id);

    void deleteTransaction (Long id);

    Transaction updateTransaction (Transaction transaction);
}
