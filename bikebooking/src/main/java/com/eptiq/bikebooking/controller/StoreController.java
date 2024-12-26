package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.Store;
import com.eptiq.bikebooking.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    // Get all stores
    @GetMapping("/list")
    public List<Store> getAllStores() {
        return storeService.findAll();
    }

    // Get a store by ID
    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
        Store store = storeService.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id: " + id));
        return ResponseEntity.ok(store);
    }
//    @GetMapping("/{id}")
//    public Optional<Store>getStoreById(@PathVariable Long id){
//        return storeService.findById(id);
//    }


    // Add a new store
    @PostMapping("/save")
    public Store createStore(@RequestBody Store store) {
        return storeService.save(store);
    }



    // Update a store
    @PutMapping("/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable Long id, @RequestBody Store storeDetails) {
        Store store = storeService.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id: " + id));

        store.setStoreName(storeDetails.getStoreName());
        store.setAddress(storeDetails.getAddress());
        store.setStoreContactNumber(storeDetails.getStoreContactNumber());
        store.setStoreGoogleMapUrl(storeDetails.getStoreGoogleMapUrl());
        store.setStoreImage(storeDetails.getStoreImage());
        store.setCity(storeDetails.getCity());

        Store updatedStore = storeService.save(store);
        return ResponseEntity.ok(updatedStore);
    }

    // Delete a store
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        Store store = storeService.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id: " + id));
        storeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
