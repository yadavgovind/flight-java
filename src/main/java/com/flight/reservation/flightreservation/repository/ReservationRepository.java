package com.flight.reservation.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.flightreservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
