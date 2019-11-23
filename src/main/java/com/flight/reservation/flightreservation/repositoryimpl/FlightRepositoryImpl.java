package com.flight.reservation.flightreservation.repositoryimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.flight.reservation.flightreservation.filter.FlightFilter;
import com.flight.reservation.flightreservation.model.Flight;
import com.flight.reservation.flightreservation.repository.FlightRepositoryCustom;
 

public class FlightRepositoryImpl implements FlightRepositoryCustom{

	
	
	@PersistenceContext
	EntityManager entityManager;
	
	 

	 
	@Override
	public List<Flight> findAll(FlightFilter filter) {
		CriteriaBuilder builder= entityManager.getCriteriaBuilder();
		CriteriaQuery<Flight> criteria =  builder.createQuery(Flight.class);
		Root<Flight> root = criteria.from(Flight.class);
//		 List<Predicate> criteriaList = new ArrayList<>();
//
//	        Predicate firstCondition = builder.equal(root.get("start_date"), filter.getStart_date() );
//	        criteriaList.add(firstCondition);
//
//	        Predicate secondCondition = builder.equal(root.get("end_date"), filter.getEnd_date());
//	        criteriaList.add(secondCondition);

//	        Predicate thirdCondition = builder.equal(sts.get("senseIndex"), filter.);
//	        criteriaList.add(thirdCondition);
	        criteria.select( root );
//	        criteria.where(builder.and(criteriaList.toArray(new Predicate[0])));
	      
		List<Flight> flights = entityManager.createQuery( criteria ).getResultList();
		return flights;
	}
}
