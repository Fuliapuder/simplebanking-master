package com.eteration.simplebanking.executor;

import com.eteration.simplebanking.entity.Account;
import com.eteration.simplebanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class PhoneBillPaymentTransactionExecutor implements TransactionExecutor {

    @Autowired
    AccountService accountService;

    double amount;
    // buradaki double amount için bir abstract class oluşturup bunu oraya yazıp extend edersek
    // buraya yazmamış oluruz.

    private String provider;
    private String phoneNumber; // bunlar da sırf bu implementasyon için gerekli alanlar.

    public PhoneBillPaymentTransactionExecutor(double amount) {
        this.amount = amount;
        this.provider = "default_provider";
        this.phoneNumber = "1234567890";
    }

    public PhoneBillPaymentTransactionExecutor(double amount, String provider, String phoneNumber) {
        this.amount = amount;
        this.provider = provider;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void execute(Account account) {

        // account için burada başka bir tabloya gidilip, banka kullanıcısının kayıtlı telefon fatura numaralarını çekip işlem yapabiliriz.

        accountService.phoneBillPayment(account.getAccountNumber(), amount);
    }
}
