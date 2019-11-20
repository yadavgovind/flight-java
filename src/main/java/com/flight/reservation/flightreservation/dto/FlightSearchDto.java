package com.flight.reservation.flightreservation.dto;

import java.util.List;

import com.flight.reservation.flightreservation.model.Flight;

public class FlightSearchDto {
private List<Flight> arrivalFlightList;
private List<Flight> departFlightList;

public List<Flight> getArrivalFlightList() {
	return arrivalFlightList;
}
public void setArrivalFlightList(List<Flight> arrivalFlightList) {
	this.arrivalFlightList = arrivalFlightList;
}
public List<Flight> getDepartFlightList() {
	return departFlightList;
}
public void setDepartFlightList(List<Flight> departFlightList) {
	this.departFlightList = departFlightList;
}
}
