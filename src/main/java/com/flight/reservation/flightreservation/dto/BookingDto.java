package com.flight.reservation.flightreservation.dto;

import java.io.Serializable;

public class BookingDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long flightId;
    private double price;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private String passengerType;
    private String type;
    private String journyDate;
    private int noOfSheet;

    public Long getFlightId() {
        return this.flightId;
    }

    public void setFlightId(final Long flightNo) {
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

    public String getPassengerType() {
        return this.passengerType;
    }

    public void setPassengerType(final String passengerType) {
        this.passengerType = passengerType;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getJournyDate() {
        return this.journyDate;
    }

    public void setJournyDate(final String journyDate) {
        this.journyDate = journyDate;
    }

    public int getNoOfSheet() {
        return this.noOfSheet;
    }

    public void setNoOfSheet(final int noOfSheet) {
        this.noOfSheet = noOfSheet;
    }

}
