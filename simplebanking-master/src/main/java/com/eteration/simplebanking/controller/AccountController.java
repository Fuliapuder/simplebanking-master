package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.exception.ApiRequestException;
import com.eteration.simplebanking.api.ReponsePayload;
import com.eteration.simplebanking.entity.Account;
import com.eteration.simplebanking.enums.ResponseEnum;
import com.eteration.simplebanking.model.DepositRequestModel;
import com.eteration.simplebanking.repository.AccountRepository;
import com.eteration.simplebanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping(value = "/account",produces = "application/json")
// This class is a place holder you can change the complete implementation
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getAccount() {

        List<Account> list = accountRepository.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/deposit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReponsePayload deposit(@RequestBody DepositRequestModel depositRequestModel) {

        Optional<Account> optionalAccount = accountRepository.findByAccountNumber(depositRequestModel.getAccountNumber());

        try {
            accountService.deposite(depositRequestModel.getAccountNumber(), depositRequestModel.getTransactionAmount());

            return new ReponsePayload(ResponseEnum.OK);
        }
        catch (DataIntegrityViolationException ex)
        {
            throw new ApiRequestException("opps!!! başarısız");
        }
        catch (Exception ex)
        {
            throw new ApiRequestException("opps!!! başarısız");
        }
       /* TransactionExecutor transactionExecutor = TransactionFactory.createTransaction(TransactionType.DEPOSIT, 1000);
         if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            transactionExecutor.execute(account);
        }*/
       // return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/withdrawal", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReponsePayload withdrawal(@RequestBody DepositRequestModel depositRequestModel) {

        try {
            accountService.wihtdrawal(depositRequestModel.getAccountNumber(), depositRequestModel.getTransactionAmount());

            return new ReponsePayload(ResponseEnum.OK);
        }
        catch (DataIntegrityViolationException ex)
        {
            throw new ApiRequestException("opps!!! başarısız");
        }
        catch (Exception ex)
        {
            throw new ApiRequestException("opps!!! başarısız");
        }
    }

    @PostMapping(value = "/phonebillpayment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReponsePayload phoneBillPayment(@RequestBody DepositRequestModel depositRequestModel) {
        try {
            accountService.phoneBillPayment(depositRequestModel.getAccountNumber(), depositRequestModel.getTransactionAmount());

            return new ReponsePayload(ResponseEnum.OK);
        }
        catch (DataIntegrityViolationException ex)
        {
            throw new ApiRequestException("opps!!! başarısız");
        }
        catch (Exception ex)
        {
            throw new ApiRequestException("opps!!! başarısız");
        }
    }
}