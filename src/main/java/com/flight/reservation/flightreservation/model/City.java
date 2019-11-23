package com.flight.reservation.flightreservation.model;

import javax.persistence.Entity;

@Entity
public class City extends AbstractEntity{

	private String city ;
	private String code;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
