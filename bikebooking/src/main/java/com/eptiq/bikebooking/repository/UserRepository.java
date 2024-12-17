package com.eptiq.bikebooking.repository;

import com.eptiq.bikebooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
