package com.flight.reservation.flightreservation.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity 
{

	@OneToOne
	private Passenger Passenger;
	@OneToOne
	private Flight flight;
	
	private boolean isCheckedIn;
    private int numBags;
	public Passenger getPassenger() {
		return Passenger;
	}
	public void setPassenger(Passenger passenger) {
		Passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public boolean isCheckedIn() {
		return isCheckedIn;
	}
	public void setCheckedIn(boolean isCheckedIn) {
		this.isCheckedIn = isCheckedIn;
	}
	public int getNumBags() {
		return numBags;
	}
	public void setNumBags(int numBags) {
		this.numBags = numBags;
	}
    
    
}
