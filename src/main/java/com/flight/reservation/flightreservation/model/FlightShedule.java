package com.flight.reservation.flightreservation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name = "flight_shedule")
public class FlightShedule extends AbstractEntity {
    @Id
    private Long id;

    private Long flightId;
    private String travelDate;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

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
