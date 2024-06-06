package com.example.svclp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.svclp.entity.Transactions;
import com.example.svclp.entity.AccountDetails;
import com.example.svclp.repository.TransactionsRepository;
import com.example.svclp.repository.AccountDetailsRepository;

@Service
public class TransactionsService {

    @Autowired
    private TransactionsRepository transactionRepository;

    @Autowired
    private AccountDetailsRepository accountDetailsRepository;

    @Transactional
    public Transactions saveTransaction(Transactions transaction) {
        if ("Loyalty_Share".equalsIgnoreCase(transaction.getTransactionType())) {
            handleLoyaltyShare(transaction);
        } else if ("Card".equalsIgnoreCase(transaction.getTransactionType())) {
            handleCardTransaction(transaction);
        } else if ("Loyalty Deposits".equalsIgnoreCase(transaction.getTransactionType())) { 
            handleLoyaltyDeposit(transaction); 
        }
        
        return transactionRepository.save(transaction);
    }

    private void handleLoyaltyShare(Transactions transaction) {
        AccountDetails accountFrom = accountDetailsRepository.findByCustomerAccountNumber(transaction.getAccountNumberFrom());
        AccountDetails accountTo = accountDetailsRepository.findByCustomerAccountNumber(transaction.getAccountNumberTo());

        if (accountFrom != null && accountTo != null) {
            if (accountFrom.getLoyaltyPoints() >= transaction.getLoyaltyPoints()) {
                accountFrom.setLoyaltyPoints(accountFrom.getLoyaltyPoints() - transaction.getLoyaltyPoints());
                accountTo.setLoyaltyPoints(accountTo.getLoyaltyPoints() + transaction.getLoyaltyPoints());
                accountDetailsRepository.save(accountFrom);
                accountDetailsRepository.save(accountTo);
            } else {
                
            }
        }
    }

    private void handleCardTransaction(Transactions transaction) {
        Long loyaltyPoints = (long) (transaction.getTransactionAmount() * 0.05);
        transaction.setLoyaltyPoints(loyaltyPoints);

        AccountDetails accountFrom = accountDetailsRepository.findByCustomerAccountNumber(transaction.getAccountNumberFrom());
        if (accountFrom != null) {
            accountFrom.setLoyaltyPoints(accountFrom.getLoyaltyPoints() + loyaltyPoints);
            accountDetailsRepository.save(accountFrom);
        }
    }
    
    private void handleLoyaltyDeposit(Transactions transaction) {
        Long loyaltyPoints = (long) (transaction.getTransactionAmount() * 0.10); 
        transaction.setLoyaltyPoints(loyaltyPoints);

        AccountDetails accountFrom = accountDetailsRepository.findByCustomerAccountNumber(transaction.getAccountNumberFrom()); 
        if (accountFrom != null) {
            accountFrom.setLoyaltyPoints(accountFrom.getLoyaltyPoints() + loyaltyPoints); 
            accountDetailsRepository.save(accountFrom); 
        }
    }

	public List<Transactions> getTransactionsByAccountNumber(Long accountNumber) {
		// TODO Auto-generated method stub
		return transactionRepository.findByAccountNumberFromOrAccountNumberTo(accountNumber, accountNumber);
    }

	
	}

