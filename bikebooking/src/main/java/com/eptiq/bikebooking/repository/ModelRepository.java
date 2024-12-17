package com.eptiq.bikebooking.repository;

import com.eptiq.bikebooking.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {

}
