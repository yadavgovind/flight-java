package com.flight.reservation.flightreservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.flight.reservation.flightreservation.dto.FlightRegistrationDAOImpl;
import com.flight.reservation.flightreservation.dto.FlightReservationDAO;
import com.flight.reservation.flightreservation.model.Flight;
import com.flight.reservation.flightreservation.model.UserDetails;
import com.flight.reservation.flightreservation.repository.UserRepository;

public class UserRegistrationImpl implements UserRepository {

	@Override
	public List<UserDetails> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDetails> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDetails> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserDetails> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends UserDetails> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<UserDetails> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDetails getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserDetails> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserDetails> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UserDetails> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserDetails> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserDetails> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserDetails entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends UserDetails> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends UserDetails> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserDetails> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserDetails> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends UserDetails> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

//	private FlightReservationDAO dao=null;
	
	public UserDetails findByUserName(String username) {
		FlightRegistrationDAOImpl dao=new  FlightRegistrationDAOImpl();
		UserDetails userDetails=new UserDetails();
		userDetails=dao.findUser(username);
		
		return userDetails;
	}

	
	public UserDetails findByEmail(String email) {
		System.out.println("findbyEmail function:"+email);
		
		FlightRegistrationDAOImpl dao=new  FlightRegistrationDAOImpl();
		UserDetails userDetails=new UserDetails();
		userDetails=dao.findUser(email);
		
		return userDetails;
	}
	
	public void saveDetails(UserDetails details) {
		System.out.println("savedetails user registration controller:"+details);
		FlightRegistrationDAOImpl dao=new  FlightRegistrationDAOImpl();
		dao.saveDetails(details);
	}

	@Override
	public Flight findByDepartureCityAndArivalCity(String departure_city, String arrival_city) {
		// TODO Auto-generated method stub
		return null;
	}

}
