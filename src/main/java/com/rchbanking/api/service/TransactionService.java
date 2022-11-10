package com.rchbanking.api.service;

import com.rchbanking.api.model.Transaction;
import com.rchbanking.api.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction addTransaction(Transaction transaction) { return transactionRepository.save(transaction); }

    public List<Transaction> getAllTransactions() { return transactionRepository.findAll(); }

    public List<Transaction> getAllTransactionsByAccountId(Long id)  { return transactionRepository.findAllByAccountId(id); }


}
