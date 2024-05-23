package com.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.assignment.exception.ResourceNotFoundException;
import com.assignment.models.MenuItem;
import com.assignment.services.MenuItemService;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/menu-items")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<MenuItem> getAllMenuItems(@PathVariable Long restaurantId) {
        return menuItemService.getAllMenuItems(restaurantId);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long restaurantId, @PathVariable Long id) throws ResourceNotFoundException {
        MenuItem menuItem = menuItemService.getMenuItemById(id).orElseThrow(() -> new ResourceNotFoundException("Menu Item not found"));
        return ResponseEntity.ok().body(menuItem);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public MenuItem createMenuItem(@PathVariable Long restaurantId, @RequestBody MenuItem menuItem) {
        menuItem.setRestaurantId(restaurantId);
        return menuItemService.addMenuItem(menuItem);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long restaurantId, @PathVariable Long id, @RequestBody MenuItem menuItemDetails) throws ResourceNotFoundException {
        MenuItem updatedMenuItem = menuItemService.updateMenuItem(id, menuItemDetails);
        return ResponseEntity.ok(updatedMenuItem);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long restaurantId, @PathVariable Long id) throws ResourceNotFoundException {
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }
}

