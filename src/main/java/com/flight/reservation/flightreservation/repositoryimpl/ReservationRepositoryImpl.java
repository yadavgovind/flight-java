package com.flight.reservation.flightreservation.repositoryimpl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.flight.reservation.flightreservation.dto.PassegerDto;
import com.flight.reservation.flightreservation.filter.ReservationFilter;
import com.flight.reservation.flightreservation.model.Reservation;
import com.flight.reservation.flightreservation.repository.ReservationRepositoryCustom;

@Transactional(
    readOnly = false)
public class ReservationRepositoryImpl implements ReservationRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public int findAvailableSeat(final ReservationFilter filter) {
        int sheat = 0;
        if (!StringUtils.isEmpty(filter.getJournyDate())) {
            String sheatType = "fl.business_seat";
            if (filter.getType()
                .equals("Economy")) {
                sheatType = "fl.numseats";
            }
            try {

                final Object object = this.entityManager.createNativeQuery("select (" + sheatType
                        + "- ifnull(sum( rs.total_seat),0)) from reservation as rs INNER JOIN flight as fl on fl.id =rs.flight_id where "
                        + " fl.id=:flightId and rs.type= :type and rs.is_cancel=FALSE and date(rs.travel_date) =STR_TO_DATE(:stdDate, '%Y-%m-%d')")

                    .setParameter("stdDate", filter.getJournyDate())
                    .setParameter("type", filter.getType())
                    .setParameter("flightId", filter.getFlightId())
                    .getResultList()
                    .get(0);
                sheat = new BigDecimal(String.valueOf(object)).intValue();
                if (sheat < 0) {
                    sheat = 0;
                }

            }
            catch (final Exception e) {

                e.printStackTrace();
            }

        }
        return sheat;
    }

    @Override
    public List<Reservation> getReservationByLoginId(final Long loginId) {
        return this.entityManager.createQuery(" from Reservation  as res left join " + " res.flight where  res.loginId=:loginId")
            .setParameter("loginId", loginId)
            .getResultList();
    }

    @Override
    public void cancelReservation(final Long resId) {
        this.entityManager.createNativeQuery("update reservation set is_cancel=true where id=:resId")
            .setParameter("resId", resId)
            .executeUpdate();
    }

    @Override
    public void changeSeat(final PassegerDto dto) {
        this.entityManager.createNativeQuery("update passenger set seat_no=:seatNo where id=:pid")
            .setParameter("seatNo", dto.getSeatNo())
            .setParameter("pid", dto.getId())
            .executeUpdate();
    }

	@Override
	public List<Reservation> getReservationsByDates(String date1, String date2) {
	 return	this.entityManager.createNativeQuery("from reservation as r where r.travel_date>=:date1 and r.travel_date<=:date2 and rs.is_cancel=TRUE")
		.setParameter("date1", date1)
		.setParameter("date2", date2)
		.getResultList();
		

	}

}
