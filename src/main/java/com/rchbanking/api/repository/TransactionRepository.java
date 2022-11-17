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

    @Query(value = "SELECT sum(t.amount) FROM transactions t WHERE account_id= ?1 AND transaction_type ='DEPOSIT'", nativeQuery = true)
    Double findIncomeSum(Long id);

    @Query(value = "SELECT sum(t.amount) FROM transactions t WHERE account_id= ?1 AND t.transaction_type='WITHDRAWAL' OR account_id= ?1 AND t.transaction_type ='PAYMENT' OR account_id= ?1 AND t.transaction_type ='TRANSFER';", nativeQuery = true)
    Double findExpenseSum(Long id);



}
