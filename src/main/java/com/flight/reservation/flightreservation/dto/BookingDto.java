package com.flight.reservation.flightreservation.dto;

import java.io.Serializable;

public class BookingDto implements Serializable {

    private boolean isAdult;

    private boolean isChild;
    private boolean isEconomy;
    private boolean isBussiness;
    private int flightId;
    private double price;

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private String adharCard;
    private String pancard;

    public boolean isAdult() {
        return this.isAdult;
    }

    public void setAdult(final boolean isAdult) {
        this.isAdult = isAdult;
    }

    public boolean isChild() {
        return this.isChild;
    }

    public void setChild(final boolean isChild) {
        this.isChild = isChild;
    }

    public boolean isEconomy() {
        return this.isEconomy;
    }

    public void setEconomy(final boolean isEconomy) {
        this.isEconomy = isEconomy;
    }

    public boolean isBussiness() {
        return this.isBussiness;
    }

    public void setBussiness(final boolean isBussiness) {
        this.isBussiness = isBussiness;
    }

    public int getFlightId() {
        return this.flightId;
    }

    public void setFlightId(final int flightNo) {
        this.flightId = flightNo;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getAdharCard() {
        return this.adharCard;
    }

    public void setAdharCard(final String adharCard) {
        this.adharCard = adharCard;
    }

    public String getPancard() {
        return this.pancard;
    }

    public void setPancard(final String pancard) {
        this.pancard = pancard;
    }

}
