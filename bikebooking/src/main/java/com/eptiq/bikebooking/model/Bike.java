package com.eptiq.bikebooking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Bikes")

public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String brandName;
    private String category;
    private String modelName;
    private String vehicleRegistrationNumber;
    private String addedBy;
    private String registrationYear;
    private String vehicleChassisNumber;
    private String vehicleEngineNumber;
    private String storeName;
    private String puc;
    private String insurance;
    private String document;
    private String vehicleImage;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public String getVehicleEngineNumber() {
        return vehicleEngineNumber;
    }

    public void setVehicleEngineNumber(String vehicleEngineNumber) {
        this.vehicleEngineNumber = vehicleEngineNumber;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(String vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPuc() {
        return puc;
    }

    public void setPuc(String puc) {
        this.puc = puc;
    }

    public String getVehicleChassisNumber() {
        return vehicleChassisNumber;
    }

    public void setVehicleChassisNumber(String vehicleChassisNumber) {
        this.vehicleChassisNumber = vehicleChassisNumber;
    }

    public String getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(String registrationYear) {
        this.registrationYear = registrationYear;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
