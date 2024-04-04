package com.example.transaction.service;

import com.example.transaction.model.Transaction;
import com.example.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository eRepository;

//    public List<Transaction> getTransactions() {
//        return eRepository.findAll();
//    }

    @Override
    public List<Transaction> getTransaction() {

        return eRepository.findAll();
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
       return eRepository.save(transaction);
    }

    @Override
    public Transaction getSingleTransaction(Long id) {
        Optional<Transaction> transaction = eRepository.findById(id);
        if (transaction.isPresent()){
            return transaction.get();
        }
        throw new RuntimeException("Transaction not found for ID "+id);
    }

    @Override
    public void deleteTransaction(Long id) {
        eRepository.deleteById(id);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        return eRepository.save(transaction);
    }
}