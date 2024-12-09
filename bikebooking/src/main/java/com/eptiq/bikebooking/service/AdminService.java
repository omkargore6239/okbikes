package com.eptiq.bikebooking.service;

import com.eptiq.bikebooking.model.Admin;
import com.eptiq.bikebooking.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin signup(Admin admin){
        return adminRepository.save(admin);
    }

    public Admin getAdminByEmail(String email){
        return adminRepository.findByEmail(email);
    }
}
