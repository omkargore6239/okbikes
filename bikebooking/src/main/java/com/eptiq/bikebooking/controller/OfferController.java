package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.Offer;
import com.eptiq.bikebooking.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/list")
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable Long id) {
        Optional<Offer> offer = offerService.getOfferById(id);
        return offer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Offer createOffer(@RequestBody Offer offer) {
        return offerService.saveOffer(offer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable Long id, @RequestBody Offer offerDetails) {
        Optional<Offer> existingOffer = offerService.getOfferById(id);

        if (existingOffer.isPresent()) {
            Offer offer = existingOffer.get();
            offer.setOfferName(offerDetails.getOfferName());
            offer.setCouponCode(offerDetails.getCouponCode());
            offer.setDiscountType(offerDetails.getDiscountType());
            offer.setDiscountValue(offerDetails.getDiscountValue());
            offer.setMinimumRideAmount(offerDetails.getMinimumRideAmount());
            offer.setOfferStartDateTime(offerDetails.getOfferStartDateTime());
            offer.setOfferEndDateTime(offerDetails.getOfferEndDateTime());
            offer.setTotalCoupon(offerDetails.getTotalCoupon());
            offer.setRemainingCoupon(offerDetails.getRemainingCoupon());
            offer.setCustomerEligibility(offerDetails.getCustomerEligibility());
            offer.setUsageLimitPerCustomer(offerDetails.getUsageLimitPerCustomer());
            offer.setTotalUsageLimit(offerDetails.getTotalUsageLimit());

            return ResponseEntity.ok(offerService.saveOffer(offer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);
        return ResponseEntity.noContent().build();
    }
}
