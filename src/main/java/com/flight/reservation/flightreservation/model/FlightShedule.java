package com.flight.reservation.flightreservation.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
    name = "flight_shedule")
public class FlightShedule extends AbstractEntity {

    private Long flightId;
    private String travelDate;

    public Long getFlightId() {
        return this.flightId;
    }

    public void setFlightId(final Long flightId) {
        this.flightId = flightId;
    }

    public String getTravelDate() {
        return this.travelDate;
    }

    public void setTravelDate(final String travelDate) {
        this.travelDate = travelDate;
    }

}
