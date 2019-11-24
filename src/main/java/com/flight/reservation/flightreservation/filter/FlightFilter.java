package com.flight.reservation.flightreservation.filter;

public class FlightFilter {

	private String travellDate;
	private String returnDate ;
	private Integer  departurecity ;
	private Integer  arrivalCity;
	 
	
	 
 
public String getTravellDate() {
		return travellDate;
	}
	public void setTravellDate(String travellDate) {
		this.travellDate = travellDate;
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
