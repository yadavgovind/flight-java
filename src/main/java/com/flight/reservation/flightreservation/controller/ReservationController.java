package com.flight.reservation.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.reservation.flightreservation.model.Passenger;
import com.flight.reservation.flightreservation.model.Reservation;
import com.flight.reservation.flightreservation.repository.ReservationRepository;

@RestController
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@GetMapping(value="/reservations")
	public List<Reservation> findAll(){
		return reservationRepository.findAll();
	}
	
	@PostMapping(value="/reservation")
	private  void create(@RequestBody Reservation reservation) {
		reservationRepository.save(reservation);
	}
	
	@PostMapping(value="/reservationAll")
	private  void createAll(@RequestBody List<Reservation> reservations) {
		reservationRepository.saveAll(reservations);
	}
}
