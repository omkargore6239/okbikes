package com.eptiq.bikebooking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "deliveryprice")
public class DeliveryPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int price;
    private int perKilometer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPerKilometer() {
        return perKilometer;
    }

    public void setPerKilometer(int perKilometer) {
        this.perKilometer = perKilometer;
    }
}
