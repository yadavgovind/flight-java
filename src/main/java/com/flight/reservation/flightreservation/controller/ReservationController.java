package com.flight.reservation.flightreservation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.flight.reservation.flightreservation.service.JwtUserDetailsService;

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
        return this.reservationRepository.getReservationByLoginId(this.userDetailsService.getLoginUser()
            .getLoginId());
    }

    @GetMapping(
        value = "/reservation/{id}")
    private Map<String, String> cancelResvation(@PathVariable("id") final Long id) {
        final Map<String, String> map = new HashMap<>();
        try {
            this.reservationRepository.cancelReservation(id);
            map.put("status", "success");
        }
        catch (final Exception er) {
            er.printStackTrace();
            map.put("status", "fail");
        }
        return map;
    }

    @PostMapping(
        value = "/reservation")
    private synchronized Map<String, String> create(@RequestBody final BookingDto bookingDto) {
        final Map<String, String> map = new HashMap<>();
        final String statusValue = book(bookingDto, false);
        map.put("status", statusValue);
        if (bookingDto.getReturnFlightId() != null && !bookingDto.getReturnFlightId()
            .equals("0")) {
            book(bookingDto, true);
            map.put("status", statusValue);
        }
        return map;
    }

    private String book(final BookingDto bookingDto, final boolean isReturn) {

        final Optional<Flight> flight = this.flightRepository.findById(isReturn ? bookingDto.getReturnFlightId() : bookingDto.getFlightId());
        if (!flight.isPresent()) {
            return "filght is not present";
        }
        final ReservationFilter filter = new ReservationFilter();
        filter.setFlightId(isReturn ? bookingDto.getReturnFlightId() : bookingDto.getFlightId());
        filter.setJournyDate(isReturn ? bookingDto.getReturnDate() : bookingDto.getJournyDate());
        filter.setType(bookingDto.getType());
        final int noOfseat = this.reservationRepository.findAvailableSeat(filter);

        if (noOfseat < flight.get()
            .getSeatNo()) {
            System.out.println("no of seat exceed");
            return "sheat is not available in " + bookingDto.getType();
        }

        final Reservation reservation = new Reservation();
        final SimpleDateFormat dateFormat = new SimpleDateFormat(("yyyy-MM-dd"));
        try {
            reservation.setTravelDate(dateFormat.parse(isReturn ? bookingDto.getReturnDate() : bookingDto.getJournyDate()));
        }
        catch (final ParseException e) {
        }
        reservation.setCancel(false);
        reservation.setFlight(flight.get());
        final List<Passenger> passengers = bookingDto.getPassengers()
            .stream()
            .map(r -> {
                final Passenger p = new Passenger();
                p.setFirstName(r.getFirstName());
                p.setLastName(r.getLastName());
                p.setEmail(r.getEmail());
                p.setPhone(r.getPhone());
                return p;
            })
            .collect(Collectors.toList());
        reservation.setPassengers(passengers);
        reservation.setType(bookingDto.getType());
        reservation.setTotalSeat(bookingDto.getNoOfSheet());
        final String pnr = RandomStringUtils.random(6, true, true);
        reservation.setPnrNo(pnr.toUpperCase());
        reservation.setLoginId(this.userDetailsService.getLoginUser()
            .getLoginId());
        passengers.forEach(passenger -> passenger.setReservation(reservation));
        final Reservation saveValue = this.reservationRepository.save(reservation);
        if (saveValue.getId() != null) {
            final Passenger passenger = saveValue.getPassengers()
                .get(0);
            final MailDto mailDto = new MailDto();
            mailDto.setTitle("check status with Pnr No : " + pnr);
            mailDto.setToId(passenger.getEmail());
            sendEmail(mailDto);
        }
        return "ticket booked successfully";
    }

    private void sendEmail(final MailDto mailDto) {

        final SimpleMailMessage msg = new SimpleMailMessage();
        mailDto.setFromId("yadavgovind7892@gmail.com");

        msg.setFrom(mailDto.getFromId());
        msg.setTo(mailDto.getToId());
        msg.setSubject(mailDto.getSubject());
        msg.setText(mailDto.getTitle());

        this.javaMailSender.send(msg);
    }

}
