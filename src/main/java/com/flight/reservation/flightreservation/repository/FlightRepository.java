package com.flight.reservation.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.flightreservation.model.Flight;

public interface FlightRepository extends JpaRepository<Flight,Long>,  FlightRepositoryCustom{
	
	
}
