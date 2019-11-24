package com.flight.reservation.flightreservation.filter;

public class FlightFilter {

	private String departureDate;
	private String returnDate ;
	private Integer  departurecity ;
	private Integer  arrivalCity;
	 
	
	 
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
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
