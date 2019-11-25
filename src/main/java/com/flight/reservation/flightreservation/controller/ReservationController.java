package com.flight.reservation.flightreservation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.reservation.flightreservation.dto.BookingDto;
import com.flight.reservation.flightreservation.model.Flight;
import com.flight.reservation.flightreservation.model.Passenger;
import com.flight.reservation.flightreservation.model.Reservation;
import com.flight.reservation.flightreservation.repository.FlightRepository;
import com.flight.reservation.flightreservation.repository.ReservationRepository;

@RestController
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping(
        value = "/reservations")
    public List<Reservation> findAll() {
        return this.reservationRepository.findAll();
    }

    @PostMapping(
        value = "/reservation")
    private synchronized void create(@RequestBody final List<BookingDto> bookingDtos) {
        final BookingDto bookingFlight = bookingDtos.iterator()
            .next();
        final Optional<Flight> flight = this.flightRepository.findById(Long.valueOf(bookingFlight.getFlightId()));
        if (!flight.isPresent()) {
            return;
        }
        if (bookingFlight.isEconomy() && flight.get()
            .getNumseats() < 0) {
            return;
        }
        else if (bookingFlight.isBussiness() && flight.get()
            .getBusiness_seat() > 0) {
            return;
        }
        final Reservation reservation = new Reservation();
        final List<Passenger> passengers = new ArrayList<>();
        bookingDtos.forEach(bookingDto -> {
            final Passenger passenger = new Passenger();
            passenger.setEmail(bookingDto.getEmail());
            passenger.setFirstName(bookingDto.getFirstName());
            passenger.setLastName(bookingDto.getLastName());
            passenger.setPhone(bookingDto.getPhone());
            // this.passengerRepository.save(passenger);
            passengers.add(passenger);

        });

        reservation.setCancel(false);
        reservation.setFlight(flight.get());
        reservation.setPassengers(passengers);
        passengers.forEach(passenger -> passenger.setReservation(reservation));
        this.reservationRepository.save(reservation);
    }

    @PostMapping(
        value = "/reservationAll")
    private void createAll(@RequestBody final List<Reservation> reservations) {
        this.reservationRepository.saveAll(reservations);
    }
}
