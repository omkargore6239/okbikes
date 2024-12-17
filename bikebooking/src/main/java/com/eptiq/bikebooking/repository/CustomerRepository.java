package com.eptiq.bikebooking.repository;

import com.eptiq.bikebooking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
