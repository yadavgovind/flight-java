package com.flight.reservation.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.flightreservation.model.FlightShedule;

public interface FlightSheduleRepository extends JpaRepository<FlightShedule, Long> {
	
//	@Query(nativeQuery=true ,value=" SELECT * from flight_shedule as fs WHERE fs.flight_id in ?1  and fs.travel_date= ?2 ")
//    List<FlightShedule> getCancelByFlightIdandTravellDate( List<Long> flightIds,  String travellDate);
}
