package com.flight.reservation.flightreservation.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation extends AbstractEntity {

    @OneToMany(
        mappedBy = "reservation",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY)
    // @JoinColumn()
    @JsonIgnore
    private List<Passenger> passengers;
    @OneToOne
    private Flight flight;

    private boolean isCheckedIn;
    private int numBags;

    private int totalSeat;
    private boolean isCancel;
    private Long loginId;
    private String type;
    private String pnrNo;
    private Date travelDate;
    public Flight getFlight() {
        return this.flight;
    }

    public void setFlight(final Flight flight) {
        this.flight = flight;
    }

    public boolean isCheckedIn() {
        return this.isCheckedIn;
    }

    public void setCheckedIn(final boolean isCheckedIn) {
        this.isCheckedIn = isCheckedIn;
    }

    public int getNumBags() {
        return this.numBags;
    }

    public void setNumBags(final int numBags) {
        this.numBags = numBags;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public boolean isCancel() {
        return this.isCancel;
    }

    public void setCancel(final boolean isCancel) {
        this.isCancel = isCancel;
    }

    public Long getLoginId() {
        return this.loginId;
    }

    public void setLoginId(final Long loginId) {
        this.loginId = loginId;
    }

    public List<Passenger> getPassengers() {
        return this.passengers;
    }

    public void setPassengers(final List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(String pnrNo) {
        this.pnrNo = pnrNo;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }
}
