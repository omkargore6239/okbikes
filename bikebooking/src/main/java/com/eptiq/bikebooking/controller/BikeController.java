package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.Bike;
import com.eptiq.bikebooking.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bikes")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    //Get all Bikes
    @GetMapping("/list")
    public List<Bike> getAllBikes(){
        return bikeService.findAll();
    }

    //Get a Bike By id
    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBikeById(@PathVariable Long id){
        Bike bike=bikeService.findById(id)
        .orElseThrow(()-> new RuntimeException("Bike not fount with id:"+ id));
        return ResponseEntity.ok(bike);
    }

    //Add a new Bike
    @PostMapping("/save")
    public Bike createBike(@RequestBody Bike bike){
        return bikeService.save(bike);
    }

    //Update a Bike
    @PutMapping("/{id}")
    public ResponseEntity<Bike> updateBike(@PathVariable Long id ,@RequestBody Bike bikeDetails) {
        Bike bike = bikeService.findById(id)
                .orElseThrow(() -> new RuntimeException("Bike not found with id:" + id));
        bike.setBrandName(bikeDetails.getBrandName());
        bike.setCategory(bike.getCategory());
        bike.setModelName(bike.getModelName());
        bike.setVehicleRegistrationNumber(bike.getVehicleRegistrationNumber());
        bike.setAddedBy(bike.getAddedBy());
        bike.setRegistrationYear(bike.getRegistrationYear());
        bike.setVehicleChassisNumber(bike.getVehicleChassisNumber());
        bike.setVehicleEngineNumber(bike.getVehicleEngineNumber());
        bike.setStoreName(bike.getStoreName());
        bike.setPuc(bike.getPuc());
        bike.setInsurance(bike.getInsurance());
        bike.setDocument(bike.getDocument());
        bike.setVehicleImage(bike.getVehicleImage());


        Bike updatedBikeDetails = bikeService.save(bike);
        return ResponseEntity.ok(updatedBikeDetails);
    }

    //Delete a Bike
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBike(@PathVariable Long id){
        Bike bike = bikeService.findById(id)
                .orElseThrow(()-> new RuntimeException("Bike not found with id: "+ id));
        bikeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//    //to get the bikes by city
//    @GetMapping("/city/{city}")
//    public List<Bike> getBikesByCity(@PathVariable String city) {
//        return bikeService.findBikesByCity(city);
//    }
}
