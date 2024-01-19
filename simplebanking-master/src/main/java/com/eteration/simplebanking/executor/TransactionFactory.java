package com.eteration.simplebanking.executor;

import com.eteration.simplebanking.enums.TransactionType;
import org.springframework.stereotype.Component;

@Component
public class TransactionFactory {

    public static TransactionExecutor createTransaction(TransactionType type, double amount) {

        switch (type) {
            case DEPOSIT:
                return new DepositTransactionExecutor(amount);
            case WITHDRAWAL:
                return new WithdrawalTransactionExecutor(amount);
            case PHONE_BILL_PAYMENT:
                return new PhoneBillPaymentTransactionExecutor(amount);
            default:
                throw new IllegalArgumentException("Unsupported Transaction");

        }
    }

}
