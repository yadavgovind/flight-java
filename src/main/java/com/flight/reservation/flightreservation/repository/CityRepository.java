package com.flight.reservation.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.flightreservation.model.City;

public interface CityRepository extends JpaRepository<City, Long>{

	
}
