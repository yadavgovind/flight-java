package com.flight.reservation.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flight.reservation.flightreservation.model.Passenger;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
     @Query(" select p from Passenger p where p.reservation.id=?1")
    List<Passenger> getPassengerByReservation(Long id);
    @Query(" select p from Passenger p where p.reservation.flight.id=?1 and p.reservation.type=?2 and p.reservation.isCancel=false")
    List<Passenger> getPassengerByFlight(Long id,String type);
    @Query(" select p from Passenger p where p.reservation.flight.id=?1 and p.seatNo=?2 and p.reservation.type=?3 and p.reservation.isCancel=false")
    Passenger getPassengerBySeatNo(Long flightId,Integer seatNo,String type);
}
