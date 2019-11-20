//package com.ishwarya.app.services;
//
//import java.util.Optional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ishwarya.app.dto.ReservationRequest;
//import com.ishwarya.app.model.Flight;
//import com.ishwarya.app.model.Passenger;
//import com.ishwarya.app.model.Reservation;
//import com.ishwarya.app.repositories.FlightRepository;
//import com.ishwarya.app.repositories.PassengerRepository;
//import com.ishwarya.app.repositories.ReservationRepository;
//@Service
//public class ReservationServiceImpl implements ReservationService {
//	
//	@Autowired
//	FlightRepository flightRepository;
//	@Autowired
//	PassengerRepository passengerRepository;
//	@Autowired
//	ReservationRepository reservationRepository;
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
//	@Override
//	public Reservation bookFlight(ReservationRequest reservationRequest) {
//		// TODO Auto-generated method stub
//		
//		Optional<Flight> flightOptional = flightRepository.findById(reservationRequest.getFlightId());
//		
//		Flight flight=flightOptional.get();
//		Passenger passenger = new Passenger();
//		passenger.setFirstName(reservationRequest.getPassengerFirstName());
//		passenger.setLastName(reservationRequest.getPassengerLastName());
//		passenger.setMiddleName(reservationRequest.getPassengerMiddleName());
//		passenger.setEmail(reservationRequest.getPassengerEmail());
//		passenger.setPhone(reservationRequest.getPassengerPhone());
//		
//		passengerRepository.save(passenger);
//		
//		Reservation reservation = new Reservation();
//		reservation.setFlight(flight);
//		reservation.setPassenger(passenger);
//		reservation.setCheckedIn(false);
//		
//		 final Reservation savedReservation=reservationRepository.save(reservation);
//		 LOGGER.info("Saving the reservation:" + reservation);
//		return savedReservation;
//	}
//
//}
