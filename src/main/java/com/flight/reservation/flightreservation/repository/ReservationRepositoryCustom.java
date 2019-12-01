package com.flight.reservation.flightreservation.repository;

import com.flight.reservation.flightreservation.filter.ReservationFilter;
import com.flight.reservation.flightreservation.model.Reservation;

import java.util.List;

public interface ReservationRepositoryCustom {

    int findAvailableSeat(ReservationFilter filter);
    List<Reservation> getReservationByLoginId(Long loginId);
}
