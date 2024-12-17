package com.eptiq.bikebooking.model;

import jakarta.persistence.*;

@Entity
@Table(name="stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeName;
    private String address;
    private String storeContactNumber;
    private String storeGoogleMapUrl;
    private String storeImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStoreContactNumber() {
        return storeContactNumber;
    }

    public void setStoreContactNumber(String storeContactNumber) {
        this.storeContactNumber = storeContactNumber;
    }

    public String getStoreGoogleMapUrl() {
        return storeGoogleMapUrl;
    }

    public void setStoreGoogleMapUrl(String storeGoogleMapUrl) {
        this.storeGoogleMapUrl = storeGoogleMapUrl;
    }

    public String getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(String storeImage) {
        this.storeImage = storeImage;
    }
}
