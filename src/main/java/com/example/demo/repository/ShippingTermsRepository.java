package com.example.demo.repository;

import com.example.demo.entity.ShippingTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingTermsRepository extends JpaRepository<ShippingTerm, Integer> {
    // No additional methods are needed for now, JpaRepository provides built-in methods
}
