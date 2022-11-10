package com.rchbanking.api.controller;

import com.rchbanking.api.model.Transaction;
import com.rchbanking.api.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/transaction")
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        Transaction addedTransaction = transactionService.addTransaction(transaction);
        return new ResponseEntity<>(addedTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK)
    }
}
