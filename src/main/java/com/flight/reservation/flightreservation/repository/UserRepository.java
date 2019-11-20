package com.flight.reservation.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.reservation.flightreservation.model.UserDetails;



@Repository
public interface UserRepository  extends JpaRepository<UserDetails, String>{
	
	//Optional<User> findByUserName(String username);
	
	UserDetails findByUserName(String username);
}
