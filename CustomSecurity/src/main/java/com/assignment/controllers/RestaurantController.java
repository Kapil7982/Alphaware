package com.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.assignment.exception.ResourceNotFoundException;
import com.assignment.models.Restaurant;
import com.assignment.services.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) throws ResourceNotFoundException {
        Restaurant restaurant = restaurantService.getRestaurantById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
        return ResponseEntity.ok().body(restaurant);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurantDetails) throws ResourceNotFoundException {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurantDetails);
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) throws ResourceNotFoundException {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}

