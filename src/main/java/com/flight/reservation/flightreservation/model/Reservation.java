package com.flight.reservation.flightreservation.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity {

    @OneToMany(
        mappedBy = "reservation",
        cascade = CascadeType.ALL)
    // @JoinColumn()
    private List<Passenger> passengers;
    @OneToOne
    private Flight flight;

    private boolean isCheckedIn;
    private int numBags;

    private int seatNo;
    private boolean isCancel;
    private int loginId;

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

    public int getSeatNo() {
        return this.seatNo;
    }

    public void setSeatNo(final int seatNo) {
        this.seatNo = seatNo;
    }

    public boolean isCancel() {
        return this.isCancel;
    }

    public void setCancel(final boolean isCancel) {
        this.isCancel = isCancel;
    }

    public int getLoginId() {
        return this.loginId;
    }

    public void setLoginId(final int loginId) {
        this.loginId = loginId;
    }

    public List<Passenger> getPassengers() {
        return this.passengers;
    }

    public void setPassengers(final List<Passenger> passengers) {
        this.passengers = passengers;
    }

}
