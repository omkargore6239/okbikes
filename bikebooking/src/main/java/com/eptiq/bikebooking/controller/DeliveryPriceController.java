package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.DeliveryPrice;
import com.eptiq.bikebooking.service.DeliveryPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/deliveryprice")
public class DeliveryPriceController {

    @Autowired
    private DeliveryPriceService deliveryPriceService;

    //Get all delivery prices
    @GetMapping("/list")
    public List<DeliveryPrice> getAllDeliveryPrices(){
        return deliveryPriceService.findAll();
    }

    //Get a delivery price by id
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryPrice> getDeliveryPriceById(@PathVariable Long id){
        DeliveryPrice deliveryPrice = deliveryPriceService.findById(id)
                .orElseThrow(()-> new RuntimeException("Devlivery price not fount with id "+ id));
        return ResponseEntity.ok(deliveryPrice);
    }

    //Add A new Delivery Price
    @PostMapping("/save")
    public DeliveryPrice createDeliveryPrice(@RequestBody DeliveryPrice deliveryPrice){
        return deliveryPriceService.save(deliveryPrice);
    }

    //Update a Delivery price
    @PutMapping("/{id}")
    public ResponseEntity<DeliveryPrice> updateDeliveryPrice(@PathVariable Long id, @RequestBody DeliveryPrice deliveryPriceDetails){
        DeliveryPrice deliveryPrice = deliveryPriceService.findById(id)
                .orElseThrow(()-> new RuntimeException("Delivery Price not fount with id :" +id));
        deliveryPrice.setPrice(deliveryPriceDetails.getPrice());

        DeliveryPrice updatedDeliveryPrice = deliveryPriceService.save(deliveryPrice);
        return ResponseEntity.ok(updatedDeliveryPrice);
    }
}
