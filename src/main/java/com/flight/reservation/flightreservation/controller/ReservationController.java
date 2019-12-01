package com.flight.reservation.flightreservation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.flight.reservation.flightreservation.service.JwtUserDetailsService;
import org.apache.commons.lang3.RandomStringUtils;
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
import com.flight.reservation.flightreservation.filter.ReservationFilter;
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

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @GetMapping(
        value = "/reservations")
    public List<Reservation> findAll() {
        return this.reservationRepository.getReservationByLoginId(this.userDetailsService.getLoginUser().getLoginId());
    }

    @PostMapping(
        value = "/reservation")
    private synchronized void create(@RequestBody final List<BookingDto> bookingDtos) {
        final BookingDto bookingFlight = bookingDtos.iterator()
            .next();
        final Optional<Flight> flight = this.flightRepository.findById(bookingFlight.getFlightId());
        if (!flight.isPresent()) {
            return;
        }

        final ReservationFilter filter = new ReservationFilter();
        filter.setFlightId(bookingFlight.getFlightId());
        filter.setJournyDate(bookingFlight.getJournyDate());
        filter.setType(bookingFlight.getType());
        final int noOfseat = this.reservationRepository.findAvailableSeat(filter);
        if (bookingFlight.getType()
            .equals("Economy")) {
            if (noOfseat >= flight.get()
                .getSeatNo()) {
                return;
            }
        }
        else {
            if (noOfseat >= flight.get()
                .getBusiness_seat()) {
                return;
            }
        }

        final Reservation reservation = new Reservation();
        final List<Passenger> passengers = new ArrayList<>();
        bookingDtos.forEach(bookingDto -> {
            final Passenger passenger = new Passenger();
            passenger.setEmail(bookingDto.getEmail());
            passenger.setFirstName(bookingDto.getFirstName());
            passenger.setLastName(bookingDto.getLastName());
            passenger.setPhone(bookingDto.getPhone());
            passengers.add(passenger);

        });
        SimpleDateFormat dateFormat=new SimpleDateFormat(("yyyy-MM-dd"));
        try {
            reservation.setTravelDate(dateFormat.parse(bookingFlight.getJournyDate()));
        } catch (ParseException e) {
        }
        reservation.setCancel(false);
        reservation.setFlight(flight.get());
        reservation.setPassengers(passengers);
        reservation.setType(bookingFlight.getType());
        reservation.setTotalSeat(bookingFlight.getNoOfSheet());

        String pnr = RandomStringUtils.random(6, true, true);
        reservation.setPnrNo(pnr.toUpperCase());
        reservation.setLoginId(this.userDetailsService.getLoginUser().getLoginId());
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
