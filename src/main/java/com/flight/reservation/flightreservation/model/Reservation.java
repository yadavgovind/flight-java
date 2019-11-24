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
    private int passengerId;
    private int seatNo;
    private boolean isCancel;
    private int loginId;
     
     
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
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public boolean isCancel() {
		return isCancel;
	}
	public void setCancel(boolean isCancel) {
		this.isCancel = isCancel;
	}
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
    
    
}
