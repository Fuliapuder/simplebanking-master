package com.eteration.simplebanking.executor;


import com.eteration.simplebanking.entity.Account;
import com.eteration.simplebanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

// This class is a placeholder you can change the complete implementation
public class DepositTransactionExecutor implements TransactionExecutor {


    @Autowired
    private AccountService accountService;

    private double amount;

    public DepositTransactionExecutor(double amount) {
        this.amount = amount;
    }

    @Override
    public void execute(Account account) {
        // deposit işlemi için business logic yaz.
        accountService.deposite(account.getAccountNumber(), amount);
    }
}