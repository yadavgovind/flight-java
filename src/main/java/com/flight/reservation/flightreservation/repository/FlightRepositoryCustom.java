 
package com.flight.reservation.flightreservation.repository;

import java.util.List;

import com.flight.reservation.flightreservation.filter.FlightFilter;
import com.flight.reservation.flightreservation.model.Flight;

public interface FlightRepositoryCustom{

	List<Flight> findAll(FlightFilter filter,boolean isReturn);
	
}
