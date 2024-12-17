package com.eptiq.bikebooking.service;

import com.eptiq.bikebooking.model.DeliveryPrice;
import com.eptiq.bikebooking.repository.DeliveryPriceRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryPriceService {

    @Autowired
    private DeliveryPriceRepository deliveryPriceRepository;

    public List<DeliveryPrice> findAll(){
        return deliveryPriceRepository.findAll();
    }

    public Optional<DeliveryPrice> findById(Long id){
        return deliveryPriceRepository.findById(id);
    }

    public DeliveryPrice save(DeliveryPrice deliveryPrice){
        return deliveryPriceRepository.save(deliveryPrice);
    }
}
