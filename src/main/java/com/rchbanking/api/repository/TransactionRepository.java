package com.rchbanking.api.repository;

import com.rchbanking.api.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByAccountId(Long id);

    @Query(value = "SELECT * FROM transactions where transactions.account_id = ?1 AND transactions.transaction_type = 'DEPOSIT'", nativeQuery = true)
    List<Transaction> findAllIncome(Long id);

    @Query(value = "SELECT * FROM transactions where transactions.account_id = ?1 EXCEPT SELECT * FROM transactions where transactions.account_id = ?1 AND transactions.transaction_type = 'DEPOSIT'", nativeQuery = true)
    List<Transaction> findAllExpenses(Long id);


}
