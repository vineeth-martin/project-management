package com.example.demo.controller;

import com.example.demo.entity.ShippingTerm;
import com.example.demo.service.ShippingTermsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shipping-terms")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from localhost:4200
public class ShippingTermsController {

    private final ShippingTermsService shippingTermsService;

    @Autowired
    public ShippingTermsController(ShippingTermsService shippingTermsService) {
        this.shippingTermsService = shippingTermsService;
    }

    // Define an endpoint to fetch all shipping terms
    @GetMapping
    public List<ShippingTerm> getShippingTerms() {
        return shippingTermsService.getAllShippingTerms();
    }
}
