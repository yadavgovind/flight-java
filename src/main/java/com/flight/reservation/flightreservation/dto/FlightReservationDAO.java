package com.flight.reservation.flightreservation.dto;

import com.flight.reservation.flightreservation.model.UserDetails;

public interface FlightReservationDAO {
	public UserDetails findUser(String username);
	public void saveDetails(UserDetails userDetails);

}
