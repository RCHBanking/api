package com.rchbanking.api.repository;

import com.rchbanking.api.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository {
    List<Account> findAllByAccountId(Long id);
}
