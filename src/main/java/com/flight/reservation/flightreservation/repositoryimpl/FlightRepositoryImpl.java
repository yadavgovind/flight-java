package com.flight.reservation.flightreservation.repositoryimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.platform.commons.util.StringUtils;

import com.flight.reservation.flightreservation.filter.FlightFilter;
import com.flight.reservation.flightreservation.model.Flight;
import com.flight.reservation.flightreservation.repository.FlightRepositoryCustom;

public class FlightRepositoryImpl implements FlightRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	String str = "2016-03-04";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Override
	public List<Flight> findAll(FlightFilter filter) {

		List<Flight> flights = new ArrayList<>();
		if (StringUtils.isNotBlank(filter.getTravellDate())) {
			String str1 = filter.getTravellDate() + " 12:00:00";

			LocalDateTime startDate = LocalDateTime.parse(str1, formatter);
		
			
			flights = entityManager.createQuery(
					"  from Flight flight0_   left join flight0_.arrivalcity as arrivCity "
					+ "left join flight0_.departurecity as depCity "
					+ "where :startDate BETWEEN flight0_.start_date AND flight0_.end_date "
					+ " and depCity.id=:departureCity and arrivCity.id=:arrivalCity")
					
					.setParameter("startDate", startDate).setParameter("departureCity", filter.getDeparturecity())
					.setParameter("arrivalCity", filter.getArrivalCity()).getResultList();

			
			//	        Predicate greaterDate = builder.greaterThanOrEqualTo(root.get("start_date"), startDate);
//	        Predicate lessDate = builder.lessThanOrEqualTo(root.get("end_date"), startDate);
//	        criteriaList.add(greaterDate);
//	        criteriaList.add(lessDate);
		}

//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Flight> criteria = builder.createQuery(Flight.class);
//		Root<Flight> root = criteria.from(Flight.class);
//		List<Predicate> criteriaList = new ArrayList<>();

//		if(StringUtils.isNotBlank(filter.getReturnDate())) {
//			String str2= filter.getReturnDate()+" 00:00:00";
//			  LocalDateTime endDate = LocalDateTime.parse(str2, formatter);;
//		        Predicate departureDateC = builder.equal(root.get("returnDate"), endDate);
//		        criteriaList.add(departureDateC);
//		}
//		Predicate departureCityC = builder.equal(root.get("departurecity"), filter.getDeparturecity());
//		criteriaList.add(departureCityC);
//		Predicate arrivalCityC = builder.equal(root.get("arrivalcity"), filter.getArrivalCity());
//		criteriaList.add(arrivalCityC);
//		criteria.where(builder.and(criteriaList.toArray(new Predicate[0])));
//		criteria.select(root);
//		List<Flight> flights = entityManager.createQuery(criteria).getResultList();
		return flights;
	}

	public static void main(String[] args) {
		String str = "2016-03-04 00:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime startDate = LocalDateTime.parse("2016-03-04" + " " + "00:00:00", formatter);
		System.out.println(startDate);
	}
}
