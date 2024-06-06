package com.example.svclp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.svclp.entity.AccountDetails;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {

	AccountDetails findByCustomerAccountNumber(Long accountNumberFrom);

	
   
}
