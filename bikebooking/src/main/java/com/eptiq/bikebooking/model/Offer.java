package com.eptiq.bikebooking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String offerName;
    private String couponCode;
    private String discountType;
    private Double discountValue;
    private Double minimumRideAmount;

    private LocalDateTime offerStartDateTime;
    private LocalDateTime offerEndDateTime;

    private int totalCoupon;
    private int remainingCoupon;



    private String customerEligibility;
    private Boolean usageLimitPerCustomer;
    private Integer totalUsageLimit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    public LocalDateTime getOfferStartDateTime() {
        return offerStartDateTime;
    }

    public void setOfferStartDateTime(LocalDateTime offerStartDateTime) {
        this.offerStartDateTime = offerStartDateTime;
    }

    public Double getMinimumRideAmount() {
        return minimumRideAmount;
    }

    public void setMinimumRideAmount(Double minimumRideAmount) {
        this.minimumRideAmount = minimumRideAmount;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public LocalDateTime getOfferEndDateTime() {
        return offerEndDateTime;
    }

    public void setOfferEndDateTime(LocalDateTime offerEndDateTime) {
        this.offerEndDateTime = offerEndDateTime;
    }
    public int getTotalCoupon() {
        return totalCoupon;
    }

    public void setTotalCoupon(int totalCoupon) {
        this.totalCoupon = totalCoupon;
    }

    public int getRemainingCoupon() {
        return remainingCoupon;
    }

    public void setRemainingCoupon(int remainingCoupon) {
        this.remainingCoupon = remainingCoupon;
    }

    public String getCustomerEligibility() {
        return customerEligibility;
    }

    public void setCustomerEligibility(String customerEligibility) {
        this.customerEligibility = customerEligibility;
    }

    public Boolean getUsageLimitPerCustomer() {
        return usageLimitPerCustomer;
    }

    public void setUsageLimitPerCustomer(Boolean usageLimitPerCustomer) {
        this.usageLimitPerCustomer = usageLimitPerCustomer;
    }

    public Integer getTotalUsageLimit() {
        return totalUsageLimit;
    }

    public void setTotalUsageLimit(Integer totalUsageLimit) {
        this.totalUsageLimit = totalUsageLimit;
    }
}
