package com.flight.reservation.flightreservation.repositoryimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.flight.reservation.flightreservation.model.Reservation;
import org.springframework.util.StringUtils;

import com.flight.reservation.flightreservation.filter.ReservationFilter;
import com.flight.reservation.flightreservation.repository.ReservationRepositoryCustom;

public class ReservationRepositoryImpl implements ReservationRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public int findAvailableSeat(final ReservationFilter filter) {
        int sheat = 0;
        if (!StringUtils.isEmpty(filter.getJournyDate())) {
            final String str1 = filter.getJournyDate() + " 12:00:00";
            final LocalDateTime startDate = LocalDateTime.parse(str1, this.formatter);
            sheat = this.entityManager.createQuery(" select  sum(res.totalSeat) from Reservation  as res left join "
                    + " res.flight where  res.flight.id= :flightId and res.flight.start_date = :startDate and res.type=:type and  res.isCancel=false ")
                .setParameter("startDate", startDate)
                .setParameter("type", filter.getType())
                .setParameter("flightId", filter.getFlightId())
                .getFirstResult();
        }
        return sheat;
    }

    @Override
    public List<Reservation> getReservationByLoginId(Long loginId) {
        return this.entityManager.createQuery(" from Reservation  as res left join "
                + " res.flight where  res.loginId=:loginId").setParameter("loginId",loginId).getResultList();
    }
}
