package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from localhost:4200
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item createOrUpdateItem(@RequestBody Item item) {
    	item.setItemId(null);
        return itemService.saveOrUpdate(item);
    }
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
}

