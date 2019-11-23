package com.flight.reservation.flightreservation.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;

@Entity
public class Flight extends AbstractEntity{
	
	private String flightnumber;
	private String operatingairlines;
	 
	private String arrivalcity;
//	private String dateofdeparture;
//	private String dateofarrival;
	private Double economyprice;
	 
	private String arrival_time;
	private String depature_time ;
	private Integer  departurecity ;
	private Integer numseats ;
	private String duration ;
	private LocalDateTime start_date ;
	private LocalDateTime end_date  ;
	private Integer business_seat ;
	private Double business_price ;
	private Integer checkin_baggage ;
	private Integer hand_baggage ;
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
	 
	public String getArrivalCity() {
		return arrivalcity;
	}
	public void setArrivalCity(String arrivalcity) {
		this.arrivalcity = arrivalcity;
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
	} 
	 
	public String getFlightnumber() {
		return flightnumber;
	}
	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}
	public String getOperatingairlines() {
		return operatingairlines;
	}
	public void setOperatingairlines(String operatingairlines) {
		this.operatingairlines = operatingairlines;
	}
	public String getArrivalcity() {
		return arrivalcity;
	}
	public void setArrivalcity(String arrivalcity) {
		this.arrivalcity = arrivalcity;
	}
	 
	public Double getEconomyprice() {
		return economyprice;
	}
	public void setEconomyprice(Double economyprice) {
		this.economyprice = economyprice;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getDepature_time() {
		return depature_time;
	}
	public void setDepature_time(String depature_time) {
		this.depature_time = depature_time;
	}
	public Integer getDeparturecity() {
		return departurecity;
	}
	public void setDeparturecity(Integer departurecity) {
		this.departurecity = departurecity;
	}
	public Integer getNumseats() {
		return numseats;
	}
	public void setNumseats(Integer numseats) {
		this.numseats = numseats;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
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
	public Integer getBusiness_seat() {
		return business_seat;
	}
	public void setBusiness_seat(Integer business_seat) {
		this.business_seat = business_seat;
	}
	public Double getBusiness_price() {
		return business_price;
	}
	public void setBusiness_price(Double business_price) {
		this.business_price = business_price;
	}
	public Integer getCheckin_baggage() {
		return checkin_baggage;
	}
	public void setCheckin_baggage(Integer checkin_baggage) {
		this.checkin_baggage = checkin_baggage;
	}
	public Integer getHand_baggage() {
		return hand_baggage;
	}
	public void setHand_baggage(Integer hand_baggage) {
		this.hand_baggage = hand_baggage;
	}
	
	
}
