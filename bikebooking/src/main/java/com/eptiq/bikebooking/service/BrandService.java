package com.eptiq.bikebooking.service;

import com.eptiq.bikebooking.model.Brand;
import com.eptiq.bikebooking.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> findAll(){
        return brandRepository.findAll();
    }

    public Optional<Brand> findById(Long id){
        return  brandRepository.findById(id);
    }

    public Brand save(Brand brand){
        return brandRepository.save(brand);
    }

    public void deletedById(Long id){
        brandRepository.deleteById(id);
    }
}
