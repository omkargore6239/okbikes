package com.eptiq.bikebooking.repository;

import com.eptiq.bikebooking.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike, Long> {

    @Query("SELECT b FROM Bike b WHERE b.store.city = :city")
    List<Bike> findBikesByCity(@Param("city") String city);
}

