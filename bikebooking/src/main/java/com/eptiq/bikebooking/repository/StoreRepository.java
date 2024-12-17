package com.eptiq.bikebooking.repository;

import com.eptiq.bikebooking.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
