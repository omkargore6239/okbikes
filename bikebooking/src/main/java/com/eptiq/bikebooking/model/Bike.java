package com.eptiq.bikebooking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
    @Lob
    private String puc;
    @Lob
    private String insurance;
    @Lob
    private String document;
    @Lob
    private String vehicleImage;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}

