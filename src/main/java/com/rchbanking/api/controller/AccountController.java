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
import java.util.Optional;

@RequestMapping("api/account")
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;



    @PostMapping("/createAccount/{id}")
    public ResponseEntity<Account> addAccount(@RequestBody Account account, @PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findCustomerById(id);
        account.setCustomer(customer.get());
        Account addedAccount = accountService.addAccount(account);

        return new ResponseEntity<>(addedAccount, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

}
