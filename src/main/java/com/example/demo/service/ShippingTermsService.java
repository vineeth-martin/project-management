package com.example.demo.service;

import com.example.demo.entity.ShippingTerm;
import com.example.demo.repository.ShippingTermsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingTermsService {

    private final ShippingTermsRepository shippingTermsRepository;

    @Autowired
    public ShippingTermsService(ShippingTermsRepository shippingTermsRepository) {
        this.shippingTermsRepository = shippingTermsRepository;
    }

    // Fetch all shipping terms directly as entities
    public List<ShippingTerm> getAllShippingTerms() {
        return shippingTermsRepository.findAll();
    }
}
