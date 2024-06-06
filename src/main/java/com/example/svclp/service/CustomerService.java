package com.example.svclp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.svclp.entity.AccountDetails;
import com.example.svclp.entity.Customer;
import com.example.svclp.entity.LoyaltyPoints;
import com.example.svclp.repository.AccountDetailsRepository;
import com.example.svclp.repository.CustomerRepository;
import com.example.svclp.repository.LoyaltyPointsRepository;



@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoyaltyPointsRepository loyaltyPointsRepository;

    @Autowired
    private AccountDetailsRepository accountDetailsRepository;

    public Customer createCustomer(Customer customer) {
        
        
        customer.setLoyaltyPoints(150);

        
        Customer savedCustomer = customerRepository.save(customer);

        
        Long loyaltyPointsNumber = generateLoyaltyPointsNumber();

        
        LoyaltyPoints loyaltyPoints = new LoyaltyPoints();
        loyaltyPoints.setCustomerAccountNumber(savedCustomer.getCustomerAccountNumber());
        loyaltyPoints.setLoyaltyPointsNumber(loyaltyPointsNumber);
        loyaltyPoints.setLoyaltyPoints(150L);
        loyaltyPointsRepository.save(loyaltyPoints);

        
        String cardNumber = generateCardNumber();

      
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setCustomerAccountNumber(savedCustomer.getCustomerAccountNumber());
        accountDetails.setLoyaltyPointsNumber(loyaltyPointsNumber);
        accountDetails.setLoyaltyPoints(150L);
        accountDetails.setFirstName(savedCustomer.getFirstName());
        accountDetails.setLastName(savedCustomer.getLastName());
        accountDetails.setAadhar(savedCustomer.getAadhar());
        accountDetails.setCardNumber(cardNumber);
        accountDetailsRepository.save(accountDetails);

        return savedCustomer;
    }
    
    

    
    private Long generateLoyaltyPointsNumber() {
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }

    
    private String generateCardNumber() {
        return Long.toString((long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }




	public Customer getCustomerByAccountNumber(Long accountNumber) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustomerAccountNumber(accountNumber);
	}
}
