package com.example.transaction.service;

import com.example.transaction.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getTransaction();

    Transaction saveTransaction (Transaction transaction);

    Transaction getSingleTransaction(Long id);

    void deleteTransaction (Long id);

    Transaction updateTransaction (Transaction transaction);
}
