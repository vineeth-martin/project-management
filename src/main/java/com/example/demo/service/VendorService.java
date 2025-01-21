package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    public Vendor saveOrUpdate(Vendor vendor) {
        if (vendorRepository.existsByName(vendor.getName())) {
            throw new RuntimeException("Vendor name already exists");
        }
        return vendorRepository.save(vendor);
    }
    public List<Vendor> findAll() {
        return vendorRepository.findAll();
    }
    public void deleteById(Integer id) {
        vendorRepository.deleteById(id);
    }
    // Update an existing vendor
    public Vendor updateVendor(Integer vendorId, Vendor updatedVendor) {
        Vendor existingVendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found with id: " + vendorId));

        // Update fields
        existingVendor.setName(updatedVendor.getName());
        existingVendor.setAddress(updatedVendor.getAddress());
        existingVendor.setPostAddress(updatedVendor.getPostAddress());
        existingVendor.setTrn(updatedVendor.getTrn());

        return vendorRepository.save(existingVendor);
    }
}
