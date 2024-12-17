package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.PickUpTariffPlan;
import com.eptiq.bikebooking.service.PickUpTariffPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/pickuptariffplan")
public class PickUpTariffPlanController {

    @Autowired
    private PickUpTariffPlanService pickUpTariffPlanService;

    //Get all price plan
    @GetMapping("/price/list")
    public List<PickUpTariffPlan> getAllPickUpTariffPlan(){
        return pickUpTariffPlanService.findAll();
    }

    //Get a price plan by ID
    @GetMapping("/price/{id}")
    public ResponseEntity<PickUpTariffPlan> getPickUpTariffPlan(@PathVariable Long id){
        PickUpTariffPlan pickUpTariffPlan = pickUpTariffPlanService.findById(id)
                .orElseThrow(() -> new RuntimeException("Pick Up Tariff Plan not found with id: "+id));
        return ResponseEntity.ok(pickUpTariffPlan);
    }

    //Add a new PickUp tariff Plan/price
    @PostMapping("/price/save")
    public PickUpTariffPlan createPickUpTariffPlan(@RequestBody PickUpTariffPlan pickUpTariffPlan){
        return pickUpTariffPlanService.save(pickUpTariffPlan);
    }

    //Update a PickUp plan
    @PutMapping("/price/{id}")
    public ResponseEntity<PickUpTariffPlan> updatePickUpTariffPlan(@PathVariable Long id, @RequestBody PickUpTariffPlan priceDetails){
        PickUpTariffPlan pickUpTariffPlan = pickUpTariffPlanService.findById(id)
                .orElseThrow(()-> new RuntimeException("Price not fount with id: "+id));

        pickUpTariffPlan.setVehicleCategoryName(priceDetails.getVehicleCategoryName());
        pickUpTariffPlan.setPrice(priceDetails.getPrice());
        pickUpTariffPlan.setDays(priceDetails.getDays());
        pickUpTariffPlan.setDepositeAmount(priceDetails.getDepositeAmount());

        PickUpTariffPlan updatedPrice = pickUpTariffPlanService.save(pickUpTariffPlan);
        return ResponseEntity.ok(updatedPrice);
    }
}
