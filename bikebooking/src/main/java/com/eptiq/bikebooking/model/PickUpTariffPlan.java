package com.eptiq.bikebooking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pickupplan")
public class PickUpTariffPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String vehicleCategoryName;
    private int days;
    private int price;
    private int depositeAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDepositeAmount() {
        return depositeAmount;
    }

    public void setDepositeAmount(int depositeAmount) {
        this.depositeAmount = depositeAmount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getVehicleCategoryName() {
        return vehicleCategoryName;
    }

    public void setVehicleCategoryName(String vehicleCategoryName) {
        this.vehicleCategoryName = vehicleCategoryName;
    }
}
