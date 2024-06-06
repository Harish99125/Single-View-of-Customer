package com.example.svclp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.svclp.service.LoyaltyPointsService;
import java.util.List;
import com.example.svclp.entity.LoyaltyPoints;

@RestController
@RequestMapping("/loyalty-points") 
public class LoyaltyPointsController {
    
    @Autowired
    private LoyaltyPointsService loyaltyPointsService;

    
    @GetMapping("/all")
    public List<LoyaltyPoints> getAllLoyaltyPoints() {
        return loyaltyPointsService.getAllLoyaltyPoints();
    }
}

