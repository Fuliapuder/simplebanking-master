package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,String>,
        CrudRepository<Account,String>,
        JpaSpecificationExecutor<Account>,
        PagingAndSortingRepository<Account,String> {
    List<Account> findAll();

    Optional<Account> findByAccountNumber(String accountNumber);
}
