package com.flight.reservation.flightreservation.dto;

import com.flight.reservation.flightreservation.model.Passenger;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class BookingDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long flightId;
    private String type;
    private String journyDate;
    private int noOfSheet;
    private String returnDate;
    private Long returnFlightId;
    private List<PassegerDto> passengers;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJournyDate() {
        return journyDate;
    }

    public void setJournyDate(String journyDate) {
        this.journyDate = journyDate;
    }

    public int getNoOfSheet() {
        return noOfSheet;
    }

    public void setNoOfSheet(int noOfSheet) {
        this.noOfSheet = noOfSheet;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Long getReturnFlightId() {
        return returnFlightId;
    }

    public void setReturnFlightId(Long returnFlightId) {
        this.returnFlightId = returnFlightId;
    }

    public List<PassegerDto> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassegerDto> passengers) {
        this.passengers = passengers;
    }
}
