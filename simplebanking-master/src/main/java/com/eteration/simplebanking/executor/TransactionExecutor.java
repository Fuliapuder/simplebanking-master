package com.eteration.simplebanking.executor;

import com.eteration.simplebanking.entity.Account;

public interface TransactionExecutor {

    void execute(Account account);
	
}
