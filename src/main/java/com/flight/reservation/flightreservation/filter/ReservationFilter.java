package com.flight.reservation.flightreservation.filter;

public class ReservationFilter {
    private Long flightId;
    private String journyDate;
    private String type;

    public Long getFlightId() {
        return this.flightId;
    }

    public void setFlightId(final Long flightId) {
        this.flightId = flightId;
    }

    public String getJournyDate() {
        return this.journyDate;
    }

    public void setJournyDate(final String journyDate) {
        this.journyDate = journyDate;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

}
