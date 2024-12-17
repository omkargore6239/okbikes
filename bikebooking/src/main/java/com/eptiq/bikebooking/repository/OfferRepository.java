package com.eptiq.bikebooking.repository;

import com.eptiq.bikebooking.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository  extends JpaRepository<Offer,Long> {
}
