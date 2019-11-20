package com.flight.reservation.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flight.reservation.flightreservation.model.Flight;
import com.flight.reservation.flightreservation.model.UserDetails;
 


@Repository
public interface UserRepository  extends JpaRepository<UserDetails, String>{
	
	//Optional<User> findByUserName(String username);

	//UserDetails findByUserName(String username);
	@Query("from UserDetails where email=:email")
	UserDetails findByEmail(@Param("email") String email);
	
	@Query("from Flight where departure_city=:departure_city AND arrival_city=:arrival_city")
	Flight findByDepartureCityAndArivalCity(@Param("departure_city") String departure_city, @Param("arrival_city") String arrival_city);
}
