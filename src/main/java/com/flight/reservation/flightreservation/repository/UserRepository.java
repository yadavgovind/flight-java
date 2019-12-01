package com.flight.reservation.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.reservation.flightreservation.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

    UserDetails findByEmail(String email);

    UserDetails findByUserName(String username);
    // Optional<User> findByUserName(String username);

    // UserDetails findByUserName(String username);

    // @Query("from UserDetails where email=:email")
    // //@Query(value="SELECT * FROM USERDETAILS U where U.email=?",nativeQuery=true )
    // UserDetails findByEmail(@Param("email") String email);
    //
    //
    //
    // @Query("from Flight where departure_city=:departure_city AND arrival_city=:arrival_city")
    // Flight findByDepartureCityAndArivalCity(@Param("departure_city") String departure_city, @Param("arrival_city") String arrival_city);

}
