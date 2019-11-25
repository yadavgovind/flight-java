package com.flight.reservation.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.reservation.flightreservation.dto.BookingDto;
import com.flight.reservation.flightreservation.dto.MailDto;
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

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping(
        value = "/reservations")
    public List<Reservation> findAll() {
        return this.reservationRepository.findAll();
    }

    @PostMapping(
        value = "/reservation")
    private synchronized void create(@RequestBody BookingDto bookingDto) {
        final Reservation reservation = new Reservation();
        final Passenger passenger = new Passenger();
        this.flightRepository.findById(Long.valueOf(bookingDto.getFlightNo()))
            .ifPresent(flight -> {
                passenger.setAdharCard(bookingDto.getAdharCard());
                passenger.setEmail(bookingDto.getEmail());
                passenger.setFirstName(bookingDto.getFirstName());
                passenger.setLastName(bookingDto.getLastName());
                passenger.setPancard(bookingDto.getPancard());
                passenger.setPhone(bookingDto.getPhone());

                reservation.setCancel(false);
                reservation.setFlight(flight);
                if (bookingDto.isEconomy() && flight.getNumseats() > 0) {

                }
                else if (bookingDto.isBussiness() && flight.getBusiness_seat() > 0) {

                }
                reservation.setPassenger(passenger);
            });

        final Reservation saveValue = this.reservationRepository.save(reservation);
        if (saveValue.getId() != null) {
            sendEmail();
        }
    }

    @PostMapping(
        value = "/reservationAll")
    private void createAll(@RequestBody List<Reservation> reservations) {
        this.reservationRepository.saveAll(reservations);
    }

    private void sendEmail() {
        final MailDto mailDto = new MailDto();
        final SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom(mailDto.getFromId());
        msg.setTo(mailDto.getToId());
        msg.setSubject(mailDto.getSubject());
        msg.setText(mailDto.getTitle());

        this.javaMailSender.send(msg);
    }
}
