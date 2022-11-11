package com.rchbanking.api.controller;

import com.rchbanking.api.model.Account;
import com.rchbanking.api.model.Transaction;
import com.rchbanking.api.service.AccountService;
import com.rchbanking.api.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/transaction")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class TransactionController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create/{id}")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction, @PathVariable("id") Long id) {
        Optional<Account> account = accountService.findAccountById(id);
        transaction.setAccount(account.get());
        Transaction addedTransaction = transactionService.addTransaction(transaction);
        return new ResponseEntity<>(addedTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<Transaction>> getAllTransactionsByAccountId(@PathVariable("id") Long id) {
        List<Transaction> accountTransactions = transactionService.getAllTransactionsByAccountId(id);
        return new ResponseEntity<>(accountTransactions, HttpStatus.OK);
    }

    @GetMapping("/view-income/{id}")
    public ResponseEntity<List<Transaction>> getAllIncomeTransactionsById(@PathVariable("id") Long id) {
        List<Transaction> accountIncome = transactionService.getAllIncomeTransactions(id);
        return new ResponseEntity<>(accountIncome, HttpStatus.OK);
    }

    @GetMapping("/view-expenses/{id}")
    public ResponseEntity<List<Transaction>> getAllExpenseTransactionsById(@PathVariable("id") Long id) {
        List<Transaction> accountExpenses = transactionService.getAllExpenseTransactions(id);
        return new ResponseEntity<>(accountExpenses, HttpStatus.OK);
    }

}
