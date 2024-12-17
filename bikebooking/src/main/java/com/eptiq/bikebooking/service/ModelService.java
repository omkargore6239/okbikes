package com.eptiq.bikebooking.service;

import com.eptiq.bikebooking.model.Model;
import com.eptiq.bikebooking.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public List<Model> findAll(){
        return  modelRepository.findAll();
    }

    public Optional<Model> findById(Long id){
        return modelRepository.findById(id);
    }

    public Model save(Model model){
        return modelRepository.save(model);
    }

    public void deletedById(Long id){
        modelRepository.deleteById(id);
    }
}
