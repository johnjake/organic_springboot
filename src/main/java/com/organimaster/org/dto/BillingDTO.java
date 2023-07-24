package com.organimaster.org.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillingDTO {
    private String firstName;
    private String lastName;
    private String country;
    private String address;
    private String town;
    private String state;
    @JsonProperty("zip")
    private int zipCode;
    private String phone;
    private String email;
    @JsonProperty("shipping")
    private int shipToAddress;
    @JsonProperty("userid")
    private int userId;

    public BillingDTO(String firstName, String lastName, String country, String address, String town, String state, int zipCode, String phone, String email, int shipToAddress, int userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.address = address;
        this.town = town;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.email = email;
        this.shipToAddress = shipToAddress;
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(int shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
