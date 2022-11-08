package com.rchbanking.api.service;

import com.rchbanking.api.model.Account;


import com.rchbanking.api.repository.AccountRepository;
import com.rchbanking.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class AccountService {
    private final AccountRepository accountRepository;


    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> getAllAccountsByCustomerId(Long id){
        return accountRepository.findAllByCustomerId(id);
    }

}
