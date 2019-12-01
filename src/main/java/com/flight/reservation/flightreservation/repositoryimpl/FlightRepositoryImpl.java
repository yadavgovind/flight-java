package com.flight.reservation.flightreservation.repositoryimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public List<Flight> findAll(final FlightFilter filter,boolean isReturn) {

        List<Flight> flights = new ArrayList<>();
        if (StringUtils.isNotBlank(filter.getTravellDate())&&!isReturn) {
            final String str1 = filter.getTravellDate() + " 12:00:00";
            final LocalDateTime startDate = LocalDateTime.parse(str1, this.formatter);

            flights = this.entityManager.createQuery("  from Flight flight0_   left join flight0_.arrivalcity as arrivCity "
                    + "left join flight0_.departurecity as depCity " + " where :startDate BETWEEN flight0_.start_date AND flight0_.end_date "
                    + " and flight0_.departurecity.id=:departureCity and flight0_.arrivalcity.id=:arrivalCity")
                .setParameter("startDate", startDate)
                .setParameter("departureCity", filter.getDeparturecity())
                .setParameter("arrivalCity", filter.getArrivalCity())
                .getResultList();


        }else
        if (StringUtils.isNotBlank(filter.getReturnDate())&&isReturn) {
            final String str1 = filter.getReturnDate() + " 12:00:00";
            final LocalDateTime startDate = LocalDateTime.parse(str1, this.formatter);

            flights = this.entityManager.createQuery("  from Flight flight0_   left join flight0_.arrivalcity as arrivCity "
                    + "left join flight0_.departurecity as depCity " + " where :startDate BETWEEN flight0_.start_date AND flight0_.end_date "
                    + " and depCity.id=:departureCity and arrivCity.id=:arrivalCity")
                    .setParameter("startDate", startDate)
                    .setParameter("departureCity", filter.getArrivalCity())
                    .setParameter("arrivalCity", filter.getDeparturecity())
                    .getResultList();


        }


        return flights;
    }

    public static void main(final String[] args) {
        final String str = "2016-03-04 00:00:00";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        final LocalDateTime startDate = LocalDateTime.parse("2016-03-04" + " " + "00:00:00", formatter);
        System.out.println(startDate);
    }
}
