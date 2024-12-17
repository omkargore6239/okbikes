package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.Customer;
import com.eptiq.bikebooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(
            @RequestParam MultipartFile profilePhoto,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String contactNumber,
            @RequestParam String alternateNumber,
            @RequestParam String status) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setContactNumber(contactNumber);
        customer.setAlternateNumber(alternateNumber);
        customer.setStatus(status);

        try {
            customer.setProfilePhoto(profilePhoto.getBytes());
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable Long id,
            @RequestParam MultipartFile profilePhoto,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String contactNumber,
            @RequestParam String alternateNumber,
            @RequestParam String status) {
        Optional<Customer> existingCustomer = customerService.getCustomerById(id);

        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setName(name);
            customer.setEmail(email);
            customer.setContactNumber(contactNumber);
            customer.setAlternateNumber(alternateNumber);
            customer.setStatus(status);

            try {
                customer.setProfilePhoto(profilePhoto.getBytes());
            } catch (IOException e) {
                return ResponseEntity.badRequest().build();
            }

            return ResponseEntity.ok(customerService.saveCustomer(customer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
