package com.eptiq.bikebooking.repository;

import com.eptiq.bikebooking.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
