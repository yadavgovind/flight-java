package com.flight.reservation.flightreservation.repository;

import com.flight.reservation.flightreservation.dto.PassegerDto;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flight.reservation.flightreservation.model.Passenger;
import com.flight.reservation.flightreservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>, ReservationRepositoryCustom {

    Reservation getReservationByPnrNo(String pnrNo);

    

    
    
    @Query("select r from Reservation r where r.flight.id=?1  and date(r.travelDate)=date(?2)")
    List<Reservation> getReservationByFlightIdAndTravelDate(Long id,String travelDate);
    
 //   @Query("select r from Reservation r where r.flight.id")
 //   List<Reservation> getAllReservationsByDates(String date1,String date2);
}
