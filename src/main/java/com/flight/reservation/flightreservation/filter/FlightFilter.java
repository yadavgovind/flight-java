package com.flight.reservation.flightreservation.filter;

public class FlightFilter {

	private String startDate;
	private String endDate ;
	private Integer  departurecity ;
	private Integer  arrivalCity;
	 
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String start_date) {
		this.startDate = start_date;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String end_date) {
		this.endDate = end_date;
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
