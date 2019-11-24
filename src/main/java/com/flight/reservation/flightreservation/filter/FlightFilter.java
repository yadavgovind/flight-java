package com.flight.reservation.flightreservation.filter;

public class FlightFilter {
 

	private String travellDate;
	private String returnDate ;
	private Long  departurecity ;
	private Long  arrivalCity;
	 
	
	 
 
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

	public Long getDeparturecity() {
		return departurecity;
	}
	public void setDeparturecity(Long departurecity) {
		this.departurecity = departurecity;
	}
	public Long getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(Long arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	
	
	
}
