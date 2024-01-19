package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,String> ,
        CrudRepository<Transaction,String>,
        JpaSpecificationExecutor<Transaction>,
        PagingAndSortingRepository<Transaction,String> {
    List<Transaction> findAll();
}
