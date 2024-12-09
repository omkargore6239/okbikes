package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.Admin;
import com.eptiq.bikebooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins="http://localhost:5173")
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/")
    public ResponseEntity<Admin> signup(@RequestBody Admin admin){
        Admin admin1=this.adminService.signup(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(admin1);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin admin){
        Admin admin1=adminService.getAdminByEmail(admin.getEmail());
        if(admin1 != null && admin1.getPassword().equals(admin.getPassword())){
            System.out.println("Logged Successfully...!");
            return ResponseEntity.ok("Logged Successfully...!");
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials..!");
        }
    }
}
