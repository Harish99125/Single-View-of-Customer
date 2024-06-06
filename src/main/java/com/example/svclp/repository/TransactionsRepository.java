package com.example.svclp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.svclp.entity.Transactions;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

	List<Transactions> findByAccountNumberFromOrAccountNumberTo(Long accountNumber, Long accountNumber2);

	

}
