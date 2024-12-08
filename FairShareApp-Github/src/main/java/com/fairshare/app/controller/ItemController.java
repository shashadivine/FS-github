package com.fairshare.app.controller;

import com.fairshare.app.model.Item;
import com.fairshare.app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Add an item
    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.addItem(item));
    }

    // Get all items
    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    // Get a specific item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    // Delete an item by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok("Item deleted successfully");
    }


    // Assign user to item (JSON input)
    @PostMapping("/assign")
    public ResponseEntity<Item> assignUserToItem(@RequestBody Map<String, Long> request) {
        Long itemId = request.get("itemId");
        Long userId = request.get("userId");
        return ResponseEntity.ok(itemService.assignUserToItem(itemId, userId));
    }

    // Remove a user from an item (JSON input)
    @PostMapping("/unassign")
    public ResponseEntity<Item> unassignUserFromItem(@RequestBody Map<String, Long> request) {
        Long itemId = request.get("itemId");
        Long userId = request.get("userId");
        return ResponseEntity.ok(itemService.unassignUserFromItem(itemId, userId));
    }
}
