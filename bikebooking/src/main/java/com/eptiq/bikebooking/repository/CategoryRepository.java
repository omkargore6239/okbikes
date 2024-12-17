package com.eptiq.bikebooking.repository;

import com.eptiq.bikebooking.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
