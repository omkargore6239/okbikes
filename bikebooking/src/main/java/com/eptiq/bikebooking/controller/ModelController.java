package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.Model;
import com.eptiq.bikebooking.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    // Get all Model
    @GetMapping("/list")
    public List<Model> getAllModels() {
        return modelService.findAll();
    }

    // Get a Model by ID
    @GetMapping("/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable Long id) {
        Model model = modelService.findById(id)
                .orElseThrow(() -> new RuntimeException("Model not found with id: " + id));
        return ResponseEntity.ok(model);
    }

    // Add a new Model
    @PostMapping("/save")
    public Model createModel(@RequestBody Model model) {
        return modelService.save(model);
    }



    // Update a Model
    @PutMapping("/{id}")
    public ResponseEntity<Model> updateModel(@PathVariable Long id, @RequestBody Model modelDetails) {
        Model model = modelService.findById(id)
                .orElseThrow(() -> new RuntimeException("Model not found with id: " + id));

        model.setModelName(modelDetails.getModelName());
        model.setBrandName(modelDetails.getBrandName());

        Model updatedModel = modelService.save(model);
        return ResponseEntity.ok(updatedModel);
    }

    // Delete a store
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable Long id) {
        Model model = modelService.findById(id)
                .orElseThrow(() -> new RuntimeException("Model not found with id: " + id));
        modelService.deletedById(id);
        return ResponseEntity.noContent().build();
    }
}
