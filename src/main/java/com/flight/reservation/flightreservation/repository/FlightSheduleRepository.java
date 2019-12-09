package com.flight.reservation.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.flightreservation.model.FlightShedule;

public interface FlightSheduleRepository extends JpaRepository<FlightShedule, Long> {

}
