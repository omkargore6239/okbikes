package com.eptiq.bikebooking.model;

import jakarta.persistence.*;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String emailAddress;
    private String contactNumber;
    private String assignedStore;
    private String password;

    @Lob
    private byte[] identityProof;

    @Lob
    private byte[] aadharOrPanOrDrivingLicense;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getAadharOrPanOrDrivingLicense() {
        return aadharOrPanOrDrivingLicense;
    }

    public void setAadharOrPanOrDrivingLicense(byte[] aadharOrPanOrDrivingLicense) {
        this.aadharOrPanOrDrivingLicense = aadharOrPanOrDrivingLicense;
    }

    public byte[] getIdentityProof() {
        return identityProof;
    }

    public void setIdentityProof(byte[] identityProof) {
        this.identityProof = identityProof;
    }

    public String getAssignedStore() {
        return assignedStore;
    }

    public void setAssignedStore(String assignedStore) {
        this.assignedStore = assignedStore;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
