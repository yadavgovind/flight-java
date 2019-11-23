package com.flight.reservation.flightreservation.filter;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class FlightFilter {

	private LocalDateTime start_date;
	private LocalDateTime end_date ;
	private Integer  departurecity ;
	private Integer  arrivalCity;
	 
	
	public LocalDateTime getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDateTime start_date) {
		this.start_date = start_date;
	}
	public LocalDateTime getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDateTime end_date) {
		this.end_date = end_date;
	}
	public Integer getDeparturecity() {
		return departurecity;
	}
	public void setDeparturecity(Integer departurecity) {
		this.departurecity = departurecity;
	}
	public Integer getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(Integer arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	
	
	
}
