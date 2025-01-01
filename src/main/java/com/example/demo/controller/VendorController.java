package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Vendor;
import com.example.demo.service.VendorService;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from localhost:4200

public class VendorController {
    @Autowired
    private VendorService vendorService;

    @PostMapping
    public Vendor createOrUpdateVendor(@RequestBody Vendor vendor) {
    	System.out.println("Vendor ID: " + vendor.getVendorId());
        vendor.setVendorId(null);

        return vendorService.saveOrUpdate(vendor);
    }
    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.findAll(); // Assume `findAll` is implemented in VendorService
    }

    // Add Delete Mapping
    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable Integer id) {
        vendorService.deleteById(id); // Call the delete method from the service
    }
}
