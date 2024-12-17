package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.Brand;
import com.eptiq.bikebooking.model.Store;
import com.eptiq.bikebooking.service.BrandService;
import com.eptiq.bikebooking.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    // Get all Brand
    @GetMapping("/list")
    public List<Brand> getAllBrands() {
        return brandService.findAll();
    }

    // Get a Brand by ID
    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
        Brand brand = brandService.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
        return ResponseEntity.ok(brand);
    }

    // Add a new Brand
    @PostMapping("/save")
    public Brand createBrand(@RequestBody Brand brand) {
        return brandService.save(brand);
    }

    // Update a Brand
    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand BrandDetails) {
        Brand brand = brandService.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));

        brand.setBrandName(BrandDetails.getBrandName());
        brand.setBrandImage(BrandDetails.getBrandImage());

        Brand updatedBrand = brandService.save(brand);
        return ResponseEntity.ok(updatedBrand);
    }

    // Delete a Brand
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        Brand brand = brandService.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
        brandService.deletedById(id);
        return ResponseEntity.noContent().build();
    }
}
