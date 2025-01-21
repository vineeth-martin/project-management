package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item saveOrUpdate(Item item) {
    	if (itemRepository.existsByPartNo(item.getPartNo())) {
    	    throw new RuntimeException("Part number already exists");
    	}
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    public void deleteById(Integer itemId) {
        itemRepository.deleteById(itemId); // Calls the repository method to delete an item by ID
    }
    // Update an existing item
    public Item updateItem(Integer itemId, Item updatedItem) {
        Item existingItem = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + itemId));

        // Update fields
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setPartNo(updatedItem.getPartNo());
        existingItem.setUnitPrice(updatedItem.getUnitPrice());
        existingItem.setMake(updatedItem.getMake());
        existingItem.setUom(updatedItem.getUom()); // Include UOM in the update logic


        // Save the updated item
        return itemRepository.save(existingItem);
    }

}
