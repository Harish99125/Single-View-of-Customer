package com.example.svclp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.svclp.entity.LoyaltyPoints;
import com.example.svclp.repository.LoyaltyPointsRepository;

@Service
public class LoyaltyPointsService {

    @Autowired
    private LoyaltyPointsRepository loyaltyPointsRepository;
    
    public List<LoyaltyPoints> getAllLoyaltyPoints() {
        return loyaltyPointsRepository.findAll();
    }

    public LoyaltyPoints updateLoyaltyPoints(Long customerAccountNumber, Long loyaltyPoints) {
        LoyaltyPoints existingLoyaltyPoints = loyaltyPointsRepository.findById(customerAccountNumber)
                .orElseThrow(() -> new RuntimeException("Loyalty points not found for customer with account number: " + customerAccountNumber));

        existingLoyaltyPoints.setLoyaltyPoints(loyaltyPoints);
        return loyaltyPointsRepository.save(existingLoyaltyPoints);
    }

	public LoyaltyPoints createLoyaltyPoints(LoyaltyPoints loyaltyPoints) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
