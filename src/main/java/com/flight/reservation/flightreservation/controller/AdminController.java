package com.flight.reservation.flightreservation.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.reservation.flightreservation.dto.MailDto;
import com.flight.reservation.flightreservation.filter.CancelFilter;
import com.flight.reservation.flightreservation.filter.FlightFilter;
import com.flight.reservation.flightreservation.model.FlightShedule;
import com.flight.reservation.flightreservation.model.Passenger;
import com.flight.reservation.flightreservation.model.Reservation;
import com.flight.reservation.flightreservation.repository.FlightSheduleRepository;
import com.flight.reservation.flightreservation.repository.PassengerRepository;
import com.flight.reservation.flightreservation.repository.ReservationRepository;
import com.flight.reservation.flightreservation.service.EmailService;
import com.sendgrid.Email;

@RestController
public class AdminController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private FlightSheduleRepository flightSheduleRepository;

    @Autowired
    private JavaMailSender javaMailSender;
    
    @Autowired
    private EmailService mailService;

    @GetMapping("/passengers/{pnr}")
    public Map<String, Object> getPassengerByPnr(@PathVariable final String pnr) {
        final Reservation reservation = this.reservationRepository.getReservationByPnrNo(pnr);
        final Map<String, Object> res = new HashMap<>();
        res.put("pessengers", this.passengerRepository.getPassengerByReservation(reservation.getId()));
        final List<Integer> bookedSeat = this.passengerRepository.getPassengerByFlight(reservation.getFlight()
            .getId(), reservation.getType())
            .stream()
            .map(p -> p.getSeatNo())
            .collect(Collectors.toList());
        res.put("seats", bookedSeat);
        return res;

    }

    @SuppressWarnings("deprecation")
	@PostMapping("/cancelFlight")
    public void cancelFlight(@RequestBody final FlightShedule flightShedule) throws ParseException {
    
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	Date td=sdf.parse(flightShedule.getTravelDate());
       final List<Passenger> passengers = this.passengerRepository.getPassengerByFlightIdAndTravelDate(flightShedule.getFlightId(),flightShedule.getTravelDate());
       
       
        //cancel the reservations
        List<Reservation> reservationList = this.reservationRepository
        							.getReservationByFlightIdAndTravelDate(flightShedule.getFlightId(),
        																	flightShedule.getTravelDate());
        
        System.out.println("reservation size "+reservationList.size());
        this.flightSheduleRepository.save(flightShedule);
        reservationList.forEach(reservation ->
        						{
        							 this.reservationRepository.cancelReservation(reservation.getId());
        						});
        
        passengers.forEach(passenger -> {

        	
        	final MailDto mailDto = new MailDto();
            mailDto.setSubject("Reservation Cancelled");
            mailDto.setTitle(passenger.getReservation().getPnrNo() + " pnr no reservation cancelled");
            mailDto.setToId(passenger.getEmail());
            sendEmail(mailDto);
        });
      
    }//end cancelFlight
    
    private void sendEmail(final MailDto mailDto) {

        this.mailService.send(new Email(mailDto.getToId()), mailDto.getTitle(), mailDto.getSubject());
    }
    
    
    @GetMapping("/bookingCancellations")
    public List<Reservation> getReservationsCancelled(@RequestBody final CancelFilter cancelFilter) {
    	//List<Reservation> reservation = this.reservationRepository.findAll();
         List<Reservation> reservation = this.reservationRepository.getReservationsByDates(cancelFilter.getDate1(), cancelFilter.getDate1());
        System.out.println("Inside reservation");
        return reservation;

    }
}
