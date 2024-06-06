package com.example.svclp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.svclp.entity.AccountDetails;
import com.example.svclp.repository.AccountDetailsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountDetailsService {

    @Autowired
    private AccountDetailsRepository accountDetailsRepository;

    public Optional<AccountDetails> getAccountDetailsById(Long id) {
        return accountDetailsRepository.findById(id);
    }

    public AccountDetails createAccountDetails(AccountDetails accountDetails) {
        return accountDetailsRepository.save(accountDetails);
    }

    public void deleteAccountDetails(Long id) {
        accountDetailsRepository.deleteById(id);
    }

    public AccountDetails updateAccountDetails(Long customerAccountNumber, AccountDetails updatedAccountDetails) {
        AccountDetails existingAccountDetails = accountDetailsRepository.findById(customerAccountNumber)
                .orElseThrow(() -> new RuntimeException("Account details not found for customer with account number: " + customerAccountNumber));

        existingAccountDetails.setFirstName(updatedAccountDetails.getFirstName());
        existingAccountDetails.setLastName(updatedAccountDetails.getLastName());
        existingAccountDetails.setAadhar(updatedAccountDetails.getAadhar());
        
        
        return accountDetailsRepository.save(existingAccountDetails);
    }

    public List<AccountDetails> getAllAccountDetails() {
        return accountDetailsRepository.findAll();
	}

	public AccountDetails getAccountDetailsByAccountNumber(Long accountNumber) {
		// TODO Auto-generated method stub
		 return accountDetailsRepository.findByCustomerAccountNumber(accountNumber);
	}
}
