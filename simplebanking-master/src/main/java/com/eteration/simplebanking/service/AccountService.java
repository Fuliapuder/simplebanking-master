package com.eteration.simplebanking.service;

import com.eteration.simplebanking.entity.Account;
import com.eteration.simplebanking.entity.Transaction;
import com.eteration.simplebanking.enums.TransactionType;
import com.eteration.simplebanking.repository.AccountRepository;
import com.eteration.simplebanking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public Account deposite(String accountNumber, Double transactionAmount){
        Account account = accountRepository.findById(accountNumber).orElseThrow();

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionAmount);
        transaction.setType(TransactionType.DEPOSIT);
        transaction.setTransactionDate(new Date());
        transaction.setAccount(account);

        transactionRepository.save(transaction);

        // Update balance and save the account
        updateAccountAmount(account, transactionAmount);
        return account;

    }

    @Transactional
    public Account wihtdrawal(String accountNumber, Double transactionAmount){
        Account account = accountRepository.findById(accountNumber).orElseThrow();

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionAmount);
        transaction.setType(TransactionType.WITHDRAWAL);
        transaction.setTransactionDate(new Date());
        transaction.setAccount(account);

        transactionRepository.save(transaction);

        // Update balance and save the account
        updateAccountAmount(account, -transactionAmount);// burada eksi bakiye gönderiliyor.
        return account;

    }
    @Transactional
    public Account phoneBillPayment(String accountNumber, Double transactionAmount) {
        Account account = accountRepository.findById(accountNumber).orElseThrow();

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionAmount);
        transaction.setType(TransactionType.PHONE_BILL_PAYMENT);
        transaction.setTransactionDate(new Date());
        transaction.setAccount(account);

        transactionRepository.save(transaction);

        // Update balance and save the account
        updateAccountAmount(account, transactionAmount);
        return account;
    }



    /**
     * private metodlar, yalnızca bu class içinde kullanılır. kod karmasıklığını gidermek için metod oluşturdum.
     * @param account güncellenecek olan hesap
     * @param transactionAmount güncellenecek olan transaction amount
     */
    private void updateAccountAmount(Account account, double transactionAmount) {
        double totalAmount = account.getBalance() + transactionAmount;
        account.setBalance(totalAmount);
        accountRepository.save(account);
    }
}