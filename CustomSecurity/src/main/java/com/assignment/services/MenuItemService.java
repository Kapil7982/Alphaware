package com.assignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.exception.ResourceNotFoundException;
import com.assignment.models.MenuItem;
import com.assignment.repositories.MenuItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getAllMenuItems(Long restaurantId) {
        return menuItemRepository.findAll().stream().filter(item -> item.getRestaurantId().equals(restaurantId)).collect(Collectors.toList());
    }

    public Optional<MenuItem> getMenuItemById(Long id) {
        return menuItemRepository.findById(id);
    }

    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(Long id, MenuItem menuItemDetails) throws ResourceNotFoundException {
        MenuItem menuItem = menuItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu Item not found"));
        menuItem.setName(menuItemDetails.getName());
        menuItem.setDescription(menuItemDetails.getDescription());
        menuItem.setPrice(menuItemDetails.getPrice());
        return menuItemRepository.save(menuItem);
    }

    public void deleteMenuItem(Long id) throws ResourceNotFoundException {
        MenuItem menuItem = menuItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu Item not found"));
        menuItemRepository.delete(menuItem);
    }
}

