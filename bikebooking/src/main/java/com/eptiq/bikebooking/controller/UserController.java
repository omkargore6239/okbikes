package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.User;
import com.eptiq.bikebooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestPart("user") User user,
                                           @RequestPart("identityProof") MultipartFile identityProof,
                                           @RequestPart("aadharOrPanOrDrivingLicense") MultipartFile aadharFile) {
        try {
            user.setIdentityProof(identityProof.getBytes());
            user.setAadharOrPanOrDrivingLicense(aadharFile.getBytes());
            return ResponseEntity.ok(userService.saveUser(user));
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestPart("user") User userDetails,
                                           @RequestPart("identityProof") MultipartFile identityProof,
                                           @RequestPart("aadharOrPanOrDrivingLicense") MultipartFile aadharFile) {
        Optional<User> existingUser = userService.getUserById(id);

        if (existingUser.isPresent()) {
            try {
                User user = existingUser.get();
                user.setFullName(userDetails.getFullName());
                user.setEmailAddress(userDetails.getEmailAddress());
                user.setContactNumber(userDetails.getContactNumber());
                user.setAssignedStore(userDetails.getAssignedStore());
                user.setPassword(userDetails.getPassword());
                user.setIdentityProof(identityProof.getBytes());
                user.setAadharOrPanOrDrivingLicense(aadharFile.getBytes());
                return ResponseEntity.ok(userService.saveUser(user));
            } catch (IOException e) {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
