package com.eptiq.bikebooking.service;

import com.eptiq.bikebooking.model.PickUpTariffPlan;
import com.eptiq.bikebooking.repository.PickUpTariffPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PickUpTariffPlanService {

    @Autowired
    private PickUpTariffPlanRepository pickUpTariffPlanRepository;

    public List<PickUpTariffPlan> findAll(){
        return pickUpTariffPlanRepository.findAll();
    }

    public Optional<PickUpTariffPlan> findById(Long id){
        return pickUpTariffPlanRepository.findById(id);
    }

    public PickUpTariffPlan save(PickUpTariffPlan pickUpTariffPlan){
        return pickUpTariffPlanRepository.save(pickUpTariffPlan);
    }

}
