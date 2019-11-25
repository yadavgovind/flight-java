package com.flight.reservation.flightreservation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.reservation.flightreservation.dto.BookingDto;
import com.flight.reservation.flightreservation.dto.MailDto;
import com.flight.reservation.flightreservation.model.Flight;
import com.flight.reservation.flightreservation.model.Passenger;
import com.flight.reservation.flightreservation.model.Reservation;
import com.flight.reservation.flightreservation.repository.FlightRepository;
import com.flight.reservation.flightreservation.repository.ReservationRepository;

@CrossOrigin(
    origins = "http://localhost:4200",
    maxAge = 3600)
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
    private synchronized void create(@RequestBody final List<BookingDto> bookingDtos) {
        final BookingDto bookingFlight = bookingDtos.iterator()
            .next();
        final Optional<Flight> flight = this.flightRepository.findById(Long.valueOf(bookingFlight.getFlightId()));
      
        if (!flight.isPresent()) {
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

        final Reservation saveValue = this.reservationRepository.save(reservation);
        if (saveValue.getId() != null) {
            final Passenger passenger = saveValue.getPassengers()
                .get(0);
            final MailDto mailDto = new MailDto();
            mailDto.setToId(passenger.getEmail());
            sendEmail(mailDto);
        }
    }

    @PostMapping(
        value = "/reservationAll")
    private void createAll(@RequestBody final List<Reservation> reservations) {
        this.reservationRepository.saveAll(reservations);
    }

    private void sendEmail(final MailDto mailDto) {

        final SimpleMailMessage msg = new SimpleMailMessage();
        mailDto.setFromId("yadavgovind7892@gmail.com");
        mailDto.setTitle("save booking");
        msg.setFrom(mailDto.getFromId());
        msg.setTo(mailDto.getToId());
        msg.setSubject(mailDto.getSubject());
        msg.setText(mailDto.getTitle());

        this.javaMailSender.send(msg);
    }
}
