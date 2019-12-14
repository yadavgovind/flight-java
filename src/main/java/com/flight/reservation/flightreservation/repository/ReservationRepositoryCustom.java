package com.flight.reservation.flightreservation.repository;

import com.flight.reservation.flightreservation.dto.PassegerDto;
import com.flight.reservation.flightreservation.filter.ReservationFilter;
import com.flight.reservation.flightreservation.model.Reservation;

import java.util.List;

public interface ReservationRepositoryCustom {

    int findAvailableSeat(ReservationFilter filter);
    List<Reservation> getReservationByLoginId(Long loginId);
    void cancelReservation(Long resId);
    void changeSeat(PassegerDto dto);
     
    List<Reservation> getReservationsByDates(String date1,String date2);
}
