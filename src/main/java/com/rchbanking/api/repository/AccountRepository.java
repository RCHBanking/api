package com.rchbanking.api.repository;

import com.rchbanking.api.model.Account;
import com.rchbanking.api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByCustomerId(Long id);
}
