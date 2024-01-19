package com.eteration.simplebanking.executor;
// This class is a place holder you can change the complete implementation

import com.eteration.simplebanking.entity.Account;
import com.eteration.simplebanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class WithdrawalTransactionExecutor implements TransactionExecutor {

    @Autowired
    AccountService accountService;

    private double amount;

    public WithdrawalTransactionExecutor(double amount) {
        this.amount = amount;
    }

    @Override
    public void execute(Account account) {

        // deposit işlemi için business logic yaz.
        accountService.wihtdrawal(account.getAccountNumber(), amount);
    }
}


