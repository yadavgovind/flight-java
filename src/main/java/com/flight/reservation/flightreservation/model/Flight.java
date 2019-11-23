package com.flight.reservation.flightreservation.model;

import javax.persistence.Entity;

@Entity
public class Flight extends AbstractEntity{
	
	private String flightnumber;
	private String operatingairlines;
	private String departurecity;
	private String arrivalcity;
	private String dateofdeparture;
	private String dateofarrival;
	private Double economyprice;
	private int numseats;
	//private String flighttype;
	
	public String getFlightNumber() {
		return flightnumber;
	}
	public void setFlightNumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}
	public String getOperatingAirlines() {
		return operatingairlines;
	}
	public void setoperatingairlines(String operatingairlines) {
		this.operatingairlines = operatingairlines;
	}
	public String getDepartureCity() {
		return departurecity;
	}
	public void setDepartureCity(String departurecity) {
		this.departurecity = departurecity;
	}
	public String getArrivalCity() {
		return arrivalcity;
	}
	public void setArrivalCity(String arrivalcity) {
		this.arrivalcity = arrivalcity;
	}
	public String getDateOfDeparture() {
		return dateofdeparture;
	}
	
	public Double getPrice() {
		return economyprice;
	}
	public void setPrice(Double economyprice) {
		this.economyprice = economyprice;
	}
	public int getSeatNo() {
		return numseats;
	}
	public void setSeatNo(int numseats) {
		this.numseats = numseats;
	}/*	public String getFlightType() {
		return flighttype;
	}
	public void setFlightType(String flighttype) {
		this.flighttype = flighttype;
	}*/
	public String getDateofarrival() {
		return dateofarrival;
	}
	public void setDateofarrival(String dateofarrival) {
		this.dateofarrival = dateofarrival;
	}
}
