package com.rchbanking.api.controller;

import com.rchbanking.api.model.Account;
import com.rchbanking.api.model.Customer;
import com.rchbanking.api.service.AccountService;
import com.rchbanking.api.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/account")
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;



    @PostMapping("/createAccount")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        Account addedAccount = accountService.addAccount(account);
        return new ResponseEntity<>(addedAccount, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

}
