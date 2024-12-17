package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.Category;
import com.eptiq.bikebooking.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Get all Categories
    @GetMapping("/list")
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }

    //Get a Category by Id
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        Category category = categoryService.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not fount with id: "+id));
        return ResponseEntity.ok(category);
    }

    //Add a New Category
    @PostMapping("/save")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    //Update a Category
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails){
        Category category = categoryService.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not fount id: "+id));

        category.setCategoryName(categoryDetails.getCategoryName());
        category.setImage(categoryDetails.getImage());

        Category updatedCategory = categoryService.save(category);
        return ResponseEntity.ok(updatedCategory);
    }

    // Delete a store
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        Category category = categoryService.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
