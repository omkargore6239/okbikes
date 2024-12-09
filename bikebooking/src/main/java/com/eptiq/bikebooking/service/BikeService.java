package com.eptiq.bikebooking.service;

import com.eptiq.bikebooking.model.Bike;
import com.eptiq.bikebooking.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> findAll(){
        return bikeRepository.findAll();
    }

    public Optional<Bike> findById(Long id){
        return bikeRepository.findById(id);
    }

    public Bike save(Bike bike){
        return bikeRepository.save(bike);
    }

    public void deleteById(Long id){
        bikeRepository.deleteById(id);
    }
}
