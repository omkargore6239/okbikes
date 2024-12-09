package com.eptiq.bikebooking.repository;

import com.eptiq.bikebooking.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {
}
