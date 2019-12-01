package com.flight.reservation.flightreservation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.flight.reservation.flightreservation.dto.PassegerDto;
import com.flight.reservation.flightreservation.service.JwtUserDetailsService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import com.flight.reservation.flightreservation.dto.BookingDto;
import com.flight.reservation.flightreservation.dto.MailDto;
import com.flight.reservation.flightreservation.filter.ReservationFilter;
import com.flight.reservation.flightreservation.model.Flight;
import com.flight.reservation.flightreservation.model.Passenger;
import com.flight.reservation.flightreservation.model.Reservation;
import com.flight.reservation.flightreservation.repository.FlightRepository;
import com.flight.reservation.flightreservation.repository.ReservationRepository;

import javax.websocket.server.PathParam;

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
    @GetMapping(
            value = "/reservation/{id}")
    private Map<String,String> cancelResvation(@PathVariable("id") Long id) {
        Map<String,String> map=new HashMap<>();
        try {
            this.reservationRepository.cancelReservation(id);
            map.put("status","success");
        }
        catch (Exception er){
            er.printStackTrace();
            map.put("status","fail");
        }
        return map;
    }
    @PostMapping(
        value = "/reservation")
    private synchronized void create(@RequestBody final BookingDto bookingDto) {

        book(bookingDto,false);
        if(bookingDto.getReturnFlightId()!=null&&!bookingDto.getReturnFlightId().equals("0"))
        book(bookingDto,true);
    }
  private void book(BookingDto bookingDto,boolean isReturn){

      final Optional<Flight> flight = this.flightRepository.findById(isReturn?bookingDto.getReturnFlightId():bookingDto.getFlightId());
      if (!flight.isPresent()) {
          return;
      }
      final ReservationFilter filter = new ReservationFilter();
      filter.setFlightId(isReturn?bookingDto.getReturnFlightId():bookingDto.getFlightId());
      filter.setJournyDate(isReturn?bookingDto.getReturnDate():bookingDto.getJournyDate());
      filter.setType(bookingDto.getType());
      final int noOfseat = this.reservationRepository.findAvailableSeat(filter);
      if (bookingDto.getType()
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
      SimpleDateFormat dateFormat=new SimpleDateFormat(("yyyy-MM-dd"));
      try {
          reservation.setTravelDate(dateFormat.parse(isReturn?bookingDto.getReturnDate():bookingDto.getJournyDate()));
      } catch (ParseException e) {
      }
      reservation.setCancel(false);
      reservation.setFlight(flight.get());
      List<Passenger> passengers= bookingDto.getPassengers().stream().map(r->{
          Passenger p=new Passenger();
          p.setFirstName(r.getFirstName());
          p.setLastName(r.getLastName());
          p.setEmail(r.getEmail());
          p.setPhone(r.getPhone());
          return p;
      }).collect(Collectors.toList());
      reservation.setPassengers(passengers);
      reservation.setType(bookingDto.getType());
      reservation.setTotalSeat(bookingDto.getNoOfSheet());
      String pnr = RandomStringUtils.random(6, true, true);
      reservation.setPnrNo(pnr.toUpperCase());
      reservation.setLoginId(this.userDetailsService.getLoginUser().getLoginId());
      passengers.forEach(passenger -> passenger.setReservation(reservation));
      final Reservation saveValue = this.reservationRepository.save(reservation);
      if (saveValue.getId() != null) {
          final Passenger passenger = saveValue.getPassengers()
                  .get(0);
          final MailDto mailDto = new MailDto();
          mailDto.setTitle(pnr);
          mailDto.setToId(passenger.getEmail());
          //sendEmail(mailDto);
      }
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
