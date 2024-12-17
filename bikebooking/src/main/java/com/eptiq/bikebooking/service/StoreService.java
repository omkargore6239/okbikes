package com.eptiq.bikebooking.service;

import com.eptiq.bikebooking.model.Store;
import com.eptiq.bikebooking.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> findAll(){
        return storeRepository.findAll();
    }

    public Optional<Store> findById(Long id){
        return storeRepository.findById(id);
    }

    public Store save(Store store){
        return storeRepository.save(store);
    }

    public void deleteById(Long id){
        storeRepository.deleteById(id);
    }
}
